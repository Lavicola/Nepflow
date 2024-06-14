import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { GrowlistManagementRoutingModule } from './growlist-management-routing.module';
import { SpecimenAddComponent } from './specimen-add/specimen-add.component';
import {NepenthesManagementModule} from "../nepenthes-management/nepenthes-management.module";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatAutocompleteTrigger} from "@angular/material/autocomplete";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";


@NgModule({
  declarations: [
    SpecimenAddComponent
  ],
  imports: [
    CommonModule,
    GrowlistManagementRoutingModule,
    NepenthesManagementModule,
    FormsModule,
    MatAutocompleteTrigger,
    MatFormField,
    MatInput,
    MatLabel,
    ReactiveFormsModule
  ]
})
export class GrowlistManagementModule { }
