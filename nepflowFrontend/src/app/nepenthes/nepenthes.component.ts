import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {NepenthesDto} from "../models/nepenthes-dto";
import {Observable, startWith} from "rxjs";
import {NepenthesManagementService} from "../services/nepenthes-management.service";
import {map} from "rxjs/operators";
import {DropdownSharedSelectedNepenthesNameService} from "../ComponentService/DropdownSharedSelectedNepenthesNameService";

@Component({
  selector: 'app-nepenthes',
  templateUrl: './nepenthes.component.html',
  styleUrls: ['./nepenthes.component.css']
})
export class NepenthesComponent implements OnInit {

  existingNepenthesList: NepenthesDto[] = []
  filteredOptions!: Observable<string[]>;

  nepenthesControl: FormControl = new FormControl("");

  constructor(public nepenthesService: NepenthesManagementService,
              private dropdownService: DropdownSharedSelectedNepenthesNameService) {

  }

  ngOnInit(): void {
    this.fetchNepenthes();
    this.filteredOptions = this.nepenthesControl.valueChanges.pipe(
      startWith(''),
      map(value => this._filter(value || '')),
    );
  }

  private _filter(value: string): string[] {
    const filterValue = value.toLowerCase();

    return this.existingNepenthesList.filter(option => option.toLowerCase().includes(filterValue));
  }


  private fetchNepenthes() {
    this.nepenthesService.nepenthesGet().subscribe({
      next: (nepenthesList) => {
        this.existingNepenthesList = nepenthesList;
      },
      error: (error) => console.log(error)
    })

  }


  selectedNepenthes($event: MouseEvent, name: string) {
    this.dropdownService.setSelectedValue(name);
  }
}
