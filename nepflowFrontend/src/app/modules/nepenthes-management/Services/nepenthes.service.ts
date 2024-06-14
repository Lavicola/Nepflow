/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../../../base-service';
import { ApiConfiguration } from '../../../api-configuration';
import { StrictHttpResponse } from '../../../strict-http-response';

import { cloneNepenthesTypeCloneTypeNameGet } from '../fn/nepenthes/clone-nepenthes-type-clone-type-name-get';
import { CloneNepenthesTypeCloneTypeNameGet$Params } from '../fn/nepenthes/clone-nepenthes-type-clone-type-name-get';
import { cloneNepenthesTypeCloneTypeNameInternalCloneIdPut } from '../fn/nepenthes/clone-nepenthes-type-clone-type-name-internal-clone-id-put';
import { CloneNepenthesTypeCloneTypeNameInternalCloneIdPut$Params } from '../fn/nepenthes/clone-nepenthes-type-clone-type-name-internal-clone-id-put';
import { cloneNepenthesTypeCloneTypeNamePost } from '../fn/nepenthes/clone-nepenthes-type-clone-type-name-post';
import { CloneNepenthesTypeCloneTypeNamePost$Params } from '../fn/nepenthes/clone-nepenthes-type-clone-type-name-post';
import { cloneNepenthesTypeGet } from '../fn/nepenthes/clone-nepenthes-type-get';
import { CloneNepenthesTypeGet$Params } from '../fn/nepenthes/clone-nepenthes-type-get';
import { cloneNepenthesTypeNameGet } from '../fn/nepenthes/clone-nepenthes-type-name-get';
import { CloneNepenthesTypeNameGet$Params } from '../fn/nepenthes/clone-nepenthes-type-name-get';
import { LabelCloneDto } from '../models/label-clone-dto';
import { LabelClonesDto } from '../models/label-clones-dto';
import { LabelDto } from '../models/label-dto';

