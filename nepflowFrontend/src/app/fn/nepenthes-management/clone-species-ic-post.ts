/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { SpeciesCloneDto } from '../../models/species-clone-dto';

export interface CloneSpeciesIcPost$Params {
  
    /**
     * Clone DTO with new values
     */
    body: SpeciesCloneDto
}

export function cloneSpeciesIcPost(http: HttpClient, rootUrl: string, params: CloneSpeciesIcPost$Params, context?: HttpContext): Observable<StrictHttpResponse<SpeciesCloneDto>> {
  const rb = new RequestBuilder(rootUrl, cloneSpeciesIcPost.PATH, 'post');
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

cloneSpeciesIcPost.PATH = '/clone/species/ic';
