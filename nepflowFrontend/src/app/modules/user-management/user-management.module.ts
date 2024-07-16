import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {MatMenuModule} from "@angular/material/menu";

import {UserManagementRoutingModule} from './user-management-routing.module';
import {UserOverviewComponent} from './user-overview/user-overview.component';
import {MatSelectModule} from '@angular/material/select';
import {UserFirstStepComponent} from './user-first-step/user-first-step.component';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import {MatInputModule} from '@angular/material/input';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import {MatToolbarModule} from '@angular/material/toolbar';


@NgModule({
  declarations: [
    UserOverviewComponent,
    UserFirstStepComponent
  ],
  imports: [
    CommonModule,
    UserManagementRoutingModule,
    MatInputModule,
    MatSelectModule,
    ReactiveFormsModule,
    MatToolbarModule,
    MatMenuModule,
    MatAutocompleteModule,
    FormsModule,
    MatButtonModule,
    MatCardModule

  ]
})
export class UserManagementModule { }
