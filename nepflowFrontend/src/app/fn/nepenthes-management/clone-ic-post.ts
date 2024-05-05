/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { CloneDto } from '../../models/clone-dto';

export interface CloneIcPost$Params {
  
    /**
     * Clone DTO with new values
     */
    body: CloneDto
}

export function cloneIcPost(http: HttpClient, rootUrl: string, params: CloneIcPost$Params, context?: HttpContext): Observable<StrictHttpResponse<CloneDto>> {
  const rb = new RequestBuilder(rootUrl, cloneIcPost.PATH, 'post');
  if (params) {
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<CloneDto>;
    })
  );
}

cloneIcPost.PATH = '/clone/ic';
