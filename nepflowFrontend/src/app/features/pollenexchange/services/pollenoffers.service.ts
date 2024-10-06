/* tslint:disable */
/* eslint-disable */
import {HttpClient, HttpContext} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';

import {BaseService} from "../../../core/openApiGeneratedFiles/base-service";
import {ApiConfiguration} from "../../../core/openApiGeneratedFiles/api-configuration";
import {StrictHttpResponse} from "../../../core/openApiGeneratedFiles/strict-http-response";

import {
  pollenexchangePollenoffersDatesGet,
  PollenexchangePollenoffersDatesGet$Params
} from '../fn/pollenoffers/pollenexchange-pollenoffers-dates-get';
import {
  pollenexchangePollenoffersOpenGet,
  PollenexchangePollenoffersOpenGet$Params
} from '../fn/pollenoffers/pollenexchange-pollenoffers-open-get';
import {
  pollenexchangeUsernamePollenoffersOpenGet,
  PollenexchangeUsernamePollenoffersOpenGet$Params
} from '../fn/pollenoffers/pollenexchange-username-pollenoffers-open-get';
import {
  pollenexchangeUsernamePollenoffersStatisticsGet,
  PollenexchangeUsernamePollenoffersStatisticsGet$Params
} from '../fn/pollenoffers/pollenexchange-username-pollenoffers-statistics-get';
import {PollenOfferDateContainerDto} from '../models/pollen-offer-date-container-dto';
import {PollenOfferDto} from '../models/pollen-offer-dto';
import {PollenOfferSpeciesStatisticsDto} from '../models/pollen-offer-species-statistics-dto';


/**
 * Operations to manage and retrive PollenOffers
 */
@Injectable({ providedIn: 'root' })
export class PollenoffersService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `pollenexchangePollenoffersDatesGet()` */
  static readonly PollenexchangePollenoffersDatesGetPath = '/pollenexchange/pollenoffers/dates';

  /**
   * return stored dates (Month-Year).
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `pollenexchangePollenoffersDatesGet()` instead.
   *
   * This method doesn't expect any request body.
   */
  pollenexchangePollenoffersDatesGet$Response(params?: PollenexchangePollenoffersDatesGet$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<string>>> {
    return pollenexchangePollenoffersDatesGet(this.http, this.rootUrl, params, context);
  }

  /**
   * return stored dates (Month-Year).
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `pollenexchangePollenoffersDatesGet$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  pollenexchangePollenoffersDatesGet(params?: PollenexchangePollenoffersDatesGet$Params, context?: HttpContext): Observable<Array<string>> {
    return this.pollenexchangePollenoffersDatesGet$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<string>>): Array<string> => r.body)
    );
  }

  /** Path part for operation `pollenexchangePollenoffersOpenGet()` */
  static readonly PollenexchangePollenoffersOpenGetPath = '/pollenexchange/pollenoffers/open';

  /**
   * return open PollenOffers by Month-Year.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `pollenexchangePollenoffersOpenGet()` instead.
   *
   * This method doesn't expect any request body.
   */
  pollenexchangePollenoffersOpenGet$Response(params?: PollenexchangePollenoffersOpenGet$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<PollenOfferDateContainerDto>>> {
    return pollenexchangePollenoffersOpenGet(this.http, this.rootUrl, params, context);
  }

  /**
   * return open PollenOffers by Month-Year.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `pollenexchangePollenoffersOpenGet$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  pollenexchangePollenoffersOpenGet(params?: PollenexchangePollenoffersOpenGet$Params, context?: HttpContext): Observable<Array<PollenOfferDateContainerDto>> {
    return this.pollenexchangePollenoffersOpenGet$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<PollenOfferDateContainerDto>>): Array<PollenOfferDateContainerDto> => r.body)
    );
  }

  /** Path part for operation `pollenexchangeUsernamePollenoffersOpenGet()` */
  static readonly PollenexchangeUsernamePollenoffersOpenGetPath = '/pollenexchange/{username}/pollenoffers/open';

  /**
   * return all open PollenOffers of the user.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `pollenexchangeUsernamePollenoffersOpenGet()` instead.
   *
   * This method doesn't expect any request body.
   */
  pollenexchangeUsernamePollenoffersOpenGet$Response(params: PollenexchangeUsernamePollenoffersOpenGet$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<PollenOfferDto>>> {
    return pollenexchangeUsernamePollenoffersOpenGet(this.http, this.rootUrl, params, context);
  }

  /**
   * return all open PollenOffers of the user.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `pollenexchangeUsernamePollenoffersOpenGet$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  pollenexchangeUsernamePollenoffersOpenGet(params: PollenexchangeUsernamePollenoffersOpenGet$Params, context?: HttpContext): Observable<Array<PollenOfferDto>> {
    return this.pollenexchangeUsernamePollenoffersOpenGet$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<PollenOfferDto>>): Array<PollenOfferDto> => r.body)
    );
  }

  /** Path part for operation `pollenexchangeUsernamePollenoffersStatisticsGet()` */
  static readonly PollenexchangeUsernamePollenoffersStatisticsGetPath = '/pollenexchange/{username}/pollenoffers/statistics';

  /**
   * return PollenOffer statistics on the different specimens.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `pollenexchangeUsernamePollenoffersStatisticsGet()` instead.
   *
   * This method doesn't expect any request body.
   */
  pollenexchangeUsernamePollenoffersStatisticsGet$Response(params: PollenexchangeUsernamePollenoffersStatisticsGet$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<PollenOfferSpeciesStatisticsDto>>> {
    return pollenexchangeUsernamePollenoffersStatisticsGet(this.http, this.rootUrl, params, context);
  }

  /**
   * return PollenOffer statistics on the different specimens.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `pollenexchangeUsernamePollenoffersStatisticsGet$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  pollenexchangeUsernamePollenoffersStatisticsGet(params: PollenexchangeUsernamePollenoffersStatisticsGet$Params, context?: HttpContext): Observable<Array<PollenOfferSpeciesStatisticsDto>> {
    return this.pollenexchangeUsernamePollenoffersStatisticsGet$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<PollenOfferSpeciesStatisticsDto>>): Array<PollenOfferSpeciesStatisticsDto> => r.body)
    );
  }

}
