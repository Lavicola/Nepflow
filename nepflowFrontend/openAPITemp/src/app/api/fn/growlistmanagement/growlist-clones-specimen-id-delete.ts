/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';


export interface GrowlistClonesSpecimenIdDelete$Params {
  specimenId: string;
}

export function growlistClonesSpecimenIdDelete(http: HttpClient, rootUrl: string, params: GrowlistClonesSpecimenIdDelete$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
  const rb = new RequestBuilder(rootUrl, growlistClonesSpecimenIdDelete.PATH, 'delete');
  if (params) {
    rb.path('specimenId', params.specimenId, {});
  }

  return http.request(
    rb.build({ responseType: 'text', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return (r as HttpResponse<any>).clone({ body: undefined }) as StrictHttpResponse<void>;
    })
  );
}

growlistClonesSpecimenIdDelete.PATH = '/growlist/clones/{specimenId}';
