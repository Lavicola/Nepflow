/* tslint:disable */
/* eslint-disable */
import {HttpClient, HttpContext, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import {filter, map} from 'rxjs/operators';
import {RequestBuilder} from "../../../../core/openApiGeneratedFiles/request-builder";
import {StrictHttpResponse} from "../../../../core/openApiGeneratedFiles/strict-http-response";

import {TradeStatusDto} from '../../models/trade-status-dto';

export interface PollenexchangeUsernameTradesStatusGet$Params {
  username: string;
}

export function pollenexchangeUsernameTradesStatusGet(http: HttpClient, rootUrl: string, params: PollenexchangeUsernameTradesStatusGet$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<TradeStatusDto>>> {
  const rb = new RequestBuilder(rootUrl, pollenexchangeUsernameTradesStatusGet.PATH, 'get');
  if (params) {
    rb.path('username', params.username, {});
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Array<TradeStatusDto>>;
    })
  );
}

pollenexchangeUsernameTradesStatusGet.PATH = '/pollenexchange/{username}/trades/status';
