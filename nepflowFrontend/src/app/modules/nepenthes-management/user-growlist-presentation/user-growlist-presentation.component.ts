import {Component, Input} from '@angular/core';
import {SpecimenUpdateCloneDto} from "../models/specimen-update-clone-dto";
import {GrowlistmanagementService} from "../services/growlistmanagement.service";
import {ImageManagementService} from "../../core/Image/services/image-management.service";
import {SpecimenCloneDto} from "../models/specimen-clone-dto";

@Component({
  selector: 'app-user-growlist-presentation',
  templateUrl: './user-growlist-presentation.component.html',
  styleUrl: './user-growlist-presentation.component.css'
})
export class UserGrowlistPresentationComponent {

  @Input() specimens: SpecimenCloneDto[] = [];

  constructor(private growmanagementService: GrowlistmanagementService,
              private ImageManagementService: ImageManagementService,

  ){


  }





  onImageClick(i: any) {
    const fileInput = document.querySelectorAll<HTMLInputElement>('input[type="file"]')[i];
    if (fileInput) {
      fileInput.click();
    }
  }

  onFileSelected($event: Event, index: number,specimenId:string) {
    // @ts-ignore
    const input = event.target as HTMLInputElement;
    if( !(input.files?.length == 1 && input.files.item(0) instanceof Blob)) {
      return
    }
    let file = input.files.item(0)

    let tmp: SpecimenUpdateCloneDto = {
      file:file as Blob,
    }

    this.growmanagementService.growlistClonesSpecimenIdPut({specimenId:specimenId,body:tmp}).subscribe({
      // @ts-ignore
      next: () => this.specimens[index].filelocation = URL.createObjectURL(file)
    })

  }

  changeOfferStatus(i: number) {
    let specimenId = this.specimens[i]?.specimenId ?? undefined;
    let flowering = this.specimens[i]?.isFlowering ?? undefined;
    console.log(specimenId)
    if(specimenId && flowering != undefined){
      this.growmanagementService.growlistClonesSpecimenIdFloweringPatch({specimenId:specimenId,body:{isFlowering:!flowering}}).subscribe({
        next: (updateDTO) => this.specimens[i].isFlowering = !flowering,
        error: () => console.log("error")
      })
    }



  }
}
