/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { IcCloneDto } from '../../models/ic-clone-dto';
import { IvCloneDto } from '../../models/iv-clone-dto';

export interface NepenthesNameCloneGet$Params {
  name: string;
  clone: string;
}

export function nepenthesNameCloneGet(http: HttpClient, rootUrl: string, params: NepenthesNameCloneGet$Params, context?: HttpContext): Observable<StrictHttpResponse<(IcCloneDto | IvCloneDto)>> {
  const rb = new RequestBuilder(rootUrl, nepenthesNameCloneGet.PATH, 'get');
  if (params) {
    rb.path('name', params.name, {});
    rb.path('clone', params.clone, {});
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<(IcCloneDto | IvCloneDto)>;
    })
  );
}

nepenthesNameCloneGet.PATH = '/nepenthes/{name}/{clone}';
