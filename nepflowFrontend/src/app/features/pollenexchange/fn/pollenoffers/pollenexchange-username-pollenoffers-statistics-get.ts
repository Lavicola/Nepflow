/* tslint:disable */
/* eslint-disable */
import {HttpClient, HttpContext, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import {filter, map} from 'rxjs/operators';
import {RequestBuilder} from "../../../../core/openApiGeneratedFiles/request-builder";
import {StrictHttpResponse} from "../../../../core/openApiGeneratedFiles/strict-http-response";

import {PollenOfferSpeciesStatisticsDto} from '../../models/pollen-offer-species-statistics-dto';

export interface PollenexchangeUsernamePollenoffersStatisticsGet$Params {
  username: string;
}

export function pollenexchangeUsernamePollenoffersStatisticsGet(http: HttpClient, rootUrl: string, params: PollenexchangeUsernamePollenoffersStatisticsGet$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<PollenOfferSpeciesStatisticsDto>>> {
  const rb = new RequestBuilder(rootUrl, pollenexchangeUsernamePollenoffersStatisticsGet.PATH, 'get');
  if (params) {
    rb.path('username', params.username, {});
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Array<PollenOfferSpeciesStatisticsDto>>;
    })
  );
}

pollenexchangeUsernamePollenoffersStatisticsGet.PATH = '/pollenexchange/{username}/pollenoffers/statistics';
