/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { HybridCloneDto } from '../../models/hybrid-clone-dto';

export interface CloneHybridsIvPost$Params {
      body: HybridCloneDto
}

export function cloneHybridsIvPost(http: HttpClient, rootUrl: string, params: CloneHybridsIvPost$Params, context?: HttpContext): Observable<StrictHttpResponse<HybridCloneDto>> {
  const rb = new RequestBuilder(rootUrl, cloneHybridsIvPost.PATH, 'post');
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

cloneHybridsIvPost.PATH = '/clone/hybrids/iv';
