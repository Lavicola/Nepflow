/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { MountainDto } from '../../models/mountain-dto';

export interface MountainPost$Params {
  
    /**
     * MountainDTO with all necessary Attributes
     */
    body: MountainDto
}

export function mountainPost(http: HttpClient, rootUrl: string, params: MountainPost$Params, context?: HttpContext): Observable<StrictHttpResponse<MountainDto>> {
  const rb = new RequestBuilder(rootUrl, mountainPost.PATH, 'post');
  if (params) {
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<MountainDto>;
    })
  );
}

mountainPost.PATH = '/mountain';
