/* tslint:disable */
/* eslint-disable */
import {HttpClient, HttpContext} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';


import {
  imagesSpecimensImageIdGet,
  ImagesSpecimensImageIdGet$Params
} from '../fn/image-management/images-specimens-image-id-get';
import {BaseService} from "../../openApiGeneratedFiles/base-service";
import {StrictHttpResponse} from "../../openApiGeneratedFiles/strict-http-response";
import {ApiConfiguration} from "../../openApiGeneratedFiles/api-configuration";


/**
 * Endpoints to retreive specific Images
 */
@Injectable({ providedIn: 'root' })
export class ImageManagementService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `imagesSpecimensImageIdGet()` */
  static readonly ImagesSpecimensImageIdGetPath = '/images/specimens/{imageId}';

  /**
   * get a specific File of a Specimen.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `imagesSpecimensImageIdGet()` instead.
   *
   * This method doesn't expect any request body.
   */
  imagesSpecimensImageIdGet$Response(params: ImagesSpecimensImageIdGet$Params, context?: HttpContext): Observable<StrictHttpResponse<Blob>> {
    return imagesSpecimensImageIdGet(this.http, this.rootUrl, params, context);
  }

  /**
   * get a specific File of a Specimen.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `imagesSpecimensImageIdGet$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  imagesSpecimensImageIdGet(params: ImagesSpecimensImageIdGet$Params, context?: HttpContext): Observable<Blob> {
    return this.imagesSpecimensImageIdGet$Response(params, context).pipe(
      map((r: StrictHttpResponse<Blob>): Blob => r.body)
    );
  }

}
