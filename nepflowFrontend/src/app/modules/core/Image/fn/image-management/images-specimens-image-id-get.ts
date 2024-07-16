/* tslint:disable */
/* eslint-disable */
import {HttpClient, HttpContext, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import {filter, map} from 'rxjs/operators';
import {RequestBuilder} from "../../../openApiGeneratedFiles/request-builder";
import {StrictHttpResponse} from "../../../openApiGeneratedFiles/strict-http-response";

export interface ImagesSpecimensImageIdGet$Params {
  imageId: string;
}

export function imagesSpecimensImageIdGet(http: HttpClient, rootUrl: string, params: ImagesSpecimensImageIdGet$Params, context?: HttpContext): Observable<StrictHttpResponse<Blob>> {
  const rb = new RequestBuilder(rootUrl, imagesSpecimensImageIdGet.PATH, 'get');
  if (params) {
    rb.path('imageId', params.imageId, {});
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: 'image/webp', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Blob>;
    })
  );
}

imagesSpecimensImageIdGet.PATH = '/images/specimens/{imageId}';
