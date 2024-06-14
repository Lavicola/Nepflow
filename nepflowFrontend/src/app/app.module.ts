import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {HeadersInterceptor} from "./headers.interceptor";
import {MatCardModule} from "@angular/material/card";
import {MatOption, MatOptionModule} from "@angular/material/core";
import {MatButton, MatButtonModule} from "@angular/material/button";
import {MatInputModule} from "@angular/material/input";
import {MatSelectModule} from "@angular/material/select";
import {MatToolbar} from "@angular/material/toolbar";
import {MatFormField, MatFormFieldModule, MatLabel} from "@angular/material/form-field";
import {CommonModule} from "@angular/common";
import {provideAnimations} from "@angular/platform-browser/animations";
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { MatAutocomplete, MatAutocompleteTrigger } from '@angular/material/autocomplete';
import {MatButtonToggle, MatButtonToggleGroup } from '@angular/material/button-toggle';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

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


        HttpClientModule,
        MatToolbar,
        MatFormFieldModule,
        CommonModule,
        MatButton,
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
