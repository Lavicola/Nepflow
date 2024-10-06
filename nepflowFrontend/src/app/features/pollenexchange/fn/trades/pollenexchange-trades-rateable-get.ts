/* tslint:disable */
/* eslint-disable */
import {HttpClient, HttpContext, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import {filter, map} from 'rxjs/operators';
import {RequestBuilder} from "../../../../core/openApiGeneratedFiles/request-builder";
import {StrictHttpResponse} from "../../../../core/openApiGeneratedFiles/strict-http-response";

import {TradeDto} from '../../models/trade-dto';

export interface PollenexchangeTradesRateableGet$Params {
}

export function pollenexchangeTradesRateableGet(http: HttpClient, rootUrl: string, params?: PollenexchangeTradesRateableGet$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<TradeDto>>> {
  const rb = new RequestBuilder(rootUrl, pollenexchangeTradesRateableGet.PATH, 'get');
  if (params) {
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Array<TradeDto>>;
    })
  );
}

pollenexchangeTradesRateableGet.PATH = '/pollenexchange/trades/rateable';
