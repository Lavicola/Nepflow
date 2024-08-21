import { Component } from '@angular/core';
import {MatButtonToggle, MatButtonToggleGroup} from "@angular/material/button-toggle";
import {LabelClonesDto} from "../../models/label-clones-dto";
import {NepenthesRequestWrapper} from "../../services/NepenthesRequestWrapper";
import {LabelDto} from "../../models/label-dto";
import {NepenthesDropdownSharedLabelService} from "../../services/NepenthesDropdownSharedLabelService";
import {BehaviorSubject, Observable} from "rxjs";
import {CloneDto} from "../../models/clone-dto";
import {CloneType} from "../../models/clone-type";
import {SharedNepenthesRequestWrapper} from "../../services/SharedNepenthesRequestWrapper";
import {NepenthesCloneTableComponent} from "../nepenthes-clone-table/nepenthes-clone-table.component";
import {NepenthesDropdownComponent} from "../nepenthes-dropdown/nepenthes-dropdown.component";

@Component({
  selector: 'app-add-existing-nepenthes',
  standalone: true,
  imports: [
    MatButtonToggle,
    NepenthesCloneTableComponent,
    MatButtonToggleGroup,
    NepenthesDropdownComponent
  ],
  templateUrl: './add-existing-nepenthes.component.html',
  styleUrl: './add-existing-nepenthes.component.sass'
})
export class AddExistingNepenthesComponent {


  selectedGender: string = "";
  nepenthesService!: NepenthesRequestWrapper;
  selectedLabel: LabelDto = {};
  private existingClonesSubject = new BehaviorSubject<CloneDto[]>([]);
  existingClones: Observable<CloneDto[]> = this.existingClonesSubject.asObservable();
  currentCloneType!: CloneType;




  constructor(private sharedLabelService: NepenthesDropdownSharedLabelService,
              private nepenthesSharedService: SharedNepenthesRequestWrapper,
  ) {

  }

  ngOnInit(): void {
    this.sharedLabelService.getSelectedValue().subscribe(
      {
        next: (label:LabelDto) => {
          if (label && label.nepenthesName) {
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
  }

  fetchClones(nepenthesName: string): void {
    this.nepenthesService.cloneNepenthesTypeCloneTypeNameGet(nepenthesName).subscribe({
      next: (labelClonesDto: LabelClonesDto) => {
        console.log("next")
        if (labelClonesDto && labelClonesDto.clones) {
          this.existingClonesSubject.next(labelClonesDto.clones)
        }
      },
      error: (error:string) => console.log(error)
    })


    if (this.selectedLabel && this.selectedLabel.nepenthesName) {
      this.nepenthesService.cloneNepenthesTypeCloneTypeNameGet(this.selectedLabel.nepenthesName);
    }

  }

  switchToIv() {
    let tmpCloneType = this.nepenthesService.switchToIv();
    if (this.currentCloneType == tmpCloneType) {
      return
    } else {
      this.currentCloneType = tmpCloneType;
      if (this.selectedLabel.nepenthesName) {
        this.fetchClones(this.selectedLabel.nepenthesName);
      }
    }
  }

  switchToIC() {
    let tmpCloneType = this.nepenthesService.switchToIc();
    if (this.currentCloneType == tmpCloneType) {
      return
    } else {
      this.currentCloneType = tmpCloneType;
      if (this.selectedLabel.nepenthesName) {
        this.fetchClones(this.selectedLabel.nepenthesName);
      }
    }
  }


}
