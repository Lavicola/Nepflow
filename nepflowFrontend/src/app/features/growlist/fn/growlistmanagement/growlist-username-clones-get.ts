/* tslint:disable */
/* eslint-disable */
import {HttpClient, HttpContext, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import {filter, map} from 'rxjs/operators';
import {RequestBuilder} from "../../../../core/openApiGeneratedFiles/request-builder";
import {StrictHttpResponse} from "../../../../core/openApiGeneratedFiles/strict-http-response";
import {GrowlistDto} from '../../models/growlist-dto';

export interface GrowlistUsernameClonesGet$Params {
  username: string;
}

export function growlistUsernameClonesGet(http: HttpClient, rootUrl: string, params: GrowlistUsernameClonesGet$Params, context?: HttpContext): Observable<StrictHttpResponse<GrowlistDto>> {
  const rb = new RequestBuilder(rootUrl, growlistUsernameClonesGet.PATH, 'get');
  if (params) {
    rb.path('username', params.username, {});
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<GrowlistDto>;
    })
  );
}

growlistUsernameClonesGet.PATH = '/growlist/{username}/clones';
