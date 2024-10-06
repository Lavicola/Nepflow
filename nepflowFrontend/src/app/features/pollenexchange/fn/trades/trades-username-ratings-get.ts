/* tslint:disable */
/* eslint-disable */
import {HttpClient, HttpContext, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import {filter, map} from 'rxjs/operators';
import {RequestBuilder} from "../../../../core/openApiGeneratedFiles/request-builder";
import {StrictHttpResponse} from "../../../../core/openApiGeneratedFiles/strict-http-response";

import {Pageable} from '../../models/pageable';
import {RatingPage} from '../../models/rating-page';

export interface TradesUsernameRatingsGet$Params {
  username: string;
  pageable?: Pageable;
}

export function tradesUsernameRatingsGet(http: HttpClient, rootUrl: string, params: TradesUsernameRatingsGet$Params, context?: HttpContext): Observable<StrictHttpResponse<RatingPage>> {
  const rb = new RequestBuilder(rootUrl, tradesUsernameRatingsGet.PATH, 'get');
  if (params) {
    rb.path('username', params.username, {});
    rb.query('pageable', params.pageable, {});
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<RatingPage>;
    })
  );
}

tradesUsernameRatingsGet.PATH = '/trades/{username}/ratings';
