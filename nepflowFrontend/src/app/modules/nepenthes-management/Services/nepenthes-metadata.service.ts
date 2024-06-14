/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../../../base-service';
import { ApiConfiguration } from '../../../api-configuration';
import { StrictHttpResponse } from '../../../strict-http-response';

import { LocationDto } from '../models/location-dto';
import { locationPost } from '../../../fn/nepenthes-metadata/location-post';
import { LocationPost$Params } from '../../../fn/nepenthes-metadata/location-post';
import { ProducerDto } from '../models/producer-dto';
import { producerPost } from '../../../fn/nepenthes-metadata/producer-post';
import { ProducerPost$Params } from '../../../fn/nepenthes-metadata/producer-post';

@Injectable({ providedIn: 'root' })
export class NepenthesMetadataService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `locationPost()` */
  static readonly LocationPostPath = '/location';

  /**
   * add a new Location.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `locationPost()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  locationPost$Response(params: LocationPost$Params, context?: HttpContext): Observable<StrictHttpResponse<LocationDto>> {
    return locationPost(this.http, this.rootUrl, params, context);
  }

  /**
   * add a new Location.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `locationPost$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  locationPost(params: LocationPost$Params, context?: HttpContext): Observable<LocationDto> {
    return this.locationPost$Response(params, context).pipe(
      map((r: StrictHttpResponse<LocationDto>): LocationDto => r.body)
    );
  }

  /** Path part for operation `producerPost()` */
  static readonly ProducerPostPath = '/producer';

  /**
   * add a new Producer.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `producerPost()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  producerPost$Response(params: ProducerPost$Params, context?: HttpContext): Observable<StrictHttpResponse<ProducerDto>> {
    return producerPost(this.http, this.rootUrl, params, context);
  }

  /**
   * add a new Producer.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `producerPost$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  producerPost(params: ProducerPost$Params, context?: HttpContext): Observable<ProducerDto> {
    return this.producerPost$Response(params, context).pipe(
      map((r: StrictHttpResponse<ProducerDto>): ProducerDto => r.body)
    );
  }

}
