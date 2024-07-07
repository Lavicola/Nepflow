/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../../../base-service';
import { ApiConfiguration } from '../../../api-configuration';
import { StrictHttpResponse } from '../../../strict-http-response';

import { growlistCloneAddInternalCloneIdPost } from '../fn/growlistmanagement/growlist-clone-add-internal-clone-id-post';
import { GrowlistCloneAddInternalCloneIdPost$Params } from '../fn/growlistmanagement/growlist-clone-add-internal-clone-id-post';
import { growlistCloneCreateCloneTypePost } from '../fn/growlistmanagement/growlist-clone-create-clone-type-post';
import { GrowlistCloneCreateCloneTypePost$Params } from '../fn/growlistmanagement/growlist-clone-create-clone-type-post';
import { growlistClonesSpecimenIdDelete } from '../fn/growlistmanagement/growlist-clones-specimen-id-delete';
import { GrowlistClonesSpecimenIdDelete$Params } from '../fn/growlistmanagement/growlist-clones-specimen-id-delete';
import { growlistClonesSpecimenIdGet } from '../fn/growlistmanagement/growlist-clones-specimen-id-get';
import { GrowlistClonesSpecimenIdGet$Params } from '../fn/growlistmanagement/growlist-clones-specimen-id-get';
import { growlistClonesSpecimenIdPut } from '../fn/growlistmanagement/growlist-clones-specimen-id-put';
import { GrowlistClonesSpecimenIdPut$Params } from '../fn/growlistmanagement/growlist-clones-specimen-id-put';
import { growlistCreateNepenthesCloneTypePost } from '../fn/growlistmanagement/growlist-create-nepenthes-clone-type-post';
import { GrowlistCreateNepenthesCloneTypePost$Params } from '../fn/growlistmanagement/growlist-create-nepenthes-clone-type-post';
import { GrowlistDto } from '../models/growlist-dto';
import { growlistUsernameClonesGet } from '../fn/growlistmanagement/growlist-username-clones-get';
import { GrowlistUsernameClonesGet$Params } from '../fn/growlistmanagement/growlist-username-clones-get';
import { SpecimenCloneDto } from '../models/specimen-clone-dto';

