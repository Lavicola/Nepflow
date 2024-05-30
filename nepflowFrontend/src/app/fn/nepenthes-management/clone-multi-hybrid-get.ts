/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { HybridCloneDto } from '../../models/hybrid-clone-dto';

export interface CloneMultiHybridGet$Params {
}

export function cloneMultiHybridGet(http: HttpClient, rootUrl: string, params?: CloneMultiHybridGet$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<HybridCloneDto>>> {
  const rb = new RequestBuilder(rootUrl, cloneMultiHybridGet.PATH, 'get');
  if (params) {
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Array<HybridCloneDto>>;
    })
  );
}

cloneMultiHybridGet.PATH = '/clone/multi-hybrid/';