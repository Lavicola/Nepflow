/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import {RequestBuilder} from "../../../../core/openApiGeneratedFiles/request-builder";
import {StrictHttpResponse} from "../../../../core/openApiGeneratedFiles/strict-http-response";

import { TradeDto } from '../../models/trade-dto';

export interface PollenexchangeTradeTradeIdGet$Params {
  tradeId: string;
}

export function pollenexchangeTradeTradeIdGet(http: HttpClient, rootUrl: string, params: PollenexchangeTradeTradeIdGet$Params, context?: HttpContext): Observable<StrictHttpResponse<TradeDto>> {
  const rb = new RequestBuilder(rootUrl, pollenexchangeTradeTradeIdGet.PATH, 'get');
  if (params) {
    rb.path('tradeId', params.tradeId, {});
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<TradeDto>;
    })
  );
}

pollenexchangeTradeTradeIdGet.PATH = '/pollenexchange/trade/{tradeId}';
