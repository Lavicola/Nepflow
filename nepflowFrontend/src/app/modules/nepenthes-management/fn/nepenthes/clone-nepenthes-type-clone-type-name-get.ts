/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';

import { CloneType } from '../../models/clone-type';
import { LabelClonesDto } from '../../models/label-clones-dto';
import { NepenthesType } from '../../models/nepenthes-type';
import {StrictHttpResponse} from "../../../../strict-http-response";
import { RequestBuilder } from '../../../../request-builder';

export interface CloneNepenthesTypeCloneTypeNameGet$Params {
  nepenthesType: NepenthesType;
  cloneType: CloneType;
  name: string;
}

export function cloneNepenthesTypeCloneTypeNameGet(http: HttpClient, rootUrl: string, params: CloneNepenthesTypeCloneTypeNameGet$Params, context?: HttpContext): Observable<StrictHttpResponse<LabelClonesDto>> {
  const rb = new RequestBuilder(rootUrl, cloneNepenthesTypeCloneTypeNameGet.PATH, 'get');
  if (params) {
    rb.path('nepenthesType', params.nepenthesType, {});
    rb.path('cloneType', params.cloneType, {});
    rb.path('name', params.name, {});
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<LabelClonesDto>;
    })
  );
}

cloneNepenthesTypeCloneTypeNameGet.PATH = '/clone/{nepenthesType}/{cloneType}/{name}';
