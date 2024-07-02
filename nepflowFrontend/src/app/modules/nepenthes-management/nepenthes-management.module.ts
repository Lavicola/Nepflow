import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { NepenthesManagementRoutingModule } from './nepenthes-management-routing.module';
import {MatAutocomplete, MatAutocompleteTrigger, MatOption} from "@angular/material/autocomplete";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatFormField, MatFormFieldModule, MatLabel} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {MatButtonToggle, MatButtonToggleGroup} from "@angular/material/button-toggle";
import { NepenthesDropdownComponent } from './nepenthes-dropdown/nepenthes-dropdown.component';
import { NepenthesCloneDropdownComponent } from './nepenthes-clone-dropdown/nepenthes-clone-dropdown.component';
import {MatSelect} from "@angular/material/select";
import {MatIcon} from "@angular/material/icon";
import { NepenthesCloneComponent } from './nepenthes-clone/nepenthes-clone.component';
import { NepenthesCloneTableComponent } from './nepenthes-clone-table/nepenthes-clone-table.component';
import {MatTableModule} from "@angular/material/table";
import {MatCheckbox} from "@angular/material/checkbox";
import {MatMenu, MatMenuTrigger} from "@angular/material/menu";
import { UserGrowlistComponent } from './user-growlist/user-growlist.component';


@NgModule({
  declarations: [

    NepenthesDropdownComponent,
    NepenthesCloneDropdownComponent,
    NepenthesCloneComponent,
    NepenthesCloneTableComponent,
    UserGrowlistComponent,
  ],
  exports: [
    NepenthesCloneDropdownComponent
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
    FormsModule,
    MatSelect,
    MatIcon,
    MatTableModule,
    MatFormFieldModule,
    MatInputModule,
    MatCheckbox,
    MatMenu,
    MatMenuTrigger,
  ]
})
export class NepenthesManagementModule { }