@Injectable({ providedIn: 'root' })
export class NepenthesService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `cloneNepenthesTypeGet()` */
  static readonly CloneNepenthesTypeGetPath = '/clone/{nepenthesType}';

  /**
   * get all Nepenthes of a specific Nepenthestype.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `cloneNepenthesTypeGet()` instead.
   *
   * This method doesn't expect any request body.
   */
  cloneNepenthesTypeGet$Response(params: CloneNepenthesTypeGet$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<LabelDto>>> {
    return cloneNepenthesTypeGet(this.http, this.rootUrl, params, context);
  }

  /**
   * get all Nepenthes of a specific Nepenthestype.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `cloneNepenthesTypeGet$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  cloneNepenthesTypeGet(params: CloneNepenthesTypeGet$Params, context?: HttpContext): Observable<Array<LabelDto>> {
    return this.cloneNepenthesTypeGet$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<LabelDto>>): Array<LabelDto> => r.body)
    );
  }

  /** Path part for operation `cloneNepenthesTypeNameGet()` */
  static readonly CloneNepenthesTypeNameGetPath = '/clone/{nepenthesType}/{name}';

  /**
   * get all clones of a Nepenthes.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `cloneNepenthesTypeNameGet()` instead.
   *
   * This method doesn't expect any request body.
   */
  cloneNepenthesTypeNameGet$Response(params: CloneNepenthesTypeNameGet$Params, context?: HttpContext): Observable<StrictHttpResponse<LabelClonesDto>> {
    return cloneNepenthesTypeNameGet(this.http, this.rootUrl, params, context);
  }

  /**
   * get all clones of a Nepenthes.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `cloneNepenthesTypeNameGet$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  cloneNepenthesTypeNameGet(params: CloneNepenthesTypeNameGet$Params, context?: HttpContext): Observable<LabelClonesDto> {
    return this.cloneNepenthesTypeNameGet$Response(params, context).pipe(
      map((r: StrictHttpResponse<LabelClonesDto>): LabelClonesDto => r.body)
    );
  }

  /** Path part for operation `cloneNepenthesTypeCloneTypeNameGet()` */
  static readonly CloneNepenthesTypeCloneTypeNameGetPath = '/clone/{nepenthesType}/{cloneType}/{name}';

  /**
   * get either iv or ic clones of a Nepenthes.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `cloneNepenthesTypeCloneTypeNameGet()` instead.
   *
   * This method doesn't expect any request body.
   */
  cloneNepenthesTypeCloneTypeNameGet$Response(params: CloneNepenthesTypeCloneTypeNameGet$Params, context?: HttpContext): Observable<StrictHttpResponse<LabelClonesDto>> {
    return cloneNepenthesTypeCloneTypeNameGet(this.http, this.rootUrl, params, context);
  }

  /**
   * get either iv or ic clones of a Nepenthes.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `cloneNepenthesTypeCloneTypeNameGet$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  cloneNepenthesTypeCloneTypeNameGet(params: CloneNepenthesTypeCloneTypeNameGet$Params, context?: HttpContext): Observable<LabelClonesDto> {
    return this.cloneNepenthesTypeCloneTypeNameGet$Response(params, context).pipe(
      map((r: StrictHttpResponse<LabelClonesDto>): LabelClonesDto => r.body)
    );
  }

  /** Path part for operation `cloneNepenthesTypeCloneTypeNamePost()` */
  static readonly CloneNepenthesTypeCloneTypeNamePostPath = '/clone/{nepenthesType}/{cloneType}/{name}';

  /**
   * add a new clone to a nepenthes.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `cloneNepenthesTypeCloneTypeNamePost()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  cloneNepenthesTypeCloneTypeNamePost$Response(params: CloneNepenthesTypeCloneTypeNamePost$Params, context?: HttpContext): Observable<StrictHttpResponse<LabelCloneDto>> {
    return cloneNepenthesTypeCloneTypeNamePost(this.http, this.rootUrl, params, context);
  }

  /**
   * add a new clone to a nepenthes.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `cloneNepenthesTypeCloneTypeNamePost$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  cloneNepenthesTypeCloneTypeNamePost(params: CloneNepenthesTypeCloneTypeNamePost$Params, context?: HttpContext): Observable<LabelCloneDto> {
    return this.cloneNepenthesTypeCloneTypeNamePost$Response(params, context).pipe(
      map((r: StrictHttpResponse<LabelCloneDto>): LabelCloneDto => r.body)
    );
  }

  /** Path part for operation `cloneNepenthesTypeCloneTypeNameInternalCloneIdPut()` */
  static readonly CloneNepenthesTypeCloneTypeNameInternalCloneIdPutPath = '/clone/{nepenthesType}/{cloneType}/{name}/{internalCloneId}';

  /**
   * update a Clone.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `cloneNepenthesTypeCloneTypeNameInternalCloneIdPut()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  cloneNepenthesTypeCloneTypeNameInternalCloneIdPut$Response(params: CloneNepenthesTypeCloneTypeNameInternalCloneIdPut$Params, context?: HttpContext): Observable<StrictHttpResponse<LabelCloneDto>> {
    return cloneNepenthesTypeCloneTypeNameInternalCloneIdPut(this.http, this.rootUrl, params, context);
  }

  /**
   * update a Clone.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `cloneNepenthesTypeCloneTypeNameInternalCloneIdPut$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  cloneNepenthesTypeCloneTypeNameInternalCloneIdPut(params: CloneNepenthesTypeCloneTypeNameInternalCloneIdPut$Params, context?: HttpContext): Observable<LabelCloneDto> {
    return this.cloneNepenthesTypeCloneTypeNameInternalCloneIdPut$Response(params, context).pipe(
      map((r: StrictHttpResponse<LabelCloneDto>): LabelCloneDto => r.body)
    );
  }

}
