/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { UserDto } from '../models/user-dto';
import { userGet } from '../fn/user/user-get';
import { UserGet$Params } from '../fn/user/user-get';
import { userPost } from '../fn/user/user-post';
import { UserPost$Params } from '../fn/user/user-post';
import { userPut } from '../fn/user/user-put';
import { UserPut$Params } from '../fn/user/user-put';


/**
 * Operations to manage User
 */
@Injectable({ providedIn: 'root' })
export class UserService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `userGet()` */
  static readonly UserGetPath = '/user';

  /**
   * get Userinformation.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `userGet()` instead.
   *
   * This method doesn't expect any request body.
   */
  userGet$Response(params?: UserGet$Params, context?: HttpContext): Observable<StrictHttpResponse<UserDto>> {
    return userGet(this.http, this.rootUrl, params, context);
  }

  /**
   * get Userinformation.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `userGet$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  userGet(params?: UserGet$Params, context?: HttpContext): Observable<UserDto> {
    return this.userGet$Response(params, context).pipe(
      map((r: StrictHttpResponse<UserDto>): UserDto => r.body)
    );
  }

  /** Path part for operation `userPut()` */
  static readonly UserPutPath = '/user';

  /**
   * Update Information of User.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `userPut()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  userPut$Response(params: UserPut$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return userPut(this.http, this.rootUrl, params, context);
  }

  /**
   * Update Information of User.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `userPut$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  userPut(params: UserPut$Params, context?: HttpContext): Observable<void> {
    return this.userPut$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `userPost()` */
  static readonly UserPostPath = '/user';

  /**
   * Create an User in the Application with minimal sensitive Information.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `userPost()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  userPost$Response(params: UserPost$Params, context?: HttpContext): Observable<StrictHttpResponse<UserDto>> {
    return userPost(this.http, this.rootUrl, params, context);
  }

  /**
   * Create an User in the Application with minimal sensitive Information.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `userPost$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  userPost(params: UserPost$Params, context?: HttpContext): Observable<UserDto> {
    return this.userPost$Response(params, context).pipe(
      map((r: StrictHttpResponse<UserDto>): UserDto => r.body)
    );
  }

}
