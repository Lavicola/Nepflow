/* tslint:disable */
/* eslint-disable */
import {HttpClient, HttpContext, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import {filter, map} from 'rxjs/operators';
import {StrictHttpResponse} from '../../strict-http-response';
import {RequestBuilder} from '../../request-builder';

import {LabelClonesDto} from '../../models/label-clones-dto';
import {NepenthesType} from '../../models/nepenthes-type';

export interface CloneNepenthesTypeNameGet$Params {
  nepenthesType: NepenthesType;
  name: string;
}

export function cloneNepenthesTypeNameGet(http: HttpClient, rootUrl: string, params: CloneNepenthesTypeNameGet$Params, context?: HttpContext): Observable<StrictHttpResponse<LabelClonesDto>> {
  const rb = new RequestBuilder(rootUrl, cloneNepenthesTypeNameGet.PATH, 'get');
  if (params) {
    rb.path('nepenthesType', params.nepenthesType, {});
    rb.path('name', params.name, {});
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<LabelClonesDto>;
    })
  );
}

cloneNepenthesTypeNameGet.PATH = '/clone/{nepenthesType}/{name}';
