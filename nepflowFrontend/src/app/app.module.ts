import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserOverviewComponent } from './user-overview/user-overview.component';
import { NepenthesOverviewComponent } from './nepenthes-overview/nepenthes-overview.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {HeadersInterceptor} from "./headers.interceptor";
import {MatInputModule} from "@angular/material/input";
import {MatSelectModule} from "@angular/material/select";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatMenuModule} from "@angular/material/menu";
import {MatAutocompleteModule} from "@angular/material/autocomplete";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {NepenthesAddComponent} from "./nepenthes-add/nepenthes-add.component";
import {NepenthesComponent} from "./nepenthes/nepenthes.component";
import {CloneComponent} from "./clone/clone.component";
import {UserAddCloneComponent} from "./user-add-clone/user-add-clone.component";
import {HybridCloneComponent} from "./hybrid-clone/hybrid-clone.component";
import {MatButtonModule} from "@angular/material/button";
import {HybridInputFieldComponent} from "./hybrid-input-field/hybrid-input-field.component";
import {MatCardModule} from "@angular/material/card";

@NgModule({
  declarations: [
    AppComponent,
    UserOverviewComponent,
    NepenthesOverviewComponent,
    NepenthesComponent,
    NepenthesAddComponent,
    CloneComponent,
    NepenthesOverviewComponent,
    UserAddCloneComponent,
    HybridCloneComponent,
    HybridInputFieldComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    MatInputModule,
    MatSelectModule,
    ReactiveFormsModule,
    MatToolbarModule,
    MatMenuModule,
    MatAutocompleteModule,
    FormsModule,
    MatButtonModule,
    MatCardModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HeadersInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
