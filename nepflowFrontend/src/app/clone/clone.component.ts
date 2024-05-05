import {Component, OnInit} from '@angular/core';
import {Observable, startWith} from "rxjs";
import {FormControl} from "@angular/forms";
import {NepenthesManagementService} from "../services/nepenthes-management.service";
import {DropdownSharedSelectedNepenthesNameService} from "../ComponentService/DropdownSharedSelectedNepenthesNameService";
import {map} from "rxjs/operators";
import {DropdownSharedSelectedCloneIdService} from "../ComponentService/DropdownSharedSelectedCloneIdService";

@Component({
  selector: 'app-clone',
  templateUrl: './clone.component.html',
  styleUrls: ['./clone.component.css']
})
export class CloneComponent implements OnInit {

  selectedNepenthes: string = "";
  existingCloneList: string[] = []
  filteredOptions!: Observable<string[]>;

  cloneControl: FormControl = new FormControl("");

  constructor(public nepenthesService: NepenthesManagementService,
              private dropdownServiceNepenthes: DropdownSharedSelectedNepenthesNameService,
              private dropdownServiceClones: DropdownSharedSelectedCloneIdService
  ) {


  }

  ngOnInit(): void {
    this.filteredOptions = this.cloneControl.valueChanges.pipe(
      startWith(''),
      map(value => this._filter(value || '')),
    );
    this.dropdownServiceNepenthes.getSelectedValue().subscribe(value => {
      this.fetchClones(value)
    });

  }

  private _filter(value: string): string[] {
    const filterValue = value.toLowerCase();

    return this.existingCloneList.filter(option => option.toLowerCase().includes(filterValue));
  }


  private fetchClones(cloneId: string) {
    this.nepenthesService.nepenthesNameGet({name: cloneId}).subscribe({
      next: (nepenthesClones) => {
        // @ts-ignore
        this.existingCloneList = nepenthesClones.clones.map(clone => clone.id);
        this.filteredOptions = this.cloneControl.valueChanges.pipe(
          startWith(''),
          map(value => this._filter(value || '')),
        );
      },
      error: (error) => console.log(error)
    })


  }


  cloneSelected($event: MouseEvent, cloneID: string) {
    this.dropdownServiceClones.setSelectedValue(cloneID);
  }

}
