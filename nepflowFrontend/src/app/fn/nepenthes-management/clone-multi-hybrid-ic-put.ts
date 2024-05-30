/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { HybridCloneDto } from '../../models/hybrid-clone-dto';

export interface CloneMultiHybridIcPut$Params {
      body: HybridCloneDto
}

export function cloneMultiHybridIcPut(http: HttpClient, rootUrl: string, params: CloneMultiHybridIcPut$Params, context?: HttpContext): Observable<StrictHttpResponse<HybridCloneDto>> {
  const rb = new RequestBuilder(rootUrl, cloneMultiHybridIcPut.PATH, 'put');
  if (params) {
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<HybridCloneDto>;
    })
  );
}

cloneMultiHybridIcPut.PATH = '/clone/multi-hybrid/ic';