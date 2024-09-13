/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import {RequestBuilder} from "../../../../core/openApiGeneratedFiles/request-builder";
import {StrictHttpResponse} from "../../../../core/openApiGeneratedFiles/strict-http-response";

import { TradeRatingsDto } from '../../models/trade-ratings-dto';

export interface PollenexchangeUsernameTradeStatusGet$Params {
  username: string;
}

export function pollenexchangeUsernameTradeStatusGet(http: HttpClient, rootUrl: string, params: PollenexchangeUsernameTradeStatusGet$Params, context?: HttpContext): Observable<StrictHttpResponse<TradeRatingsDto>> {
  const rb = new RequestBuilder(rootUrl, pollenexchangeUsernameTradeStatusGet.PATH, 'get');
  if (params) {
    rb.path('username', params.username, {});
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<TradeRatingsDto>;
    })
  );
}

pollenexchangeUsernameTradeStatusGet.PATH = '/pollenexchange/{username}/trade/status';
