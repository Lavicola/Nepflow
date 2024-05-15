import {Component} from '@angular/core';
import {NepenthesManagementService} from "../services/nepenthes-management.service";
import {IcCloneDto} from "../models/ic-clone-dto";
import {NepenthesDto} from "../models/nepenthes-dto";
import {LocationDto} from "../models/location-dto";
import {CloneGrexDto} from "../models/clone-grex-dto";

@Component({
  selector: 'app-user-add-clone',
  templateUrl: './user-add-clone.component.html',
  styleUrls: ['./user-add-clone.component.css']
})
export class UserAddCloneComponent {

  cloneService: NepenthesManagementService;

  constructor(cloneService: NepenthesManagementService) {
    this.cloneService = cloneService;
  }


  IV() {

    let icCloneObject: IcCloneDto = {
      cloneId: 'BE-3225',
      name: 'villosa',
      grex: {},
      nepenthes: "villosa", // Assuming nepenthesName is not provided
      sex: 'Your Sex String',
      Location: "Borneo"
    };


    this.cloneService.cloneSpeciesIcPost({body: icCloneObject}).subscribe({
        next: () => console.log("called"),
        error: (error) => console.log(error),
      }
    )

  }

  IC() {

  }

}
