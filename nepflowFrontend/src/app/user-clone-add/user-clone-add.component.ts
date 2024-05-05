import { Component } from '@angular/core';
import {CloneComponent} from "../clone/clone.component";
import {NepenthesComponent} from "../nepenthes/nepenthes.component";
import {DropdownSharedSelectedNepenthesNameService} from "../ComponentService/DropdownSharedSelectedNepenthesNameService";
import {NepenthesManagementService} from "../services/nepenthes-management.service";
import {DropdownSharedSelectedCloneIdService} from "../ComponentService/DropdownSharedSelectedCloneIdService";

@Component({
  selector: 'app-user-clone-add',
  templateUrl: './user-clone-add.component.html',
  styleUrls: ['./user-clone-add.component.css']
})
export class UserCloneAddComponent {

  selectedNepenthes: string = "";
  selectedClone: string = "";


  constructor(public nepenthesService: NepenthesManagementService,
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
    console.log(this.selectedClone)
    console.log(this.selectedNepenthes)
  }
}
