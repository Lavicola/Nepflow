/* tslint:disable */
/* eslint-disable */
import {HttpClient, HttpContext, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import {filter, map} from 'rxjs/operators';
import {RequestBuilder} from '../../../core/openApiGeneratedFiles/request-builder';
import {StrictHttpResponse} from '../../../core/openApiGeneratedFiles/strict-http-response';

import {UserPrivacyDto} from '../../models/user-privacy-dto';

export interface UsersUsernameGet$Params {
  username: string;
}

export function usersUsernameGet(http: HttpClient, rootUrl: string, params: UsersUsernameGet$Params, context?: HttpContext): Observable<StrictHttpResponse<UserPrivacyDto>> {
  const rb = new RequestBuilder(rootUrl, usersUsernameGet.PATH, 'get');
  if (params) {
    rb.path('username', params.username, {});
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<UserPrivacyDto>;
    })
  );
}

usersUsernameGet.PATH = '/users/{username}';
