/* tslint:disable */
/* eslint-disable */
import {HttpClient, HttpContext, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import {filter, map} from 'rxjs/operators';
import {StrictHttpResponse} from "../../../core/openApiGeneratedFiles/strict-http-response";
import {RequestBuilder} from '../../../core/openApiGeneratedFiles/request-builder';

import {ProducerDto} from '../../models/producer-dto';

export interface ProducerPost$Params {

    /**
     * DTO with all necessary Attributes
     */
    body: ProducerDto
}

export function producerPost(http: HttpClient, rootUrl: string, params: ProducerPost$Params, context?: HttpContext): Observable<StrictHttpResponse<ProducerDto>> {
  const rb = new RequestBuilder(rootUrl, producerPost.PATH, 'post');
  if (params) {
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<ProducerDto>;
    })
  );
}

producerPost.PATH = '/producer';
