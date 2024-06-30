import {Component, Input, OnInit} from '@angular/core';
import {CloneDto} from "../models/clone-dto";
import {defer, Observable, startWith} from "rxjs";
import {FormControl} from "@angular/forms";
import {MatButtonToggleChange} from "@angular/material/button-toggle";
import {map} from "rxjs/operators";
import { LabelDto } from '../models/label-dto';
import { LabelClonesDto } from '../models/label-clones-dto';
import {ProducerDto} from "../models/producer-dto";
import {LabelCloneDto} from "../models/label-clone-dto";
import {NepenthesRequestWrapper} from "../services/NepenthesRequestWrapper";
import {NepenthesDropdownSharedLabelService} from "../services/NepenthesDropdownSharedLabelService";
import {SharedNepenthesRequestWrapper} from "../services/SharedNepenthesRequestWrapper";

@Component({
  selector: 'app-nepenthes-clone-dropdown',
  templateUrl: './nepenthes-clone-dropdown.component.html',
  styleUrl: './nepenthes-clone-dropdown.component.css'
})
export class NepenthesCloneDropdownComponent implements OnInit {


  readonly sexes:string[] = ["","Female","Male"]
  @Input() existingClones: Observable<CloneDto[]> = new Observable<CloneDto[]>();
  clonelist: CloneDto[] = []
  filteredOptions!: Observable<CloneDto[]>;
  cloneId: FormControl = new FormControl("");
  producerControl: FormControl = new FormControl("");
  descriptionControl: FormControl = new FormControl("");
  locationControl: FormControl = new FormControl("");
  selectedGender: string = "";


  constructor(
  ) {

  }

  ngOnInit(): void {
    this.existingClones.subscribe(clones => {
      this.clonelist = clones
    });
    this.filteredOptions = this.cloneId.valueChanges.pipe(
      startWith(''),
      map(value => this._filter(value || '')),
    );
  }

  private _filter(value: string): CloneDto[] {
    const filterValue = value.toLowerCase();
    return this.clonelist.filter(option => option.cloneId?.toLowerCase().includes(filterValue));
  }

  setCloneValues() {
    console.log(this.existingClones.forEach(
    (clone) => console.log(clone)
    ))
  }
}
