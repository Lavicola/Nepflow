/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { NepenthesClonesDto } from '../../models/nepenthes-clones-dto';

export interface NepenthesNameGet$Params {
  name: string;
}

export function nepenthesNameGet(http: HttpClient, rootUrl: string, params: NepenthesNameGet$Params, context?: HttpContext): Observable<StrictHttpResponse<NepenthesClonesDto>> {
  const rb = new RequestBuilder(rootUrl, nepenthesNameGet.PATH, 'get');
  if (params) {
    rb.path('name', params.name, {});
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<NepenthesClonesDto>;
    })
  );
}

nepenthesNameGet.PATH = '/nepenthes/{name}';
