/* tslint:disable */
/* eslint-disable */
import {HttpClient, HttpContext, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import {filter, map} from 'rxjs/operators';
import {RequestBuilder} from "../../../../core/openApiGeneratedFiles/request-builder";
import {StrictHttpResponse} from "../../../../core/openApiGeneratedFiles/strict-http-response";

import {NewRatingDto} from '../../models/new-rating-dto';
import {NewRatingResponseDto} from '../../models/new-rating-response-dto';

export interface TradesTradeIdRatingPost$Params {
  tradeId: string;
      body: NewRatingDto
}

export function tradesTradeIdRatingPost(http: HttpClient, rootUrl: string, params: TradesTradeIdRatingPost$Params, context?: HttpContext): Observable<StrictHttpResponse<NewRatingResponseDto>> {
  const rb = new RequestBuilder(rootUrl, tradesTradeIdRatingPost.PATH, 'post');
  if (params) {
    rb.path('tradeId', params.tradeId, {});
    rb.body(params.body, 'multipart/form-data');
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<NewRatingResponseDto>;
    })
  );
}

tradesTradeIdRatingPost.PATH = '/trades/{tradeId}/rating';
