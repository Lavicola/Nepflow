/* tslint:disable */
/* eslint-disable */
import {HttpClient, HttpContext, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import {filter, map} from 'rxjs/operators';
import {StrictHttpResponse} from '../../strict-http-response';
import {RequestBuilder} from '../../request-builder';

import {SpecimenCloneDto} from '../../models/specimen-clone-dto';

export interface GrowlistCloneAddInternalCloneIdPost$Params {
  internalCloneId: string;
}

export function growlistCloneAddInternalCloneIdPost(http: HttpClient, rootUrl: string, params: GrowlistCloneAddInternalCloneIdPost$Params, context?: HttpContext): Observable<StrictHttpResponse<SpecimenCloneDto>> {
  const rb = new RequestBuilder(rootUrl, growlistCloneAddInternalCloneIdPost.PATH, 'post');
  if (params) {
    rb.path('internalCloneId', params.internalCloneId, {});
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

growlistCloneAddInternalCloneIdPost.PATH = '/growlist/clone/add/{internalCloneId}';
