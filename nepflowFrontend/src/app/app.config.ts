import {ApplicationConfig} from '@angular/core';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import {HTTP_INTERCEPTORS, provideHttpClient, withInterceptorsFromDi} from "@angular/common/http";
import {HeadersInterceptor} from "./core/headers.interceptor";
import {provideRouter} from "@angular/router";
import {routes} from "./app.routes";

export const appConfig: ApplicationConfig = {

  providers: [provideAnimationsAsync(),
    provideRouter(routes),

    provideHttpClient(
      withInterceptorsFromDi(),
    ),
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HeadersInterceptor,
      multi: true,
    },




  ]
}
