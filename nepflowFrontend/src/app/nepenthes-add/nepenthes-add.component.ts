import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {NepenthesManagementService} from "../services/nepenthes-management.service";
import {NepenthesDto} from "../models/nepenthes-dto";
import {Observable, startWith} from "rxjs";
import {map} from "rxjs/operators";
import {DropdownSharedSelectedNepenthesNameService} from "../ComponentService/DropdownSharedSelectedNepenthesNameService";

@Component({
  selector: 'app-nepenthes-add',
  templateUrl: './nepenthes-add.component.html',
  styleUrls: ['./nepenthes-add.component.css']
})
export class NepenthesAddComponent implements OnInit {

  nepenthesForm: FormGroup
  selectedNepenthes: String = "";

  constructor(public nepenthesService: NepenthesManagementService,
              private dropdownService:DropdownSharedSelectedNepenthesNameService
              ) {
    this.nepenthesForm = new FormGroup({
      name: new FormControl<string>(''),
    });
    this.dropdownService.getSelectedValue().subscribe(value => {
      this.selectedNepenthes = value;
      console.log(this.selectedNepenthes)
    });

  }

  ngOnInit(): void {
  }



  addNepenthes() {
    /*
    if (this.existingNepenthesList.indexOf(this.nepenthesControl.value.toLowerCase()) != -1) {
      //TODO at some point use validator
      alert(this.nepenthesControl.value.toLowerCase() + " already exists")
    } else {
      this.nepenthesService.nepenthesPost({body: this.nepenthesControl.value.toLowerCase()}).subscribe({
        next: (newNep) => {
          console.log(newNep + "was created");
          this.existingNepenthesList.push(this.nepenthesControl.value.toLowerCase())

        },
        error: (error) => console.log(error)
      })


      this.existingNepenthesList.push(this.nepenthesControl.value.toLowerCase())
    }
*/
  }

}
