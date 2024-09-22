/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import {RequestBuilder} from "../../../../core/openApiGeneratedFiles/request-builder";
import {StrictHttpResponse} from "../../../../core/openApiGeneratedFiles/strict-http-response";

import { CloneDto } from '../../models/clone-dto';

export interface ClonesGet$Params {
  cloneIds: Array<string>;
}

export function clonesGet(http: HttpClient, rootUrl: string, params: ClonesGet$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<CloneDto>>> {
  const rb = new RequestBuilder(rootUrl, clonesGet.PATH, 'get');
  if (params) {
    rb.query('cloneIds', params.cloneIds, {});
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Array<CloneDto>>;
    })
  );
}

clonesGet.PATH = '/clones';
