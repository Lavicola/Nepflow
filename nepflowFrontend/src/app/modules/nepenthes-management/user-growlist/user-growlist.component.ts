import {Component, Input, OnInit} from '@angular/core';
import {GrowlistmanagementService} from "../services/growlistmanagement.service";
import {GrowlistDto} from "../models/growlist-dto";
import {BehaviorSubject} from "rxjs";
import {SpecimenCloneDto} from "../models/specimen-clone-dto";
import {ImageManagementService} from "../../core/Image/services/image-management.service";
import {ActivatedRoute} from "@angular/router";
import {UsernameService} from "../../../services/UsernameService";
import {SpecimenUpdateCloneDto} from "../models/specimen-update-clone-dto";

@Component({
  selector: 'app-user-growlist',
  templateUrl: './user-growlist.component.html',
  styleUrl: './user-growlist.component.css'
})
export class UserGrowlistComponent implements OnInit {

  growlistSubject = new BehaviorSubject<GrowlistDto>({});
  growlist = this.growlistSubject.asObservable();
  specimens: SpecimenCloneDto[] = [];

  isOwnGrowlist!: boolean;

  constructor(private growmanagementService: GrowlistmanagementService,
              private usernameService: UsernameService,
              private route: ActivatedRoute
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
    if (specimenId && flowering != undefined && this.isOwnGrowlist) {
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
    if(!this.growlistSubject.value.id){
      return;
    }

    this.growmanagementService.growlistGrowlistIdPublicPatch$Response({
      growlistId: this.growlistSubject.value.id,
      body: {isPublic: !this.growlistSubject.value.isPublic}
    }).subscribe({
      next: (growlistPublic) =>  this.growlistSubject.value.isPublic = growlistPublic.body.isPublic,
      error: (err) => console.log(err)
    })

  }

  ngOnInit(): void {
    this.usernameService.getUsernameObs().subscribe({
      next: (currentUsername: string) => {
        console.log(currentUsername)
        this.route.paramMap.subscribe(params => {
          const userParam = params.get('user');
          if (userParam) {
            this.getGrowlist(userParam);
            this.isOwnGrowlist = userParam === currentUsername;
          } else {
            this.getGrowlist(currentUsername);
            this.isOwnGrowlist = true;
          }
        });
      }
    });

    this.growlist.subscribe({
      // @ts-ignore
      next: (growlist:GrowlistDto) => this.specimens = growlist.specimens,
      error: (err) => console.log(err)
    })
  }

  getGrowlist(username: string) {
    this.growmanagementService.growlistUsernameClonesGet({username: username}).subscribe({
      next: (growlist) => {
        this.growlistSubject.next(growlist)},
      error: () => console.log("error")
    })

  }

  deleteSpecimen(index: number, specimenId: string | undefined) {
    if(specimenId == undefined){
      return;
    }
    this.growmanagementService.specimensSpecimenIdDelete({specimenId:specimenId}).subscribe({
      next: () => {
        const updatedSpecimens = this.specimens.filter((_, i) => i !== index);
        this.growlistSubject.next({
          ...this.specimens,
          specimens: updatedSpecimens
        });
      },
      error: (err) => console.log(err)
    })


  }
}

