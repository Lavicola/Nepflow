/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { CloneDto } from '../models/clone-dto';
import { cloneIcPost } from '../fn/nepenthes-management/clone-ic-post';
import { CloneIcPost$Params } from '../fn/nepenthes-management/clone-ic-post';
import { cloneIcPut } from '../fn/nepenthes-management/clone-ic-put';
import { CloneIcPut$Params } from '../fn/nepenthes-management/clone-ic-put';
import { cloneIvPost } from '../fn/nepenthes-management/clone-iv-post';
import { CloneIvPost$Params } from '../fn/nepenthes-management/clone-iv-post';
import { cloneIvPut } from '../fn/nepenthes-management/clone-iv-put';
import { CloneIvPut$Params } from '../fn/nepenthes-management/clone-iv-put';
import { IvCloneDto } from '../models/iv-clone-dto';
import { MountainDto } from '../models/mountain-dto';
import { mountainPost } from '../fn/nepenthes-management/mountain-post';
import { MountainPost$Params } from '../fn/nepenthes-management/mountain-post';
import { NepenthesClonesDto } from '../models/nepenthes-clones-dto';
import { NepenthesDto } from '../models/nepenthes-dto';
import { nepenthesGet } from '../fn/nepenthes-management/nepenthes-get';
import { NepenthesGet$Params } from '../fn/nepenthes-management/nepenthes-get';
import { nepenthesNameCloneGet } from '../fn/nepenthes-management/nepenthes-name-clone-get';
import { NepenthesNameCloneGet$Params } from '../fn/nepenthes-management/nepenthes-name-clone-get';
import { nepenthesNameGet } from '../fn/nepenthes-management/nepenthes-name-get';
import { NepenthesNameGet$Params } from '../fn/nepenthes-management/nepenthes-name-get';
import { nepenthesPost } from '../fn/nepenthes-management/nepenthes-post';
import { NepenthesPost$Params } from '../fn/nepenthes-management/nepenthes-post';
import { ProducerDto } from '../models/producer-dto';
import { producerPost } from '../fn/nepenthes-management/producer-post';
import { ProducerPost$Params } from '../fn/nepenthes-management/producer-post';


/**
 * Operations to manage Nepenthes
 */
