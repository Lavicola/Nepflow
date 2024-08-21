/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import {RequestBuilder} from "../../../core/openApiGeneratedFiles/request-builder";
import {StrictHttpResponse} from "../../../core/openApiGeneratedFiles/strict-http-response";

import { PollenOfferDto } from '../../models/pollen-offer-dto';

export interface PollenexchangeUsernamePollenoffersOpenGet$Params {
  username: string;
}

export function pollenexchangeUsernamePollenoffersOpenGet(http: HttpClient, rootUrl: string, params: PollenexchangeUsernamePollenoffersOpenGet$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<PollenOfferDto>>> {
  const rb = new RequestBuilder(rootUrl, pollenexchangeUsernamePollenoffersOpenGet.PATH, 'get');
  if (params) {
    rb.path('username', params.username, {});
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Array<PollenOfferDto>>;
    })
  );
}

pollenexchangeUsernamePollenoffersOpenGet.PATH = '/pollenexchange/{username}/pollenoffers/open';
