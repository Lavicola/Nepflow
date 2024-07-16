/* tslint:disable */
/* eslint-disable */
import {HttpClient, HttpContext, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import {filter, map} from 'rxjs/operators';
import {StrictHttpResponse} from '../../strict-http-response';
import {RequestBuilder} from '../../request-builder';

import {CloneType} from '../../models/clone-type';
import {LabelCloneDto} from '../../models/label-clone-dto';
import {SpecimenCloneDto} from '../../models/specimen-clone-dto';

export interface GrowlistCreateNepenthesCloneTypePost$Params {
  cloneType: CloneType;
      body?: LabelCloneDto
}

export function growlistCreateNepenthesCloneTypePost(http: HttpClient, rootUrl: string, params: GrowlistCreateNepenthesCloneTypePost$Params, context?: HttpContext): Observable<StrictHttpResponse<SpecimenCloneDto>> {
  const rb = new RequestBuilder(rootUrl, growlistCreateNepenthesCloneTypePost.PATH, 'post');
  if (params) {
    rb.path('cloneType', params.cloneType, {});
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<SpecimenCloneDto>;
    })
  );
}

growlistCreateNepenthesCloneTypePost.PATH = '/growlist/create/nepenthes/{cloneType}';
