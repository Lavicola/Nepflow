import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { NepenthesManagementRoutingModule } from './nepenthes-management-routing.module';
import {MatAutocomplete, MatAutocompleteTrigger, MatOption} from "@angular/material/autocomplete";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {MatButtonToggle, MatButtonToggleGroup} from "@angular/material/button-toggle";
import { NepenthesDropdownComponent } from './nepenthes-dropdown/nepenthes-dropdown.component';
import { NepenthesCloneDropdownComponent } from './nepenthes-clone-dropdown/nepenthes-clone-dropdown.component';


@NgModule({
    declarations: [

         NepenthesDropdownComponent,
         NepenthesCloneDropdownComponent
  ],
    exports: [
    ],
    imports: [
        CommonModule,
        NepenthesManagementRoutingModule,
        MatAutocompleteTrigger,
        ReactiveFormsModule,
        MatAutocomplete,
        MatOption,
        MatLabel,
        MatFormField,
        MatInputModule,
        MatButtonToggleGroup,
        MatButtonToggle,
        FormsModule

    ]
})
export class NepenthesManagementModule { }