/* tslint:disable */
/* eslint-disable */
import {HttpClient, HttpContext, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import {filter, map} from 'rxjs/operators';
import {RequestBuilder} from "../../../core/openApiGeneratedFiles/request-builder";
import {StrictHttpResponse} from "../../../core/openApiGeneratedFiles/strict-http-response";

import {SpecimenUpdateFlowerStatus} from '../../models/specimen-update-flower-status';

export interface GrowlistClonesSpecimenIdFloweringPatch$Params {
  specimenId: string;
      body: SpecimenUpdateFlowerStatus
}

export function growlistClonesSpecimenIdFloweringPatch(http: HttpClient, rootUrl: string, params: GrowlistClonesSpecimenIdFloweringPatch$Params, context?: HttpContext): Observable<StrictHttpResponse<SpecimenUpdateFlowerStatus>> {
  const rb = new RequestBuilder(rootUrl, growlistClonesSpecimenIdFloweringPatch.PATH, 'post');
  if (params) {
    rb.path('specimenId', params.specimenId, {});
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<SpecimenUpdateFlowerStatus>;
    })
  );
}

growlistClonesSpecimenIdFloweringPatch.PATH = '/growlist/clones/{specimenId}/flowering';
