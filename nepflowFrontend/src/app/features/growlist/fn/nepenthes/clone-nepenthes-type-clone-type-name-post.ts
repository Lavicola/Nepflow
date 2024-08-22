/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import {Observable} from 'rxjs';
import {filter, map} from 'rxjs/operators';
import {RequestBuilder} from "../../../../core/openApiGeneratedFiles/request-builder";
import {StrictHttpResponse} from "../../../../core/openApiGeneratedFiles/strict-http-response";

import {CloneType} from '../../models/clone-type';
import {LabelCloneDto} from '../../models/label-clone-dto';
import {NepenthesType} from '../../models/nepenthes-type';

export interface CloneNepenthesTypeCloneTypeNamePost$Params {
  nepenthesType: NepenthesType;
  cloneType: CloneType;
  name: string;

    /**
     * Clone DTO with new values
     */
    body: LabelCloneDto
}

export function cloneNepenthesTypeCloneTypeNamePost(http: HttpClient, rootUrl: string, params: CloneNepenthesTypeCloneTypeNamePost$Params, context?: HttpContext): Observable<StrictHttpResponse<LabelCloneDto>> {
  const rb = new RequestBuilder(rootUrl, cloneNepenthesTypeCloneTypeNamePost.PATH, 'post');
  if (params) {
    rb.path('nepenthesType', params.nepenthesType, {});
    rb.path('cloneType', params.cloneType, {});
    rb.path('name', params.name, {});
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<LabelCloneDto>;
    })
  );
}

cloneNepenthesTypeCloneTypeNamePost.PATH = '/clone/{nepenthesType}/{cloneType}/{name}';
