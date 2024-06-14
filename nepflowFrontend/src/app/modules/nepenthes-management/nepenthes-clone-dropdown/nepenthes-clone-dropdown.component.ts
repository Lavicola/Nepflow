import {Component, OnInit} from '@angular/core';
import {CloneDto} from "../models/clone-dto";
import {HybridCloneDto} from "../models/hybrid-clone-dto";
import {defer, Observable, startWith} from "rxjs";
import {FormControl} from "@angular/forms";
import {NepenthesDropdownSharedLabelService} from "../Services/NepenthesDropdownSharedLabelService";
import {NepenthesRequestWrapper} from "../Services/NepenthesRequestWrapper";
import {SharedNepenthesRequestWrapper} from "../Services/SharedNepenthesRequestWrapper";
import {MatButtonToggleChange} from "@angular/material/button-toggle";
import {map} from "rxjs/operators";
import { LabelDto } from '../models/label-dto';
import { LabelClonesDto } from '../models/label-clones-dto';
import {ProducerDto} from "../models/producer-dto";
import {LabelCloneDto} from "../models/label-clone-dto";

@Component({
  selector: 'app-nepenthes-clone-dropdown',
  templateUrl: './nepenthes-clone-dropdown.component.html',
  styleUrl: './nepenthes-clone-dropdown.component.css'
})
export class NepenthesCloneDropdownComponent implements OnInit {


  readonly sexes:string[] = ["","Female","Male"]
  nepenthesService!: NepenthesRequestWrapper;
  selectedLabel: LabelDto = {};

  existingClonesList: Array<CloneDto | HybridCloneDto> = []
  filteredOptions!: Observable<CloneDto[]>;

  cloneId: FormControl = new FormControl("");
  sexControl: FormControl = new FormControl("");
  producerControl: FormControl = new FormControl("");


  constructor(private sharedLabelService: NepenthesDropdownSharedLabelService,
              private nepenthesSharedService: SharedNepenthesRequestWrapper,
  ) {

  }

  ngOnInit(): void {
    this.sharedLabelService.getSelectedValue().subscribe(
      {
        next: (label) => {
          if (label && label.name) {
            this.selectedLabel = label;
          }
        }
      }
    )
    this.nepenthesSharedService.getSelectedValue().subscribe(
      {
        next: (nepenthesService: NepenthesRequestWrapper) => {
          if (nepenthesService) {
            this.nepenthesService = nepenthesService;
          }
        }
      }
    )
    this.filteredOptions = this.cloneId.valueChanges.pipe(
      startWith(''),
      map(value => this._filter(value || '')),
    );


  }

  fetchClones(nepenthesName: string): void {
    this.cloneId.setValue("")
    this.nepenthesService.cloneNepenthesTypeCloneTypeNameGet(nepenthesName).subscribe({
      next: (labelClonesDto: LabelClonesDto) => {
        if (labelClonesDto && labelClonesDto.clones) {
          this.existingClonesList = labelClonesDto.clones;

        }
      },
      error: (error) => console.log(error)
    })


    if (this.selectedLabel && this.selectedLabel.name) {
      this.nepenthesService.cloneNepenthesTypeCloneTypeNameGet(this.selectedLabel.name);
    }


  }

  private _filter(value: string): CloneDto[] {
    const filterValue = value.toLowerCase();
    return this.existingClonesList.filter(option => option.cloneId?.toLowerCase().includes(filterValue));
  }


  protected setInternalCloneId($event: MouseEvent, clone: CloneDto | undefined) {
    if (clone == undefined) {
      return
    }
    this.sexControl.setValue(clone?.sex)
    this.producerControl.setValue(clone.producer)

  }

  protected resetDropdownContentAndFetch() {
    this.createClone()
    this.existingClonesList = []
    this.cloneId.setValue("")
    if(this.selectedLabel && this.selectedLabel.name){
      this.fetchClones(this.selectedLabel.name)
    }
  }

  public createClone(){{
    let clone:LabelCloneDto = {
      label: this.selectedLabel,
      clone: {
        cloneId: this.cloneId.value,
        sex: this.sexControl.value,
        producer: this.producerControl.value
      }
    }
    console.log(clone)
    }
  }

  test() {
    this.createClone()
  }
}
