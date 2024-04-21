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
import {ReactiveFormsModule} from "@angular/forms";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatMenuModule} from "@angular/material/menu";

@NgModule({
  declarations: [
    AppComponent,
    UserOverviewComponent,
    NepenthesOverviewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    MatInputModule,
    MatSelectModule,
    ReactiveFormsModule,
    MatToolbarModule,
    MatMenuModule
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
