/* tslint:disable */
/* eslint-disable */
import {HttpClient, HttpContext, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import {filter, map} from 'rxjs/operators';
import {StrictHttpResponse} from '../../strict-http-response';
import {RequestBuilder} from '../../request-builder';

import {LabelDto} from '../../models/label-dto';
import {NepenthesType} from '../../models/nepenthes-type';

export interface CloneNepenthesTypeGet$Params {
  nepenthesType: NepenthesType;
}

export function cloneNepenthesTypeGet(http: HttpClient, rootUrl: string, params: CloneNepenthesTypeGet$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<LabelDto>>> {
  const rb = new RequestBuilder(rootUrl, cloneNepenthesTypeGet.PATH, 'get');
  if (params) {
    rb.path('nepenthesType', params.nepenthesType, {});
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Array<LabelDto>>;
    })
  );
}

cloneNepenthesTypeGet.PATH = '/clone/{nepenthesType}';
