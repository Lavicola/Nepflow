/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import {RequestBuilder} from "../../../core/openApiGeneratedFiles/request-builder";
import {StrictHttpResponse} from "../../../core/openApiGeneratedFiles/strict-http-response";

import { TradeAnswerDto } from '../../models/trade-answer-dto';
import { TradeDto } from '../../models/trade-dto';

export interface PollenexchangeTradeTradeIdPut$Params {
  tradeId: string;
      body: TradeAnswerDto
}

export function pollenexchangeTradeTradeIdPut(http: HttpClient, rootUrl: string, params: PollenexchangeTradeTradeIdPut$Params, context?: HttpContext): Observable<StrictHttpResponse<TradeDto>> {
  const rb = new RequestBuilder(rootUrl, pollenexchangeTradeTradeIdPut.PATH, 'put');
  if (params) {
    rb.path('tradeId', params.tradeId, {});
    rb.body(params.body, 'application/json');
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

pollenexchangeTradeTradeIdPut.PATH = '/pollenexchange/trade/{tradeId}';
