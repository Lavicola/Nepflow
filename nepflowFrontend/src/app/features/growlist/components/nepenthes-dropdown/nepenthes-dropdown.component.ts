import {Component, Injector, OnInit} from '@angular/core';
import {FormControl, FormsModule, ReactiveFormsModule} from "@angular/forms";
import {Observable, startWith} from "rxjs";
import {map} from "rxjs/operators";
import {LabelDto} from "../../models/label-dto";
import {NepenthesRequestWrapper} from "../../services/NepenthesRequestWrapper";
import {NepenthesDropdownSharedLabelService} from "../../services/NepenthesDropdownSharedLabelService";
import {SharedNepenthesRequestWrapper} from "../../services/SharedNepenthesRequestWrapper";
import {MatButtonToggle, MatButtonToggleGroup} from "@angular/material/button-toggle";
import {MatFormField, MatLabel, MatSuffix} from "@angular/material/form-field";
import {MatAutocomplete, MatAutocompleteTrigger, MatOption} from "@angular/material/autocomplete";
import {MatIcon} from "@angular/material/icon";
import {AsyncPipe, NgForOf, NgIf} from "@angular/common";
import {MatInput} from "@angular/material/input";
import {MatIconButton} from "@angular/material/button";

@Component({
  selector: 'app-nepenthes-dropdown',
  standalone: true,
  imports: [
    MatButtonToggle,
    MatButtonToggleGroup,
    FormsModule,
    MatFormField,
    MatLabel,
    ReactiveFormsModule,
    MatAutocompleteTrigger,
    MatAutocomplete,
    MatOption,
    MatIcon,
    NgIf,
    MatInput,
    MatIconButton,
    MatSuffix,
    NgForOf,
    AsyncPipe
  ],
  templateUrl: './nepenthes-dropdown.component.html',
  styleUrl: './nepenthes-dropdown.component.sass'
})
export class NepenthesDropdownComponent implements OnInit {
  nepenthesService: NepenthesRequestWrapper;
  selectedLabel: LabelDto = {}

  existingNepenthesList: LabelDto[] = []
  filteredOptions!: Observable<LabelDto[]>;

  nepenthesControl: FormControl = new FormControl("");
  selectedButton: any;
  plantSelected: boolean = false;

  constructor(nepenthesService: NepenthesRequestWrapper,
    private injector: Injector,
    private sharedLabelService: NepenthesDropdownSharedLabelService,
    private sharedNepenthesRequestWrapperService:SharedNepenthesRequestWrapper
) {
    this.nepenthesService = nepenthesService
    this.sharedNepenthesRequestWrapperService.setSelectedValue(this.nepenthesService)
    this.sharedLabelService.setSelectedValue(this.selectedLabel)

  }

  ngOnInit(): void {
    this.fetchNepenthes();
    this.filteredOptions = this.nepenthesControl.valueChanges.pipe(
      startWith(''),
      map(value => this._filter(value || '')),
    );
  }

private _filter(value: string): LabelDto[] {
    const filterValue = value.toLowerCase();

    return this.existingNepenthesList.filter(option => option.nepenthesName?.toLowerCase().includes(filterValue));
  }


private fetchNepenthes() {
    this.nepenthesService.cloneNepenthesTypeGet().subscribe({
      next: (nepenthesList) => {

        this.existingNepenthesList = nepenthesList;
        this.nepenthesControl.setValue("")

      },
      error: (error) => console.log(error)
    })

  }


  selectedNepenthes($event: MouseEvent, selectedLabel: LabelDto | undefined) {
    console.log("call")
    if (selectedLabel != undefined) {
      this.selectedLabel = selectedLabel
      this.plantSelected = true
      this.sharedLabelService.setSelectedValue(this.selectedLabel)
    }else{
      this.plantSelected=false;
    }
  }

  resetDropdownContent(): void {
    this.fetchNepenthes()


  }


  clearSelection() {
    this.plantSelected = false;
    this.nepenthesControl.setValue("")
  }

}
