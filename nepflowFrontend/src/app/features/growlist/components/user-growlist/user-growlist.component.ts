import {Component, OnInit} from '@angular/core';
import {SpecimenUpdateCloneDto} from "../../models/specimen-update-clone-dto";
import {GrowlistmanagementService} from "../../services/growlistmanagement.service";
import {ActivatedRoute} from "@angular/router";
import {SpecimenCloneDto} from "../../models/specimen-clone-dto";
import {BehaviorSubject, catchError, combineLatest, of, switchMap} from "rxjs";
import {GrowlistDto} from "../../models/growlist-dto";
import {MatExpansionPanelActionRow} from "@angular/material/expansion";
import {MatSlideToggle} from "@angular/material/slide-toggle";
import {
  MatCard,
  MatCardContent,
  MatCardHeader,
  MatCardLgImage,
  MatCardSubtitle,
  MatCardTitle
} from "@angular/material/card";
import {MatDivider} from "@angular/material/divider";
import {AsyncPipe, NgForOf, NgIf} from "@angular/common";
import {
  NepenthesBasecardComponent
} from "../../../pollenexchange/components/nepenthes-basecard/nepenthes-basecard.component";
import {MatButton} from "@angular/material/button";
import {AuthService} from "../../../../core/services/auth.service";
import {ImageCroppedEvent, ImageCropperComponent, LoadedImage} from "ngx-image-cropper";
import {DomSanitizer, SafeUrl} from "@angular/platform-browser";

@Component({
  selector: 'app-user-growlist',
  standalone: true,
  imports: [
    NgForOf,
    ImageCropperComponent,
    MatExpansionPanelActionRow,
    MatSlideToggle,
    MatCardContent,
    MatCardHeader,
    MatCard,
    MatDivider,
    NgIf,
    AsyncPipe,
    NepenthesBasecardComponent,
    MatCardLgImage,
    MatCardSubtitle,
    MatCardTitle,
    MatButton,
    ImageCropperComponent
  ],
  templateUrl: './user-growlist.component.html',
  styleUrl: './user-growlist.component.sass'
})
export class UserGrowlistComponent implements OnInit {

  growlistSubject = new BehaviorSubject<GrowlistDto>({});
  growlist = this.growlistSubject.asObservable();
  specimens: SpecimenCloneDto[] = [];

  isOwnGrowlistSubject = new BehaviorSubject(false);
  isOwnGrowlist$ = this.isOwnGrowlistSubject.asObservable()
  isGrowlistPublicSubject = new BehaviorSubject(false);
  isGrowlistPublic$ = this.isOwnGrowlistSubject.asObservable()


  constructor(private growmanagementService: GrowlistmanagementService,
              private usernameService: AuthService,
              private route: ActivatedRoute,
              private sanitizer:DomSanitizer
  ) {

  }


  onImageClick(i: any) {
    const fileInput = document.querySelectorAll<HTMLInputElement>('input[type="file"]')[i];
    if (fileInput) {
      fileInput.click();
    }
  }

  onFileSelected($event: Event, index: number, specimenId: string | undefined) {
    // @ts-ignore
    const input = event.target as HTMLInputElement;
    if (!(input.files?.length == 1 && input.files.item(0) instanceof Blob)) {
      return
    }
    let file = input.files.item(0)

    let tmp: SpecimenUpdateCloneDto = {
      file: file as Blob,
    }
    // @ts-ignore
    this.growmanagementService.specimensSpecimenIdImagePut({specimenId: specimenId, body: tmp}).subscribe({
      // @ts-ignore
      next: () => this.specimens[index].filelocation = URL.createObjectURL(file),
      error: (err) => console.log(err)
    })

  }

  changeOfferStatus(i: number) {
    let specimenId = this.specimens[i]?.specimenId ?? undefined;
    let flowering = this.specimens[i]?.isFlowering ?? undefined;
    if (specimenId && flowering != undefined && this.isOwnGrowlist$) {
      this.growmanagementService.specimensSpecimenIdFloweringPatch({
        specimenId: specimenId,
        body: {isFlowering: !flowering}
      }).subscribe({
        next: (updateDTO) => this.specimens[i].isFlowering = !flowering,
        error: () => console.log("error")
      })
    }


  }

  updateGrowlistVisibility() {
    if (!this.growlistSubject.value.id) {
      return;
    }

    this.growmanagementService.growlistGrowlistIdPublicPatch$Response({
      growlistId: this.growlistSubject.value.id,
      body: {isPublic: !this.growlistSubject.value.isPublic}
    }).subscribe({
      next: (growlistPublic) => this.growlistSubject.value.isPublic = growlistPublic.body.isPublic,
      error: (err) => console.log(err)
    })

  }

  ngOnInit(): void {



    // Combine both observables
    combineLatest([
      this.usernameService.getUser().pipe(
        catchError(() => {
          return of(null);
        })
      ),
      this.route.paramMap
    ]).pipe(
      switchMap(([currentUser, params]) => {
        const userParam = params.get('user');
        if (userParam) {
          // Fetch the growlist for the user in the URL
          this.getGrowlist(userParam);
          this.isOwnGrowlistSubject.next(userParam === currentUser?.username);
        } else if (currentUser?.username) {
          // Fetch the growlist for the current logged-in user if no userParam exists
          this.getGrowlist(currentUser?.username);
          this.isOwnGrowlistSubject.next(true);
        } else {
          console.log(currentUser?.username)
          this.isOwnGrowlistSubject.next(false);
        }
        return of(null);  // Return an observable to satisfy the switchMap requirement
      })
    ).subscribe({
      error: (err) => console.log('Error:', err)
    });


    this.growlist.subscribe({
      // @ts-ignore
      next: (growlist: GrowlistDto) => this.specimens = growlist.specimens,
      error: (err) => console.log(err)
    })
  }

  getGrowlist(username: string) {
    this.growmanagementService.growlistUsernameClonesGet({username: username}).subscribe({
      next: (growlist) => {
        this.growlistSubject.next(growlist)
        // @ts-ignore
        this.isGrowlistPublicSubject.next(growlist.isPublic)
      },
      error: () => console.log("error")
    })

  }

  deleteSpecimen(index: number, specimenId: string | undefined) {
    if (specimenId == undefined) {
      return;
    }
    this.growmanagementService.specimensSpecimenIdDelete({specimenId: specimenId}).subscribe({
      next: () => {
        const updatedSpecimens = this.specimens.filter((_, i) => i !== index);
        this.growlistSubject.next({
          ...this.specimens,
          specimens: updatedSpecimens
        });
      },
      error: (err: string) => console.log(err)
    })


  }
  imageChangedEvent: Event | null = null;
  croppedImage: SafeUrl  = '';

  fileChangeEvent(event: Event): void {
    this.imageChangedEvent = event;
  }
  imageCropped(event: ImageCroppedEvent) {
    if (event.objectUrl != null) {
      this.croppedImage = this.sanitizer.bypassSecurityTrustUrl(event.objectUrl);
    }
    // event.blob can be used to upload the cropped image
  }
  imageLoaded(image: LoadedImage) {
    // show cropper
  }
  cropperReady() {
    // cropper ready
  }
  loadImageFailed() {
    // show message
  }


}


