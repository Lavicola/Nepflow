/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import {RequestBuilder} from "../../../core/openApiGeneratedFiles/request-builder";
import {StrictHttpResponse} from "../../../core/openApiGeneratedFiles/strict-http-response";

import { TradeDateContainerDto } from '../../models/trade-date-container-dto';

export interface PollenexchangeUsernameTradesGet$Params {

/**
 * if dates is not send, the current date in germany will be used (date in Format MM-YYY)
 */
  dates?: Array<string>;
  username: string;
}

export function pollenexchangeUsernameTradesGet(http: HttpClient, rootUrl: string, params: PollenexchangeUsernameTradesGet$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<TradeDateContainerDto>>> {
  const rb = new RequestBuilder(rootUrl, pollenexchangeUsernameTradesGet.PATH, 'get');
  if (params) {
    rb.query('dates', params.dates, {});
    rb.path('username', params.username, {});
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Array<TradeDateContainerDto>>;
    })
  );
}

pollenexchangeUsernameTradesGet.PATH = '/pollenexchange/{username}/trades';
