/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { NepenthesDto } from '../../models/nepenthes-dto';

export interface NepenthesPost$Params {
      body: NepenthesDto
}

export function nepenthesPost(http: HttpClient, rootUrl: string, params: NepenthesPost$Params, context?: HttpContext): Observable<StrictHttpResponse<NepenthesDto>> {
  const rb = new RequestBuilder(rootUrl, nepenthesPost.PATH, 'post');
  if (params) {
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<NepenthesDto>;
    })
  );
}

nepenthesPost.PATH = '/nepenthes';
