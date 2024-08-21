/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';

import { SpecimenUpdateSex } from '../../models/specimen-update-sex';
import {RequestBuilder} from "../../../../core/openApiGeneratedFiles/request-builder";
import {StrictHttpResponse} from "../../../../core/openApiGeneratedFiles/strict-http-response";

export interface SpecimensSpecimenIdSexPatch$Params {
  specimenId: string;
      body: SpecimenUpdateSex
}

export function specimensSpecimenIdSexPatch(http: HttpClient, rootUrl: string, params: SpecimensSpecimenIdSexPatch$Params, context?: HttpContext): Observable<StrictHttpResponse<SpecimenUpdateSex>> {
  const rb = new RequestBuilder(rootUrl, specimensSpecimenIdSexPatch.PATH, 'patch');
  if (params) {
    rb.path('specimenId', params.specimenId, {});
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<SpecimenUpdateSex>;
    })
  );
}

specimensSpecimenIdSexPatch.PATH = '/specimens/{specimenId}/sex';
