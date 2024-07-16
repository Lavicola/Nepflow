import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {HeadersInterceptor} from "./modules/core/headers.interceptor";
import {MatOption} from "@angular/material/core";
import {MatButton} from "@angular/material/button";
import {MatInputModule} from "@angular/material/input";
import {MatToolbar, MatToolbarModule} from "@angular/material/toolbar";
import {MatFormField, MatFormFieldModule, MatLabel} from "@angular/material/form-field";
import {CommonModule} from "@angular/common";
import {provideAnimations} from "@angular/platform-browser/animations";
import {provideAnimationsAsync} from '@angular/platform-browser/animations/async';
import {MatAutocomplete, MatAutocompleteTrigger} from '@angular/material/autocomplete';
import {MatButtonToggle, MatButtonToggleGroup} from '@angular/material/button-toggle';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatMenu, MatMenuModule, MatMenuTrigger} from "@angular/material/menu";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
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
    MatToolbarModule,
    HttpClientModule,
    MatToolbar,
    MatFormFieldModule,
    CommonModule,
    MatButton,
    MatMenu,
    MatMenuTrigger,
    MatMenuModule,

  ],
  providers: [
    provideAnimations(),
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HeadersInterceptor,
      multi: true
    },
    provideAnimationsAsync()

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
