import {Component, Injector, OnInit} from '@angular/core';
import {NepenthesRequestWrapper} from "../services/NepenthesRequestWrapper";
import {FormControl} from "@angular/forms";
import {Observable, startWith} from "rxjs";
import {map} from "rxjs/operators";
import {NepenthesDropdownSharedLabelService} from "../services/NepenthesDropdownSharedLabelService";
import {SharedNepenthesRequestWrapper} from "../services/SharedNepenthesRequestWrapper";
import { LabelDto } from '../models/label-dto';

@Component({
  selector: 'app-nepenthes-dropdown',
  templateUrl: './nepenthes-dropdown.component.html',
  styleUrl: './nepenthes-dropdown.component.css'
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

  test() {

  }

  clearSelection() {
    this.plantSelected = false;
    this.nepenthesControl.setValue("")
  }
}
