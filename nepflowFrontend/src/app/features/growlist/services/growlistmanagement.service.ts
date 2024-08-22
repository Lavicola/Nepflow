/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {BaseService} from "../../../core/openApiGeneratedFiles/base-service";
import {ApiConfiguration} from "../../../core/openApiGeneratedFiles/api-configuration";

import {growlistGrowlistIdPublicPatch,GrowlistGrowlistIdPublicPatch$Params} from "../fn/growlistmanagement/growlist-growlist-id-public-patch";
import {StrictHttpResponse} from "../../../core/openApiGeneratedFiles/strict-http-response";
import {SpecimenCloneDto} from "../models/specimen-clone-dto";
import {SpecimenUpdateSex} from "../models/specimen-update-sex";
import {SpecimenUpdateFlowerStatus} from "../models/specimen-update-flower-status";
import {GrowlistDto} from "../models/growlist-dto";
import { growlistUsernameClonesGet } from '../fn/growlistmanagement/growlist-username-clones-get';
import { GrowlistUsernameClonesGet$Params } from '../fn/growlistmanagement/growlist-username-clones-get';
import { specimensSpecimenIdDelete } from '../fn/growlistmanagement/specimens-specimen-id-delete';
import { SpecimensSpecimenIdDelete$Params } from '../fn/growlistmanagement/specimens-specimen-id-delete';
import { specimensSpecimenIdFloweringPatch } from '../fn/growlistmanagement/specimens-specimen-id-flowering-patch';
import { SpecimensSpecimenIdFloweringPatch$Params } from '../fn/growlistmanagement/specimens-specimen-id-flowering-patch';
import { specimensSpecimenIdGet } from '../fn/growlistmanagement/specimens-specimen-id-get';
import { SpecimensSpecimenIdGet$Params } from '../fn/growlistmanagement/specimens-specimen-id-get';
import { specimensSpecimenIdImagePut } from '../fn/growlistmanagement/specimens-specimen-id-image-put';
import { SpecimensSpecimenIdImagePut$Params } from '../fn/growlistmanagement/specimens-specimen-id-image-put';
import { specimensSpecimenIdSexPatch } from '../fn/growlistmanagement/specimens-specimen-id-sex-patch';
import { SpecimensSpecimenIdSexPatch$Params } from '../fn/growlistmanagement/specimens-specimen-id-sex-patch';
import { growlistCloneAddInternalCloneIdPost } from '../fn/growlistmanagement/growlist-clone-add-internal-clone-id-post';
import { GrowlistCloneAddInternalCloneIdPost$Params } from '../fn/growlistmanagement/growlist-clone-add-internal-clone-id-post';
import { growlistCreateCloneCloneTypePost } from '../fn/growlistmanagement/growlist-create-clone-clone-type-post';
import { GrowlistCreateCloneCloneTypePost$Params } from '../fn/growlistmanagement/growlist-create-clone-clone-type-post';
import { growlistCreateNepenthesCloneTypePost } from '../fn/growlistmanagement/growlist-create-nepenthes-clone-type-post';
import { GrowlistCreateNepenthesCloneTypePost$Params } from '../fn/growlistmanagement/growlist-create-nepenthes-clone-type-post';
import {GrowlistPublic} from "../models/growlist-public";





/**
 * Operations for the GrowlistManagement of an user
 */
