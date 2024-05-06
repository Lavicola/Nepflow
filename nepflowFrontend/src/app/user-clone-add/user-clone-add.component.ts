import {Component} from '@angular/core';
import {
  DropdownSharedSelectedNepenthesNameService
} from "../ComponentService/DropdownSharedSelectedNepenthesNameService";
import {DropdownSharedSelectedCloneIdService} from "../ComponentService/DropdownSharedSelectedCloneIdService";
import {UserCloneDto} from "../models/user-clone-dto";
import {GrowlistmanagementService} from "../services/growlistmanagement.service";

@Component({
  selector: 'app-user-clone-add',
  templateUrl: './user-clone-add.component.html',
  styleUrls: ['./user-clone-add.component.css']
})
export class UserCloneAddComponent {

  selectedNepenthes: string = "";
  selectedClone: string = "";
  clone: UserCloneDto = {};


  constructor(public growlistService: GrowlistmanagementService,
              private dropdownServiceNepenthes: DropdownSharedSelectedNepenthesNameService,
              private dropdownServiceClones: DropdownSharedSelectedCloneIdService
  ) {
    this.dropdownServiceNepenthes.getSelectedValue().subscribe(nepenthesName =>
      this.selectedNepenthes = nepenthesName,
    );
    this.dropdownServiceClones.getSelectedValue().subscribe(cloneId =>
      this.selectedClone = cloneId,
    );


  }

  addNepenthesToCollection() {
    this.clone = {
      cloneId: this.selectedClone,
      nepenthesName: this.selectedNepenthes,
    }
    this.growlistService.userNepenthesPost({body: this.clone}).subscribe({
      next: (userCloneDTO) => this.clone = userCloneDTO,
      error: (error) => console.log(error)
    })

  }
}
