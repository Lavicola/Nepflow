/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { IcCloneDto } from '../../models/ic-clone-dto';
import { IvCloneDto } from '../../models/iv-clone-dto';

export interface CloneSpeciesGet$Params {
}

export function cloneSpeciesGet(http: HttpClient, rootUrl: string, params?: CloneSpeciesGet$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<(IvCloneDto | IcCloneDto)>>> {
  const rb = new RequestBuilder(rootUrl, cloneSpeciesGet.PATH, 'get');
  if (params) {
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Array<(IvCloneDto | IcCloneDto)>>;
    })
  );
}

cloneSpeciesGet.PATH = '/clone/species/';
