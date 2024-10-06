/* tslint:disable */
/* eslint-disable */
import {HttpClient, HttpContext, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import {filter, map} from 'rxjs/operators';
import {RequestBuilder} from "../../../../core/openApiGeneratedFiles/request-builder";
import {StrictHttpResponse} from "../../../../core/openApiGeneratedFiles/strict-http-response";
import {GrowlistPublic} from '../../models/growlist-public';

export interface GrowlistGrowlistIdPublicPatch$Params {
  growlistId: string;
      body: GrowlistPublic
}

export function growlistGrowlistIdPublicPatch(http: HttpClient, rootUrl: string, params: GrowlistGrowlistIdPublicPatch$Params, context?: HttpContext): Observable<StrictHttpResponse<GrowlistPublic>> {
  const rb = new RequestBuilder(rootUrl, growlistGrowlistIdPublicPatch.PATH, 'patch');
  if (params) {
    rb.path('growlistId', params.growlistId, {});
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<GrowlistPublic>;
    })
  );
}

growlistGrowlistIdPublicPatch.PATH = '/growlist/{growlistId}/public';
