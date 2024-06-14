/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { RequestBuilder } from '../../../../request-builder';
import { StrictHttpResponse } from '../../../../strict-http-response';

import { UserDto } from '../../models/user-dto';

export interface UserPut$Params {
  
    /**
     * User DTO with all changeable values
     */
    body: UserDto
}

export function userPut(http: HttpClient, rootUrl: string, params: UserPut$Params, context?: HttpContext): Observable<StrictHttpResponse<UserDto>> {
  const rb = new RequestBuilder(rootUrl, userPut.PATH, 'put');
  if (params) {
    rb.body(params.body, 'application/json');
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

userPut.PATH = '/user';
