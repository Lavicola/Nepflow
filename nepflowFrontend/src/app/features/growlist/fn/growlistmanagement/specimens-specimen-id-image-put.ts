/* tslint:disable */
/* eslint-disable */
import {HttpClient, HttpContext, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import {filter, map} from 'rxjs/operators';
import {RequestBuilder} from "../../../../core/openApiGeneratedFiles/request-builder";
import {StrictHttpResponse} from "../../../../core/openApiGeneratedFiles/strict-http-response";
import {SpecimenUpdateImage} from '../../models/specimen-update-image';

export interface SpecimensSpecimenIdImagePut$Params {
  specimenId: string;
      body?: SpecimenUpdateImage
}

export function specimensSpecimenIdImagePut(http: HttpClient, rootUrl: string, params: SpecimensSpecimenIdImagePut$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
  const rb = new RequestBuilder(rootUrl, specimensSpecimenIdImagePut.PATH, 'put');
  if (params) {
    rb.path('specimenId', params.specimenId, {});
    rb.body(params.body, 'multipart/form-data');
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

specimensSpecimenIdImagePut.PATH = '/specimens/{specimenId}/image';
