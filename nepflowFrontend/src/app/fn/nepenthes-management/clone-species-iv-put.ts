/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { SpeciesCloneDto } from '../../models/species-clone-dto';

export interface CloneSpeciesIvPut$Params {
      body: SpeciesCloneDto
}

export function cloneSpeciesIvPut(http: HttpClient, rootUrl: string, params: CloneSpeciesIvPut$Params, context?: HttpContext): Observable<StrictHttpResponse<SpeciesCloneDto>> {
  const rb = new RequestBuilder(rootUrl, cloneSpeciesIvPut.PATH, 'put');
  if (params) {
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<SpeciesCloneDto>;
    })
  );
}

cloneSpeciesIvPut.PATH = '/clone/species/iv';