@Injectable({ providedIn: 'root' })
export class GrowlistmanagementService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `growlistCloneAddInternalCloneIdPost()` */
  static readonly GrowlistCloneAddInternalCloneIdPostPath = '/growlist/clone/add/{internalCloneId}';

  /**
   * Add an existing Clone of a Nepenthes to the Growlist.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `growlistCloneAddInternalCloneIdPost()` instead.
   *
   * This method doesn't expect any request body.
   */
  growlistCloneAddInternalCloneIdPost$Response(params: GrowlistCloneAddInternalCloneIdPost$Params, context?: HttpContext): Observable<StrictHttpResponse<SpecimenCloneDto>> {
    return growlistCloneAddInternalCloneIdPost(this.http, this.rootUrl, params, context);
  }

  /**
   * Add an existing Clone of a Nepenthes to the Growlist.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `growlistCloneAddInternalCloneIdPost$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  growlistCloneAddInternalCloneIdPost(params: GrowlistCloneAddInternalCloneIdPost$Params, context?: HttpContext): Observable<SpecimenCloneDto> {
    return this.growlistCloneAddInternalCloneIdPost$Response(params, context).pipe(
      map((r: StrictHttpResponse<SpecimenCloneDto>): SpecimenCloneDto => r.body)
    );
  }

  /** Path part for operation `growlistCloneCreateCloneTypePost()` */
  static readonly GrowlistCloneCreateCloneTypePostPath = '/growlist/clone/create/{cloneType}';

  /**
   * Create a new IV or IC Clone and Add it to the Growlist.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `growlistCloneCreateCloneTypePost()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  growlistCloneCreateCloneTypePost$Response(params: GrowlistCloneCreateCloneTypePost$Params, context?: HttpContext): Observable<StrictHttpResponse<SpecimenCloneDto>> {
    return growlistCloneCreateCloneTypePost(this.http, this.rootUrl, params, context);
  }

  /**
   * Create a new IV or IC Clone and Add it to the Growlist.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `growlistCloneCreateCloneTypePost$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  growlistCloneCreateCloneTypePost(params: GrowlistCloneCreateCloneTypePost$Params, context?: HttpContext): Observable<SpecimenCloneDto> {
    return this.growlistCloneCreateCloneTypePost$Response(params, context).pipe(
      map((r: StrictHttpResponse<SpecimenCloneDto>): SpecimenCloneDto => r.body)
    );
  }

  /** Path part for operation `growlistCreateNepenthesCloneTypePost()` */
  static readonly GrowlistCreateNepenthesCloneTypePostPath = '/growlist/create/nepenthes/{cloneType}';

  /**
   * Create a new Nepenthes and an additional IV or IC Clone and Add it to the Growlist.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `growlistCreateNepenthesCloneTypePost()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  growlistCreateNepenthesCloneTypePost$Response(params: GrowlistCreateNepenthesCloneTypePost$Params, context?: HttpContext): Observable<StrictHttpResponse<SpecimenCloneDto>> {
    return growlistCreateNepenthesCloneTypePost(this.http, this.rootUrl, params, context);
  }

  /**
   * Create a new Nepenthes and an additional IV or IC Clone and Add it to the Growlist.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `growlistCreateNepenthesCloneTypePost$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  growlistCreateNepenthesCloneTypePost(params: GrowlistCreateNepenthesCloneTypePost$Params, context?: HttpContext): Observable<SpecimenCloneDto> {
    return this.growlistCreateNepenthesCloneTypePost$Response(params, context).pipe(
      map((r: StrictHttpResponse<SpecimenCloneDto>): SpecimenCloneDto => r.body)
    );
  }

  /** Path part for operation `growlistClonesSpecimenIdGet()` */
  static readonly GrowlistClonesSpecimenIdGetPath = '/growlist/clones/{specimenId}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `growlistClonesSpecimenIdGet()` instead.
   *
   * This method doesn't expect any request body.
   */
  growlistClonesSpecimenIdGet$Response(params: GrowlistClonesSpecimenIdGet$Params, context?: HttpContext): Observable<StrictHttpResponse<SpecimenCloneDto>> {
    return growlistClonesSpecimenIdGet(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `growlistClonesSpecimenIdGet$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  growlistClonesSpecimenIdGet(params: GrowlistClonesSpecimenIdGet$Params, context?: HttpContext): Observable<SpecimenCloneDto> {
    return this.growlistClonesSpecimenIdGet$Response(params, context).pipe(
      map((r: StrictHttpResponse<SpecimenCloneDto>): SpecimenCloneDto => r.body)
    );
  }

  /** Path part for operation `growlistClonesSpecimenIdPut()` */
  static readonly GrowlistClonesSpecimenIdPutPath = '/growlist/clones/{specimenId}';

  /**
   * update values.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `growlistClonesSpecimenIdPut()` instead.
   *
   * This method sends `multipart/form-data` and handles request body of type `multipart/form-data`.
   */
  growlistClonesSpecimenIdPut$Response(params: GrowlistClonesSpecimenIdPut$Params, context?: HttpContext): Observable<StrictHttpResponse<SpecimenCloneDto>> {
    return growlistClonesSpecimenIdPut(this.http, this.rootUrl, params, context);
  }

  /**
   * update values.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `growlistClonesSpecimenIdPut$Response()` instead.
   *
   * This method sends `multipart/form-data` and handles request body of type `multipart/form-data`.
   */
  growlistClonesSpecimenIdPut(params: GrowlistClonesSpecimenIdPut$Params, context?: HttpContext): Observable<SpecimenCloneDto> {
    return this.growlistClonesSpecimenIdPut$Response(params, context).pipe(
      map((r: StrictHttpResponse<SpecimenCloneDto>): SpecimenCloneDto => r.body)
    );
  }

  /** Path part for operation `growlistClonesSpecimenIdDelete()` */
  static readonly GrowlistClonesSpecimenIdDeletePath = '/growlist/clones/{specimenId}';

  /**
   * remove a clone from the growlisti If the removed plant was already used for a trade it will be a soft delete in the relation part.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `growlistClonesSpecimenIdDelete()` instead.
   *
   * This method doesn't expect any request body.
   */
  growlistClonesSpecimenIdDelete$Response(params: GrowlistClonesSpecimenIdDelete$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return growlistClonesSpecimenIdDelete(this.http, this.rootUrl, params, context);
  }

  /**
   * remove a clone from the growlisti If the removed plant was already used for a trade it will be a soft delete in the relation part.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `growlistClonesSpecimenIdDelete$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  growlistClonesSpecimenIdDelete(params: GrowlistClonesSpecimenIdDelete$Params, context?: HttpContext): Observable<void> {
    return this.growlistClonesSpecimenIdDelete$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `growlistUsernameClonesGet()` */
  static readonly GrowlistUsernameClonesGetPath = '/growlist/{username}/clones';

  /**
   * get all Specimens of a specific User, if Growlist is public.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `growlistUsernameClonesGet()` instead.
   *
   * This method doesn't expect any request body.
   */
  growlistUsernameClonesGet$Response(params: GrowlistUsernameClonesGet$Params, context?: HttpContext): Observable<StrictHttpResponse<GrowlistDto>> {
    return growlistUsernameClonesGet(this.http, this.rootUrl, params, context);
  }

  /**
   * get all Specimens of a specific User, if Growlist is public.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `growlistUsernameClonesGet$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  growlistUsernameClonesGet(params: GrowlistUsernameClonesGet$Params, context?: HttpContext): Observable<GrowlistDto> {
    return this.growlistUsernameClonesGet$Response(params, context).pipe(
      map((r: StrictHttpResponse<GrowlistDto>): GrowlistDto => r.body)
    );
  }

}
