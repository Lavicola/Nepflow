/* tslint:disable */
/* eslint-disable */
import {HttpClient, HttpContext, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import {filter, map} from 'rxjs/operators';

import {TradeCreationDto} from '../../models/trade-creation-dto';
import {TradeDto} from '../../models/trade-dto';
import {RequestBuilder} from "../../../../core/openApiGeneratedFiles/request-builder";
import {StrictHttpResponse} from "../../../../core/openApiGeneratedFiles/strict-http-response";

export interface PollenexchangeCreateTradePost$Params {
      body: TradeCreationDto
}

export function pollenexchangeCreateTradePost(http: HttpClient, rootUrl: string, params: PollenexchangeCreateTradePost$Params, context?: HttpContext): Observable<StrictHttpResponse<TradeDto>> {
  const rb = new RequestBuilder(rootUrl, pollenexchangeCreateTradePost.PATH, 'post');
  if (params) {
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

pollenexchangeCreateTradePost.PATH = '/pollenexchange/create/trade';
