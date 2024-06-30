/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import {StrictHttpResponse} from "../../../../strict-http-response";
import { RequestBuilder } from '../../../../request-builder';

import { LocationDto } from '../../models/location-dto';

export interface LocationPost$Params {

    /**
     * LocationdTo with all necessary Attributes
     */
    body: LocationDto
}

export function locationPost(http: HttpClient, rootUrl: string, params: LocationPost$Params, context?: HttpContext): Observable<StrictHttpResponse<LocationDto>> {
  const rb = new RequestBuilder(rootUrl, locationPost.PATH, 'post');
  if (params) {
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<LocationDto>;
    })
  );
}

locationPost.PATH = '/location';
