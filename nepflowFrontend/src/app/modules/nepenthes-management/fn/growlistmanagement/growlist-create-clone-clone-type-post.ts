/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import {RequestBuilder} from "../../../core/openApiGeneratedFiles/request-builder";
import {StrictHttpResponse} from "../../../core/openApiGeneratedFiles/strict-http-response";

import { CloneType } from '../../models/clone-type';
import { LabelCloneDto } from '../../models/label-clone-dto';
import { SpecimenCloneDto } from '../../models/specimen-clone-dto';

export interface GrowlistCreateCloneCloneTypePost$Params {
  cloneType: CloneType;
      body?: LabelCloneDto
}

export function growlistCreateCloneCloneTypePost(http: HttpClient, rootUrl: string, params: GrowlistCreateCloneCloneTypePost$Params, context?: HttpContext): Observable<StrictHttpResponse<SpecimenCloneDto>> {
  const rb = new RequestBuilder(rootUrl, growlistCreateCloneCloneTypePost.PATH, 'post');
  if (params) {
    rb.path('cloneType', params.cloneType, {});
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<SpecimenCloneDto>;
    })
  );
}

growlistCreateCloneCloneTypePost.PATH = '/growlist/create/clone/{cloneType}';
