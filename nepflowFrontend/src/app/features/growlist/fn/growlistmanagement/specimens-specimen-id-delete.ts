/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import {RequestBuilder} from "../../../../core/openApiGeneratedFiles/request-builder";
import {StrictHttpResponse} from "../../../../core/openApiGeneratedFiles/strict-http-response";

export interface SpecimensSpecimenIdDelete$Params {
  specimenId: string;
}

export function specimensSpecimenIdDelete(http: HttpClient, rootUrl: string, params: SpecimensSpecimenIdDelete$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
  const rb = new RequestBuilder(rootUrl, specimensSpecimenIdDelete.PATH, 'delete');
  if (params) {
    rb.path('specimenId', params.specimenId, {});
  }

  return http.request(
    rb.build({ responseType: 'text', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return (r as HttpResponse<any>).clone({ body: undefined }) as StrictHttpResponse<void>;
    })
  );
}

specimensSpecimenIdDelete.PATH = '/specimens/{specimenId}';