@Injectable({providedIn: 'root'})
export class GrowlistmanagementService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `growlistGrowlistIdPublicPatch()` */
  static readonly GrowlistGrowlistIdPublicPatchPath = '/growlist/{growlistId}/public';

  /**
   * set Growlist to public or private.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `growlistGrowlistIdPublicPatch()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  growlistGrowlistIdPublicPatch$Response(params: GrowlistGrowlistIdPublicPatch$Params, context?: HttpContext): Observable<StrictHttpResponse<GrowlistPublic>> {
    return growlistGrowlistIdPublicPatch(this.http, this.rootUrl, params, context);
  }

  /**
   * set Growlist to public or private.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `growlistGrowlistIdPublicPatch$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  growlistGrowlistIdPublicPatch(params: GrowlistGrowlistIdPublicPatch$Params, context?: HttpContext): Observable<GrowlistPublic> {
    return this.growlistGrowlistIdPublicPatch$Response(params, context).pipe(
      map((r: StrictHttpResponse<GrowlistPublic>): GrowlistPublic => r.body)
    );
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

  /** Path part for operation `growlistCreateCloneCloneTypePost()` */
  static readonly GrowlistCreateCloneCloneTypePostPath = '/growlist/create/clone/{cloneType}';

  /**
   * Create a new IV or IC Clone and Add it to the Growlist.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `growlistCreateCloneCloneTypePost()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  growlistCreateCloneCloneTypePost$Response(params: GrowlistCreateCloneCloneTypePost$Params, context?: HttpContext): Observable<StrictHttpResponse<SpecimenCloneDto>> {
    return growlistCreateCloneCloneTypePost(this.http, this.rootUrl, params, context);
  }

  /**
   * Create a new IV or IC Clone and Add it to the Growlist.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `growlistCreateCloneCloneTypePost$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  growlistCreateCloneCloneTypePost(params: GrowlistCreateCloneCloneTypePost$Params, context?: HttpContext): Observable<SpecimenCloneDto> {
    return this.growlistCreateCloneCloneTypePost$Response(params, context).pipe(
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

  /** Path part for operation `specimensSpecimenIdGet()` */
  static readonly SpecimensSpecimenIdGetPath = '/specimens/{specimenId}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `specimensSpecimenIdGet()` instead.
   *
   * This method doesn't expect any request body.
   */
  specimensSpecimenIdGet$Response(params: SpecimensSpecimenIdGet$Params, context?: HttpContext): Observable<StrictHttpResponse<SpecimenCloneDto>> {
    return specimensSpecimenIdGet(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `specimensSpecimenIdGet$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  specimensSpecimenIdGet(params: SpecimensSpecimenIdGet$Params, context?: HttpContext): Observable<SpecimenCloneDto> {
    return this.specimensSpecimenIdGet$Response(params, context).pipe(
      map((r: StrictHttpResponse<SpecimenCloneDto>): SpecimenCloneDto => r.body)
    );
  }

  /** Path part for operation `specimensSpecimenIdDelete()` */
  static readonly SpecimensSpecimenIdDeletePath = '/specimens/{specimenId}';

  /**
   * remove a specimen from the growlistist. If the removed plant was already used for a trade, only a soft delete will happen.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `specimensSpecimenIdDelete()` instead.
   *
   * This method doesn't expect any request body.
   */
  specimensSpecimenIdDelete$Response(params: SpecimensSpecimenIdDelete$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return specimensSpecimenIdDelete(this.http, this.rootUrl, params, context);
  }

  /**
   * remove a specimen from the growlistist. If the removed plant was already used for a trade, only a soft delete will happen.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `specimensSpecimenIdDelete$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  specimensSpecimenIdDelete(params: SpecimensSpecimenIdDelete$Params, context?: HttpContext): Observable<void> {
    return this.specimensSpecimenIdDelete$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `specimensSpecimenIdSexPatch()` */
  static readonly SpecimensSpecimenIdSexPatchPath = '/specimens/{specimenId}/sex';

  /**
   * Update Sex of a specific Specimen, only works if Specimes current sex is unkown.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `specimensSpecimenIdSexPatch()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  specimensSpecimenIdSexPatch$Response(params: SpecimensSpecimenIdSexPatch$Params, context?: HttpContext): Observable<StrictHttpResponse<SpecimenUpdateSex>> {
    return specimensSpecimenIdSexPatch(this.http, this.rootUrl, params, context);
  }

  /**
   * Update Sex of a specific Specimen, only works if Specimes current sex is unkown.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `specimensSpecimenIdSexPatch$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  specimensSpecimenIdSexPatch(params: SpecimensSpecimenIdSexPatch$Params, context?: HttpContext): Observable<SpecimenUpdateSex> {
    return this.specimensSpecimenIdSexPatch$Response(params, context).pipe(
      map((r: StrictHttpResponse<SpecimenUpdateSex>): SpecimenUpdateSex => r.body)
    );
  }

  /** Path part for operation `specimensSpecimenIdFloweringPatch()` */
  static readonly SpecimensSpecimenIdFloweringPatchPath = '/specimens/{specimenId}/flowering';

  /**
   * Update the flowering status of a clone.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `specimensSpecimenIdFloweringPatch()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  specimensSpecimenIdFloweringPatch$Response(params: SpecimensSpecimenIdFloweringPatch$Params, context?: HttpContext): Observable<StrictHttpResponse<SpecimenUpdateFlowerStatus>> {
    return specimensSpecimenIdFloweringPatch(this.http, this.rootUrl, params, context);
  }

  /**
   * Update the flowering status of a clone.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `specimensSpecimenIdFloweringPatch$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  specimensSpecimenIdFloweringPatch(params: SpecimensSpecimenIdFloweringPatch$Params, context?: HttpContext): Observable<SpecimenUpdateFlowerStatus> {
    return this.specimensSpecimenIdFloweringPatch$Response(params, context).pipe(
      map((r: StrictHttpResponse<SpecimenUpdateFlowerStatus>): SpecimenUpdateFlowerStatus => r.body)
    );
  }

  /** Path part for operation `specimensSpecimenIdImagePut()` */
  static readonly SpecimensSpecimenIdImagePutPath = '/specimens/{specimenId}/image';

  /**
   * update Image.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `specimensSpecimenIdImagePut()` instead.
   *
   * This method sends `multipart/form-data` and handles request body of type `multipart/form-data`.
   */
  specimensSpecimenIdImagePut$Response(params: SpecimensSpecimenIdImagePut$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return specimensSpecimenIdImagePut(this.http, this.rootUrl, params, context);
  }

  /**
   * update Image.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `specimensSpecimenIdImagePut$Response()` instead.
   *
   * This method sends `multipart/form-data` and handles request body of type `multipart/form-data`.
   */
  specimensSpecimenIdImagePut(params: SpecimensSpecimenIdImagePut$Params, context?: HttpContext): Observable<void> {
    return this.specimensSpecimenIdImagePut$Response(params, context).pipe(
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
