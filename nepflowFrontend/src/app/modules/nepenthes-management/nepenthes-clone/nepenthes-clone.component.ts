import {Component} from '@angular/core';
import {NepenthesDropdownSharedLabelService} from "../services/NepenthesDropdownSharedLabelService";
import {SharedNepenthesRequestWrapper} from "../services/SharedNepenthesRequestWrapper";
import {NepenthesRequestWrapper} from "../services/NepenthesRequestWrapper";
import {LabelDto} from "../models/label-dto";
import {LabelClonesDto} from "../models/label-clones-dto";
import {CloneDto} from "../models/clone-dto";
import {CloneType} from "../models/clone-type";
import {BehaviorSubject, Observable} from "rxjs";

@Component({
  selector: 'app-nepenthes-clone',
  templateUrl: './nepenthes-clone.component.html',
  styleUrl: './nepenthes-clone.component.css'
})
export class NepenthesCloneComponent {

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
        next: (label) => {
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
      error: (error) => console.log(error)
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
