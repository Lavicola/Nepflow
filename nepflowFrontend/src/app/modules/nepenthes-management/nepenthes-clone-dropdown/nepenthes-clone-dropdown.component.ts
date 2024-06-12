import {Component, OnInit} from '@angular/core';
import {CloneDto} from "../../../models/clone-dto";
import {HybridCloneDto} from "../../../models/hybrid-clone-dto";
import {defer, Observable, startWith} from "rxjs";
import {FormControl} from "@angular/forms";
import {NepenthesDropdownSharedLabelService} from "../Services/NepenthesDropdownSharedLabelService";
import {NepenthesRequestWrapper} from "../Services/NepenthesRequestWrapper";
import {SharedNepenthesRequestWrapper} from "../Services/SharedNepenthesRequestWrapper";
import {MatButtonToggleChange} from "@angular/material/button-toggle";
import {LabelClonesDto} from "../../../models/label-clones-dto";
import {map} from "rxjs/operators";
import { LabelDto } from '../../../models/label-dto';

@Component({
  selector: 'app-nepenthes-clone-dropdown',
  templateUrl: './nepenthes-clone-dropdown.component.html',
  styleUrl: './nepenthes-clone-dropdown.component.css'
})
export class NepenthesCloneDropdownComponent implements OnInit {


  nepenthesService!: NepenthesRequestWrapper;
  selectedLabel: LabelDto = {};
  selectedClone: string = "";

  existingClonesList: Array<CloneDto | HybridCloneDto> = []
  filteredOptions!: Observable<CloneDto[]>;

  cloneControl: FormControl = new FormControl("");


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
    this.filteredOptions = this.cloneControl.valueChanges.pipe(
      startWith(''),
      map(value => this._filter(value || '')),
    );


  }

  fetchClones(nepenthesName: string): void {
    this.cloneControl.setValue("")
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


  protected setInternalCloneId($event: MouseEvent, internalCloneId: string | undefined) {
    if (internalCloneId == undefined) {
      return
    }
    this.selectedClone = internalCloneId;

  }


  protected resetDropdownContentAndFetch() {
    this.existingClonesList = []
    this.cloneControl.setValue("")
    if(this.selectedLabel && this.selectedLabel.name){
      this.fetchClones(this.selectedLabel.name)
    }
  }


}
