/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import {RequestBuilder} from "../../../../core/openApiGeneratedFiles/request-builder";
import {StrictHttpResponse} from "../../../../core/openApiGeneratedFiles/strict-http-response";

import { SpecimensBulkRequestDto } from '../../models/specimens-bulk-request-dto';

export interface GrowlistAddClonesPost$Params {
      body?: Array<string>
}

export function growlistAddClonesPost(http: HttpClient, rootUrl: string, params?: GrowlistAddClonesPost$Params, context?: HttpContext): Observable<StrictHttpResponse<SpecimensBulkRequestDto>> {
  const rb = new RequestBuilder(rootUrl, growlistAddClonesPost.PATH, 'post');
  if (params) {
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<SpecimensBulkRequestDto>;
    })
  );
}

growlistAddClonesPost.PATH = '/growlist/add/clones';
