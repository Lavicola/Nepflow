/* tslint:disable */
/* eslint-disable */
import {HttpClient, HttpContext, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import {filter, map} from 'rxjs/operators';
import {RequestBuilder} from "../../../../core/openApiGeneratedFiles/request-builder";
import {StrictHttpResponse} from "../../../../core/openApiGeneratedFiles/strict-http-response";

import {PollenOfferDateContainerDto} from '../../models/pollen-offer-date-container-dto';

export interface PollenexchangePollenoffersOpenGet$Params {

/**
 * if dates is not send, the current date in germany will be used (date in Format MM-YYY)
 */
  dates?: Array<string>;
}

export function pollenexchangePollenoffersOpenGet(http: HttpClient, rootUrl: string, params?: PollenexchangePollenoffersOpenGet$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<PollenOfferDateContainerDto>>> {
  const rb = new RequestBuilder(rootUrl, pollenexchangePollenoffersOpenGet.PATH, 'get');
  if (params) {
    rb.query('dates', params.dates, {});
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Array<PollenOfferDateContainerDto>>;
    })
  );
}

pollenexchangePollenoffersOpenGet.PATH = '/pollenexchange/pollenoffers/open';