@Injectable({ providedIn: 'root' })
export class NepenthesManagementService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `nepenthesGet()` */
  static readonly NepenthesGetPath = '/nepenthes';

  /**
   * get all nepenthes.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `nepenthesGet()` instead.
   *
   * This method doesn't expect any request body.
   */
  nepenthesGet$Response(params?: NepenthesGet$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<NepenthesDto>>> {
    return nepenthesGet(this.http, this.rootUrl, params, context);
  }

  /**
   * get all nepenthes.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `nepenthesGet$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  nepenthesGet(params?: NepenthesGet$Params, context?: HttpContext): Observable<Array<NepenthesDto>> {
    return this.nepenthesGet$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<NepenthesDto>>): Array<NepenthesDto> => r.body)
    );
  }

  /** Path part for operation `nepenthesPost()` */
  static readonly NepenthesPostPath = '/nepenthes';

  /**
   * Create new nepenthes.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `nepenthesPost()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  nepenthesPost$Response(params: NepenthesPost$Params, context?: HttpContext): Observable<StrictHttpResponse<NepenthesDto>> {
    return nepenthesPost(this.http, this.rootUrl, params, context);
  }

  /**
   * Create new nepenthes.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `nepenthesPost$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  nepenthesPost(params: NepenthesPost$Params, context?: HttpContext): Observable<NepenthesDto> {
    return this.nepenthesPost$Response(params, context).pipe(
      map((r: StrictHttpResponse<NepenthesDto>): NepenthesDto => r.body)
    );
  }

  /** Path part for operation `nepenthesNameGet()` */
  static readonly NepenthesNameGetPath = '/nepenthes/{name}';

  /**
   * get a nepenthes and their clones.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `nepenthesNameGet()` instead.
   *
   * This method doesn't expect any request body.
   */
  nepenthesNameGet$Response(params: NepenthesNameGet$Params, context?: HttpContext): Observable<StrictHttpResponse<NepenthesClonesDto>> {
    return nepenthesNameGet(this.http, this.rootUrl, params, context);
  }

  /**
   * get a nepenthes and their clones.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `nepenthesNameGet$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  nepenthesNameGet(params: NepenthesNameGet$Params, context?: HttpContext): Observable<NepenthesClonesDto> {
    return this.nepenthesNameGet$Response(params, context).pipe(
      map((r: StrictHttpResponse<NepenthesClonesDto>): NepenthesClonesDto => r.body)
    );
  }

  /** Path part for operation `nepenthesNameCloneGet()` */
  static readonly NepenthesNameCloneGetPath = '/nepenthes/{name}/{clone}';

  /**
   * get s specific clone.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `nepenthesNameCloneGet()` instead.
   *
   * This method doesn't expect any request body.
   */
  nepenthesNameCloneGet$Response(params: NepenthesNameCloneGet$Params, context?: HttpContext): Observable<StrictHttpResponse<(CloneDto | IvCloneDto)>> {
    return nepenthesNameCloneGet(this.http, this.rootUrl, params, context);
  }

  /**
   * get s specific clone.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `nepenthesNameCloneGet$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  nepenthesNameCloneGet(params: NepenthesNameCloneGet$Params, context?: HttpContext): Observable<(CloneDto | IvCloneDto)> {
    return this.nepenthesNameCloneGet$Response(params, context).pipe(
      map((r: StrictHttpResponse<(CloneDto | IvCloneDto)>): (CloneDto | IvCloneDto) => r.body)
    );
  }

  /** Path part for operation `cloneIvPut()` */
  static readonly CloneIvPutPath = '/clone/iv';

  /**
   * change information of an existing clone.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `cloneIvPut()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  cloneIvPut$Response(params: CloneIvPut$Params, context?: HttpContext): Observable<StrictHttpResponse<IvCloneDto>> {
    return cloneIvPut(this.http, this.rootUrl, params, context);
  }

  /**
   * change information of an existing clone.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `cloneIvPut$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  cloneIvPut(params: CloneIvPut$Params, context?: HttpContext): Observable<IvCloneDto> {
    return this.cloneIvPut$Response(params, context).pipe(
      map((r: StrictHttpResponse<IvCloneDto>): IvCloneDto => r.body)
    );
  }

  /** Path part for operation `cloneIvPost()` */
  static readonly CloneIvPostPath = '/clone/iv';

  /**
   * add a new iv clone of a nepenthes.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `cloneIvPost()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  cloneIvPost$Response(params: CloneIvPost$Params, context?: HttpContext): Observable<StrictHttpResponse<IvCloneDto>> {
    return cloneIvPost(this.http, this.rootUrl, params, context);
  }

  /**
   * add a new iv clone of a nepenthes.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `cloneIvPost$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  cloneIvPost(params: CloneIvPost$Params, context?: HttpContext): Observable<IvCloneDto> {
    return this.cloneIvPost$Response(params, context).pipe(
      map((r: StrictHttpResponse<IvCloneDto>): IvCloneDto => r.body)
    );
  }

  /** Path part for operation `cloneIcPut()` */
  static readonly CloneIcPutPath = '/clone/ic';

  /**
   * change information of an existing clone.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `cloneIcPut()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  cloneIcPut$Response(params: CloneIcPut$Params, context?: HttpContext): Observable<StrictHttpResponse<CloneDto>> {
    return cloneIcPut(this.http, this.rootUrl, params, context);
  }

  /**
   * change information of an existing clone.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `cloneIcPut$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  cloneIcPut(params: CloneIcPut$Params, context?: HttpContext): Observable<CloneDto> {
    return this.cloneIcPut$Response(params, context).pipe(
      map((r: StrictHttpResponse<CloneDto>): CloneDto => r.body)
    );
  }

  /** Path part for operation `cloneIcPost()` */
  static readonly CloneIcPostPath = '/clone/ic';

  /**
   * add a new ic clone of a nepenthes.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `cloneIcPost()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  cloneIcPost$Response(params: CloneIcPost$Params, context?: HttpContext): Observable<StrictHttpResponse<CloneDto>> {
    return cloneIcPost(this.http, this.rootUrl, params, context);
  }

  /**
   * add a new ic clone of a nepenthes.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `cloneIcPost$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  cloneIcPost(params: CloneIcPost$Params, context?: HttpContext): Observable<CloneDto> {
    return this.cloneIcPost$Response(params, context).pipe(
      map((r: StrictHttpResponse<CloneDto>): CloneDto => r.body)
    );
  }

  /** Path part for operation `mountainPost()` */
  static readonly MountainPostPath = '/mountain';

  /**
   * add a new Mountain.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `mountainPost()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  mountainPost$Response(params: MountainPost$Params, context?: HttpContext): Observable<StrictHttpResponse<MountainDto>> {
    return mountainPost(this.http, this.rootUrl, params, context);
  }

  /**
   * add a new Mountain.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `mountainPost$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  mountainPost(params: MountainPost$Params, context?: HttpContext): Observable<MountainDto> {
    return this.mountainPost$Response(params, context).pipe(
      map((r: StrictHttpResponse<MountainDto>): MountainDto => r.body)
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
