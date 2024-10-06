/* tslint:disable */
/* eslint-disable */
import {HttpClient, HttpContext, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import {filter, map} from 'rxjs/operators';
import {RequestBuilder} from '../../../../core/openApiGeneratedFiles/request-builder';
import {StrictHttpResponse} from '../../../../core/openApiGeneratedFiles/strict-http-response';

import {UserDto} from "../../../../core/models/user-dto";

export interface UserGet$Params {
}

export function userGet(http: HttpClient, rootUrl: string, params?: UserGet$Params, context?: HttpContext): Observable<StrictHttpResponse<UserDto>> {
  const rb = new RequestBuilder(rootUrl, userGet.PATH, 'get');
  if (params) {
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<UserDto>;
    })
  );
}

userGet.PATH = '/user';
