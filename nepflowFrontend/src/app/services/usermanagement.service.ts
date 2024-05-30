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
import {userGet, UserGet$Params} from '../fn/usermanagement/user-get';
import { userPost } from '../fn/usermanagement/user-post';
import { UserPost$Params } from '../fn/usermanagement/user-post';
import { UserPrivacyDto } from '../models/user-privacy-dto';
import { userPut } from '../fn/usermanagement/user-put';
import { UserPut$Params } from '../fn/usermanagement/user-put';
import { usersGet } from '../fn/usermanagement/users-get';
import { UsersGet$Params } from '../fn/usermanagement/users-get';
import { usersUsernameGet } from '../fn/usermanagement/users-username-get';
import { UsersUsernameGet$Params } from '../fn/usermanagement/users-username-get';


/**
 * Operations to manage and retrive Users
 */
@Injectable({ providedIn: 'root' })
export class UsermanagementService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `userGet()` */
  static readonly UserGetPath = '/user';

  /**
   * return current User.
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
   * return current User.
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
  userPut$Response(params: UserPut$Params, context?: HttpContext): Observable<StrictHttpResponse<UserDto>> {
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
  userPut(params: UserPut$Params, context?: HttpContext): Observable<UserDto> {
    return this.userPut$Response(params, context).pipe(
      map((r: StrictHttpResponse<UserDto>): UserDto => r.body)
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

  /** Path part for operation `usersGet()` */
  static readonly UsersGetPath = '/users';

  /**
   * get all Users.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `usersGet()` instead.
   *
   * This method doesn't expect any request body.
   */
  usersGet$Response(params?: UsersGet$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<UserPrivacyDto>>> {
    return usersGet(this.http, this.rootUrl, params, context);
  }

  /**
   * get all Users.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `usersGet$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  usersGet(params?: UsersGet$Params, context?: HttpContext): Observable<Array<UserPrivacyDto>> {
    return this.usersGet$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<UserPrivacyDto>>): Array<UserPrivacyDto> => r.body)
    );
  }

  /** Path part for operation `usersUsernameGet()` */
  static readonly UsersUsernameGetPath = '/users/{username}';

  /**
   * get Userinformation.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `usersUsernameGet()` instead.
   *
   * This method doesn't expect any request body.
   */
  usersUsernameGet$Response(params: UsersUsernameGet$Params, context?: HttpContext): Observable<StrictHttpResponse<UserPrivacyDto>> {
    return usersUsernameGet(this.http, this.rootUrl, params, context);
  }

  /**
   * get Userinformation.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `usersUsernameGet$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  usersUsernameGet(params: UsersUsernameGet$Params, context?: HttpContext): Observable<UserPrivacyDto> {
    return this.usersUsernameGet$Response(params, context).pipe(
      map((r: StrictHttpResponse<UserPrivacyDto>): UserPrivacyDto => r.body)
    );
  }

}
