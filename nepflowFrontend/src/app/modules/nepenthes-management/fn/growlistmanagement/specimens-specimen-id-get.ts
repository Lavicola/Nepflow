/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import {RequestBuilder} from "../../../core/openApiGeneratedFiles/request-builder";
import {StrictHttpResponse} from "../../../core/openApiGeneratedFiles/strict-http-response";

import { SpecimenCloneDto } from '../../models/specimen-clone-dto';

export interface SpecimensSpecimenIdGet$Params {
  specimenId: string;
}

export function specimensSpecimenIdGet(http: HttpClient, rootUrl: string, params: SpecimensSpecimenIdGet$Params, context?: HttpContext): Observable<StrictHttpResponse<SpecimenCloneDto>> {
  const rb = new RequestBuilder(rootUrl, specimensSpecimenIdGet.PATH, 'get');
  if (params) {
    rb.path('specimenId', params.specimenId, {});
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

specimensSpecimenIdGet.PATH = '/specimens/{specimenId}';
