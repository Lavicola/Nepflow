/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { IvCloneDto } from '../../models/iv-clone-dto';

export interface CloneMultiHybridIvPost$Params {
      body: IvCloneDto
}

export function cloneMultiHybridIvPost(http: HttpClient, rootUrl: string, params: CloneMultiHybridIvPost$Params, context?: HttpContext): Observable<StrictHttpResponse<IvCloneDto>> {
  const rb = new RequestBuilder(rootUrl, cloneMultiHybridIvPost.PATH, 'post');
  if (params) {
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<IvCloneDto>;
    })
  );
}

cloneMultiHybridIvPost.PATH = '/clone/multi-hybrid/iv';
