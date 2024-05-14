/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { IcCloneDto } from '../../models/ic-clone-dto';

export interface CloneSpeciesIcPut$Params {
      body: IcCloneDto
}

export function cloneSpeciesIcPut(http: HttpClient, rootUrl: string, params: CloneSpeciesIcPut$Params, context?: HttpContext): Observable<StrictHttpResponse<IcCloneDto>> {
  const rb = new RequestBuilder(rootUrl, cloneSpeciesIcPut.PATH, 'put');
  if (params) {
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<IcCloneDto>;
    })
  );
}

cloneSpeciesIcPut.PATH = '/clone/species/ic';
