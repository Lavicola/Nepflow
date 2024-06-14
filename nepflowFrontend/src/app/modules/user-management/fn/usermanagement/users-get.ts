/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { RequestBuilder } from '../../../../request-builder';
import { StrictHttpResponse } from '../../../../strict-http-response';

import { UserPrivacyDto } from '../../models/user-privacy-dto';

export interface UsersGet$Params {
}

export function usersGet(http: HttpClient, rootUrl: string, params?: UsersGet$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<UserPrivacyDto>>> {
  const rb = new RequestBuilder(rootUrl, usersGet.PATH, 'get');
  if (params) {
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Array<UserPrivacyDto>>;
    })
  );
}

usersGet.PATH = '/users';
