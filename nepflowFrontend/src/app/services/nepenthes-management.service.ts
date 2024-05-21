/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { cloneHybridsGet } from '../fn/nepenthes-management/clone-hybrids-get';
import { CloneHybridsGet$Params } from '../fn/nepenthes-management/clone-hybrids-get';
import { cloneHybridsIcGet } from '../fn/nepenthes-management/clone-hybrids-ic-get';
import { CloneHybridsIcGet$Params } from '../fn/nepenthes-management/clone-hybrids-ic-get';
import { cloneHybridsIcPost } from '../fn/nepenthes-management/clone-hybrids-ic-post';
import { CloneHybridsIcPost$Params } from '../fn/nepenthes-management/clone-hybrids-ic-post';
import { cloneHybridsIcPut } from '../fn/nepenthes-management/clone-hybrids-ic-put';
import { CloneHybridsIcPut$Params } from '../fn/nepenthes-management/clone-hybrids-ic-put';
import { cloneHybridsIvGet } from '../fn/nepenthes-management/clone-hybrids-iv-get';
import { CloneHybridsIvGet$Params } from '../fn/nepenthes-management/clone-hybrids-iv-get';
import { cloneHybridsIvPost } from '../fn/nepenthes-management/clone-hybrids-iv-post';
import { CloneHybridsIvPost$Params } from '../fn/nepenthes-management/clone-hybrids-iv-post';
import { cloneHybridsIvPut } from '../fn/nepenthes-management/clone-hybrids-iv-put';
import { CloneHybridsIvPut$Params } from '../fn/nepenthes-management/clone-hybrids-iv-put';
import { cloneMultiHybridGet } from '../fn/nepenthes-management/clone-multi-hybrid-get';
import { CloneMultiHybridGet$Params } from '../fn/nepenthes-management/clone-multi-hybrid-get';
import { cloneMultiHybridIcGet } from '../fn/nepenthes-management/clone-multi-hybrid-ic-get';
import { CloneMultiHybridIcGet$Params } from '../fn/nepenthes-management/clone-multi-hybrid-ic-get';
import { cloneMultiHybridIcPost } from '../fn/nepenthes-management/clone-multi-hybrid-ic-post';
import { CloneMultiHybridIcPost$Params } from '../fn/nepenthes-management/clone-multi-hybrid-ic-post';
import { cloneMultiHybridIcPut } from '../fn/nepenthes-management/clone-multi-hybrid-ic-put';
import { CloneMultiHybridIcPut$Params } from '../fn/nepenthes-management/clone-multi-hybrid-ic-put';
import { cloneMultiHybridIvGet } from '../fn/nepenthes-management/clone-multi-hybrid-iv-get';
import { CloneMultiHybridIvGet$Params } from '../fn/nepenthes-management/clone-multi-hybrid-iv-get';
import { cloneMultiHybridIvPost } from '../fn/nepenthes-management/clone-multi-hybrid-iv-post';
import { CloneMultiHybridIvPost$Params } from '../fn/nepenthes-management/clone-multi-hybrid-iv-post';
import { cloneMultiHybridIvPut } from '../fn/nepenthes-management/clone-multi-hybrid-iv-put';
import { CloneMultiHybridIvPut$Params } from '../fn/nepenthes-management/clone-multi-hybrid-iv-put';
import { cloneSpeciesGet } from '../fn/nepenthes-management/clone-species-get';
import { CloneSpeciesGet$Params } from '../fn/nepenthes-management/clone-species-get';
import { cloneSpeciesIcPost } from '../fn/nepenthes-management/clone-species-ic-post';
import { CloneSpeciesIcPost$Params } from '../fn/nepenthes-management/clone-species-ic-post';
import { cloneSpeciesIcPut } from '../fn/nepenthes-management/clone-species-ic-put';
import { CloneSpeciesIcPut$Params } from '../fn/nepenthes-management/clone-species-ic-put';
import { cloneSpeciesIvPost } from '../fn/nepenthes-management/clone-species-iv-post';
import { CloneSpeciesIvPost$Params } from '../fn/nepenthes-management/clone-species-iv-post';
import { cloneSpeciesIvPut } from '../fn/nepenthes-management/clone-species-iv-put';
import { CloneSpeciesIvPut$Params } from '../fn/nepenthes-management/clone-species-iv-put';
import { HybridCloneDto } from '../models/hybrid-clone-dto';
import { LocationDto } from '../models/location-dto';
import { locationPost } from '../fn/nepenthes-management/location-post';
import { LocationPost$Params } from '../fn/nepenthes-management/location-post';
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
import { SpeciesCloneDto } from '../models/species-clone-dto';


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
  nepenthesNameCloneGet$Response(params: NepenthesNameCloneGet$Params, context?: HttpContext): Observable<StrictHttpResponse<SpeciesCloneDto>> {
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
  nepenthesNameCloneGet(params: NepenthesNameCloneGet$Params, context?: HttpContext): Observable<SpeciesCloneDto> {
    return this.nepenthesNameCloneGet$Response(params, context).pipe(
      map((r: StrictHttpResponse<SpeciesCloneDto>): SpeciesCloneDto => r.body)
    );
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

  /** Path part for operation `cloneSpeciesGet()` */
  static readonly CloneSpeciesGetPath = '/clone/species/';

  /**
   * get all Species Clones.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `cloneSpeciesGet()` instead.
   *
   * This method doesn't expect any request body.
   */
  cloneSpeciesGet$Response(params?: CloneSpeciesGet$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<SpeciesCloneDto>>> {
    return cloneSpeciesGet(this.http, this.rootUrl, params, context);
  }

  /**
   * get all Species Clones.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `cloneSpeciesGet$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  cloneSpeciesGet(params?: CloneSpeciesGet$Params, context?: HttpContext): Observable<Array<SpeciesCloneDto>> {
    return this.cloneSpeciesGet$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<SpeciesCloneDto>>): Array<SpeciesCloneDto> => r.body)
    );
  }

  /** Path part for operation `cloneSpeciesIvPut()` */
  static readonly CloneSpeciesIvPutPath = '/clone/species/iv';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `cloneSpeciesIvPut()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  cloneSpeciesIvPut$Response(params: CloneSpeciesIvPut$Params, context?: HttpContext): Observable<StrictHttpResponse<SpeciesCloneDto>> {
    return cloneSpeciesIvPut(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `cloneSpeciesIvPut$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  cloneSpeciesIvPut(params: CloneSpeciesIvPut$Params, context?: HttpContext): Observable<SpeciesCloneDto> {
    return this.cloneSpeciesIvPut$Response(params, context).pipe(
      map((r: StrictHttpResponse<SpeciesCloneDto>): SpeciesCloneDto => r.body)
    );
  }

  /** Path part for operation `cloneSpeciesIvPost()` */
  static readonly CloneSpeciesIvPostPath = '/clone/species/iv';

  /**
   * add a new iv clone of a nepenthes.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `cloneSpeciesIvPost()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  cloneSpeciesIvPost$Response(params: CloneSpeciesIvPost$Params, context?: HttpContext): Observable<StrictHttpResponse<SpeciesCloneDto>> {
    return cloneSpeciesIvPost(this.http, this.rootUrl, params, context);
  }

  /**
   * add a new iv clone of a nepenthes.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `cloneSpeciesIvPost$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  cloneSpeciesIvPost(params: CloneSpeciesIvPost$Params, context?: HttpContext): Observable<SpeciesCloneDto> {
    return this.cloneSpeciesIvPost$Response(params, context).pipe(
      map((r: StrictHttpResponse<SpeciesCloneDto>): SpeciesCloneDto => r.body)
    );
  }

  /** Path part for operation `cloneSpeciesIcPut()` */
  static readonly CloneSpeciesIcPutPath = '/clone/species/ic';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `cloneSpeciesIcPut()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  cloneSpeciesIcPut$Response(params: CloneSpeciesIcPut$Params, context?: HttpContext): Observable<StrictHttpResponse<SpeciesCloneDto>> {
    return cloneSpeciesIcPut(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `cloneSpeciesIcPut$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  cloneSpeciesIcPut(params: CloneSpeciesIcPut$Params, context?: HttpContext): Observable<SpeciesCloneDto> {
    return this.cloneSpeciesIcPut$Response(params, context).pipe(
      map((r: StrictHttpResponse<SpeciesCloneDto>): SpeciesCloneDto => r.body)
    );
  }

  /** Path part for operation `cloneSpeciesIcPost()` */
  static readonly CloneSpeciesIcPostPath = '/clone/species/ic';

  /**
   * add a new iv clone of a nepenthes.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `cloneSpeciesIcPost()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  cloneSpeciesIcPost$Response(params: CloneSpeciesIcPost$Params, context?: HttpContext): Observable<StrictHttpResponse<SpeciesCloneDto>> {
    return cloneSpeciesIcPost(this.http, this.rootUrl, params, context);
  }

  /**
   * add a new iv clone of a nepenthes.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `cloneSpeciesIcPost$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  cloneSpeciesIcPost(params: CloneSpeciesIcPost$Params, context?: HttpContext): Observable<SpeciesCloneDto> {
    return this.cloneSpeciesIcPost$Response(params, context).pipe(
      map((r: StrictHttpResponse<SpeciesCloneDto>): SpeciesCloneDto => r.body)
    );
  }

  /** Path part for operation `cloneHybridsGet()` */
  static readonly CloneHybridsGetPath = '/clone/hybrids/';

  /**
   * get all hybrid Clones.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `cloneHybridsGet()` instead.
   *
   * This method doesn't expect any request body.
   */
  cloneHybridsGet$Response(params?: CloneHybridsGet$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<HybridCloneDto>>> {
    return cloneHybridsGet(this.http, this.rootUrl, params, context);
  }

  /**
   * get all hybrid Clones.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `cloneHybridsGet$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  cloneHybridsGet(params?: CloneHybridsGet$Params, context?: HttpContext): Observable<Array<HybridCloneDto>> {
    return this.cloneHybridsGet$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<HybridCloneDto>>): Array<HybridCloneDto> => r.body)
    );
  }

  /** Path part for operation `cloneHybridsIvGet()` */
  static readonly CloneHybridsIvGetPath = '/clone/hybrids/iv';

  /**
   * get all IV Hybrids.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `cloneHybridsIvGet()` instead.
   *
   * This method doesn't expect any request body.
   */
  cloneHybridsIvGet$Response(params?: CloneHybridsIvGet$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<HybridCloneDto>>> {
    return cloneHybridsIvGet(this.http, this.rootUrl, params, context);
  }

  /**
   * get all IV Hybrids.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `cloneHybridsIvGet$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  cloneHybridsIvGet(params?: CloneHybridsIvGet$Params, context?: HttpContext): Observable<Array<HybridCloneDto>> {
    return this.cloneHybridsIvGet$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<HybridCloneDto>>): Array<HybridCloneDto> => r.body)
    );
  }

  /** Path part for operation `cloneHybridsIvPut()` */
  static readonly CloneHybridsIvPutPath = '/clone/hybrids/iv';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `cloneHybridsIvPut()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  cloneHybridsIvPut$Response(params: CloneHybridsIvPut$Params, context?: HttpContext): Observable<StrictHttpResponse<HybridCloneDto>> {
    return cloneHybridsIvPut(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `cloneHybridsIvPut$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  cloneHybridsIvPut(params: CloneHybridsIvPut$Params, context?: HttpContext): Observable<HybridCloneDto> {
    return this.cloneHybridsIvPut$Response(params, context).pipe(
      map((r: StrictHttpResponse<HybridCloneDto>): HybridCloneDto => r.body)
    );
  }

  /** Path part for operation `cloneHybridsIvPost()` */
  static readonly CloneHybridsIvPostPath = '/clone/hybrids/iv';

  /**
   * add a new iv hybrid.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `cloneHybridsIvPost()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  cloneHybridsIvPost$Response(params: CloneHybridsIvPost$Params, context?: HttpContext): Observable<StrictHttpResponse<HybridCloneDto>> {
    return cloneHybridsIvPost(this.http, this.rootUrl, params, context);
  }

  /**
   * add a new iv hybrid.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `cloneHybridsIvPost$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  cloneHybridsIvPost(params: CloneHybridsIvPost$Params, context?: HttpContext): Observable<HybridCloneDto> {
    return this.cloneHybridsIvPost$Response(params, context).pipe(
      map((r: StrictHttpResponse<HybridCloneDto>): HybridCloneDto => r.body)
    );
  }

  /** Path part for operation `cloneHybridsIcGet()` */
  static readonly CloneHybridsIcGetPath = '/clone/hybrids/ic';

  /**
   * get all IC Hybrids.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `cloneHybridsIcGet()` instead.
   *
   * This method doesn't expect any request body.
   */
  cloneHybridsIcGet$Response(params?: CloneHybridsIcGet$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<HybridCloneDto>>> {
    return cloneHybridsIcGet(this.http, this.rootUrl, params, context);
  }

  /**
   * get all IC Hybrids.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `cloneHybridsIcGet$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  cloneHybridsIcGet(params?: CloneHybridsIcGet$Params, context?: HttpContext): Observable<Array<HybridCloneDto>> {
    return this.cloneHybridsIcGet$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<HybridCloneDto>>): Array<HybridCloneDto> => r.body)
    );
  }

  /** Path part for operation `cloneHybridsIcPut()` */
  static readonly CloneHybridsIcPutPath = '/clone/hybrids/ic';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `cloneHybridsIcPut()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  cloneHybridsIcPut$Response(params: CloneHybridsIcPut$Params, context?: HttpContext): Observable<StrictHttpResponse<HybridCloneDto>> {
    return cloneHybridsIcPut(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `cloneHybridsIcPut$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  cloneHybridsIcPut(params: CloneHybridsIcPut$Params, context?: HttpContext): Observable<HybridCloneDto> {
    return this.cloneHybridsIcPut$Response(params, context).pipe(
      map((r: StrictHttpResponse<HybridCloneDto>): HybridCloneDto => r.body)
    );
  }

  /** Path part for operation `cloneHybridsIcPost()` */
  static readonly CloneHybridsIcPostPath = '/clone/hybrids/ic';

  /**
   * add a new iv hybrid clone.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `cloneHybridsIcPost()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  cloneHybridsIcPost$Response(params: CloneHybridsIcPost$Params, context?: HttpContext): Observable<StrictHttpResponse<HybridCloneDto>> {
    return cloneHybridsIcPost(this.http, this.rootUrl, params, context);
  }

  /**
   * add a new iv hybrid clone.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `cloneHybridsIcPost$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  cloneHybridsIcPost(params: CloneHybridsIcPost$Params, context?: HttpContext): Observable<HybridCloneDto> {
    return this.cloneHybridsIcPost$Response(params, context).pipe(
      map((r: StrictHttpResponse<HybridCloneDto>): HybridCloneDto => r.body)
    );
  }

  /** Path part for operation `cloneMultiHybridGet()` */
  static readonly CloneMultiHybridGetPath = '/clone/multi-hybrid/';

  /**
   * get all multi-hybrid Clones.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `cloneMultiHybridGet()` instead.
   *
   * This method doesn't expect any request body.
   */
  cloneMultiHybridGet$Response(params?: CloneMultiHybridGet$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<HybridCloneDto>>> {
    return cloneMultiHybridGet(this.http, this.rootUrl, params, context);
  }

  /**
   * get all multi-hybrid Clones.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `cloneMultiHybridGet$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  cloneMultiHybridGet(params?: CloneMultiHybridGet$Params, context?: HttpContext): Observable<Array<HybridCloneDto>> {
    return this.cloneMultiHybridGet$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<HybridCloneDto>>): Array<HybridCloneDto> => r.body)
    );
  }

  /** Path part for operation `cloneMultiHybridIvGet()` */
  static readonly CloneMultiHybridIvGetPath = '/clone/multi-hybrid/iv';

  /**
   * get all multi-hybrid IV Clones.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `cloneMultiHybridIvGet()` instead.
   *
   * This method doesn't expect any request body.
   */
  cloneMultiHybridIvGet$Response(params?: CloneMultiHybridIvGet$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<HybridCloneDto>>> {
    return cloneMultiHybridIvGet(this.http, this.rootUrl, params, context);
  }

  /**
   * get all multi-hybrid IV Clones.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `cloneMultiHybridIvGet$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  cloneMultiHybridIvGet(params?: CloneMultiHybridIvGet$Params, context?: HttpContext): Observable<Array<HybridCloneDto>> {
    return this.cloneMultiHybridIvGet$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<HybridCloneDto>>): Array<HybridCloneDto> => r.body)
    );
  }

  /** Path part for operation `cloneMultiHybridIvPut()` */
  static readonly CloneMultiHybridIvPutPath = '/clone/multi-hybrid/iv';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `cloneMultiHybridIvPut()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  cloneMultiHybridIvPut$Response(params: CloneMultiHybridIvPut$Params, context?: HttpContext): Observable<StrictHttpResponse<HybridCloneDto>> {
    return cloneMultiHybridIvPut(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `cloneMultiHybridIvPut$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  cloneMultiHybridIvPut(params: CloneMultiHybridIvPut$Params, context?: HttpContext): Observable<HybridCloneDto> {
    return this.cloneMultiHybridIvPut$Response(params, context).pipe(
      map((r: StrictHttpResponse<HybridCloneDto>): HybridCloneDto => r.body)
    );
  }

  /** Path part for operation `cloneMultiHybridIvPost()` */
  static readonly CloneMultiHybridIvPostPath = '/clone/multi-hybrid/iv';

  /**
   * add a new iv multi-hybrid.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `cloneMultiHybridIvPost()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  cloneMultiHybridIvPost$Response(params: CloneMultiHybridIvPost$Params, context?: HttpContext): Observable<StrictHttpResponse<HybridCloneDto>> {
    return cloneMultiHybridIvPost(this.http, this.rootUrl, params, context);
  }

  /**
   * add a new iv multi-hybrid.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `cloneMultiHybridIvPost$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  cloneMultiHybridIvPost(params: CloneMultiHybridIvPost$Params, context?: HttpContext): Observable<HybridCloneDto> {
    return this.cloneMultiHybridIvPost$Response(params, context).pipe(
      map((r: StrictHttpResponse<HybridCloneDto>): HybridCloneDto => r.body)
    );
  }

  /** Path part for operation `cloneMultiHybridIcGet()` */
  static readonly CloneMultiHybridIcGetPath = '/clone/multi-hybrid/ic';

  /**
   * get all multi-hybrid IC Clones.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `cloneMultiHybridIcGet()` instead.
   *
   * This method doesn't expect any request body.
   */
  cloneMultiHybridIcGet$Response(params?: CloneMultiHybridIcGet$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<HybridCloneDto>>> {
    return cloneMultiHybridIcGet(this.http, this.rootUrl, params, context);
  }

  /**
   * get all multi-hybrid IC Clones.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `cloneMultiHybridIcGet$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  cloneMultiHybridIcGet(params?: CloneMultiHybridIcGet$Params, context?: HttpContext): Observable<Array<HybridCloneDto>> {
    return this.cloneMultiHybridIcGet$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<HybridCloneDto>>): Array<HybridCloneDto> => r.body)
    );
  }

  /** Path part for operation `cloneMultiHybridIcPut()` */
  static readonly CloneMultiHybridIcPutPath = '/clone/multi-hybrid/ic';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `cloneMultiHybridIcPut()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  cloneMultiHybridIcPut$Response(params: CloneMultiHybridIcPut$Params, context?: HttpContext): Observable<StrictHttpResponse<HybridCloneDto>> {
    return cloneMultiHybridIcPut(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `cloneMultiHybridIcPut$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  cloneMultiHybridIcPut(params: CloneMultiHybridIcPut$Params, context?: HttpContext): Observable<HybridCloneDto> {
    return this.cloneMultiHybridIcPut$Response(params, context).pipe(
      map((r: StrictHttpResponse<HybridCloneDto>): HybridCloneDto => r.body)
    );
  }

  /** Path part for operation `cloneMultiHybridIcPost()` */
  static readonly CloneMultiHybridIcPostPath = '/clone/multi-hybrid/ic';

  /**
   * add a new iv multi-hybrid clone.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `cloneMultiHybridIcPost()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  cloneMultiHybridIcPost$Response(params: CloneMultiHybridIcPost$Params, context?: HttpContext): Observable<StrictHttpResponse<HybridCloneDto>> {
    return cloneMultiHybridIcPost(this.http, this.rootUrl, params, context);
  }

  /**
   * add a new iv multi-hybrid clone.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `cloneMultiHybridIcPost$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  cloneMultiHybridIcPost(params: CloneMultiHybridIcPost$Params, context?: HttpContext): Observable<HybridCloneDto> {
    return this.cloneMultiHybridIcPost$Response(params, context).pipe(
      map((r: StrictHttpResponse<HybridCloneDto>): HybridCloneDto => r.body)
    );
  }

}
