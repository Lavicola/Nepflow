/* tslint:disable */
/* eslint-disable */
import {HttpClient, HttpContext, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import {filter, map} from 'rxjs/operators';
import {StrictHttpResponse} from '../../strict-http-response';
import {RequestBuilder} from '../../request-builder';

import {SpecimenUpdateCloneDto} from '../../models/specimen-update-clone-dto';

export interface GrowlistClonesSpecimenIdPut$Params {
  specimenId: string;
      body?: SpecimenUpdateCloneDto
}

export function growlistClonesSpecimenIdPut(http: HttpClient, rootUrl: string, params: GrowlistClonesSpecimenIdPut$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
  const rb = new RequestBuilder(rootUrl, growlistClonesSpecimenIdPut.PATH, 'put');
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

growlistClonesSpecimenIdPut.PATH = '/growlist/clones/{specimenId}';
