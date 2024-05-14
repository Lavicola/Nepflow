/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { IcCloneDto } from '../../models/ic-clone-dto';

export interface CloneSpeciesIcPost$Params {
  
    /**
     * Clone DTO with new values
     */
    body: IcCloneDto
}

export function cloneSpeciesIcPost(http: HttpClient, rootUrl: string, params: CloneSpeciesIcPost$Params, context?: HttpContext): Observable<StrictHttpResponse<IcCloneDto>> {
  const rb = new RequestBuilder(rootUrl, cloneSpeciesIcPost.PATH, 'post');
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

cloneSpeciesIcPost.PATH = '/clone/species/ic';
