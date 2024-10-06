/* tslint:disable */
/* eslint-disable */
import {HttpClient, HttpContext, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import {filter, map} from 'rxjs/operators';
import {RequestBuilder} from '../../../../core/openApiGeneratedFiles/request-builder';
import {StrictHttpResponse} from '../../../../core/openApiGeneratedFiles/strict-http-response';
import {UserDto} from "../../../../core/models/user-dto";


export interface UserPost$Params {

    /**
     * empty body
     */
    body: UserDto
}

export function userPost(http: HttpClient, rootUrl: string, params: UserPost$Params, context?: HttpContext): Observable<StrictHttpResponse<UserDto>> {
  const rb = new RequestBuilder(rootUrl, userPost.PATH, 'post');
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

userPost.PATH = '/user';
