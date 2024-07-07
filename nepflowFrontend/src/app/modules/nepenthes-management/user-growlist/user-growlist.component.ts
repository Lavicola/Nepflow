import {Component, OnInit} from '@angular/core';
import {GrowlistmanagementService} from "../services/growlistmanagement.service";
import {GrowlistDto} from "../models/growlist-dto";
import {BehaviorSubject, Observable} from "rxjs";
import {SpecimenCloneDto} from "../models/specimen-clone-dto";
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

  constructor(private growmanagementService: GrowlistmanagementService) {
    this.growlist.subscribe({
      next: (growlist) => {
        if (growlist.specimens) {
          this.specimens = growlist.specimens;
        }
      }
    })
  }

//TODO get Username via routing/url
  ngOnInit(): void {
    this.growmanagementService.growlistUsernameClonesGet({username: "lavicola"}).subscribe({
      next: (growlist) => this.growlistSubject.next(growlist),
      error: () => console.log("error")
    })


  }


  onImageClick(i: any) {
    const fileInput = document.querySelectorAll<HTMLInputElement>('input[type="file"]')[i];
    if (fileInput) {
      fileInput.click();
    }
  }

  onFileSelected($event: Event, i: any) {

    //TODO
    // @ts-ignore
    const input = event.target as HTMLInputElement;
    if(input.files?.length == 1 && input.files.item(0) instanceof Blob){
      let tmp: SpecimenUpdateCloneDto = {
        file:input.files.item(0) as Blob,
      }

      this.growmanagementService.growlistClonesSpecimenIdPut({specimenId:"sss",body: tmp}).subscribe({
        next: (specimen) => console.log("nice")


      })


      console.log(input.files.item(0))
    }






  }
}
