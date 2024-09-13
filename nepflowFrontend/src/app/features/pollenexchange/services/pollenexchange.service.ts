/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';


import { pollenexchangeCreateTradePost } from '../fn/pollenexchange/pollenexchange-create-trade-post';
import { PollenexchangeCreateTradePost$Params } from '../fn/pollenexchange/pollenexchange-create-trade-post';
import { pollenexchangePollenoffersDatesGet } from '../fn/pollenexchange/pollenexchange-pollenoffers-dates-get';
import { PollenexchangePollenoffersDatesGet$Params } from '../fn/pollenexchange/pollenexchange-pollenoffers-dates-get';
import { pollenexchangePollenoffersOpenGet } from '../fn/pollenexchange/pollenexchange-pollenoffers-open-get';
import { PollenexchangePollenoffersOpenGet$Params } from '../fn/pollenexchange/pollenexchange-pollenoffers-open-get';
import { pollenexchangeTradesDatesGet } from '../fn/pollenexchange/pollenexchange-trades-dates-get';
import { PollenexchangeTradesDatesGet$Params } from '../fn/pollenexchange/pollenexchange-trades-dates-get';
import { pollenexchangeTradeTradeIdGet } from '../fn/pollenexchange/pollenexchange-trade-trade-id-get';
import { PollenexchangeTradeTradeIdGet$Params } from '../fn/pollenexchange/pollenexchange-trade-trade-id-get';
import { pollenexchangeTradeTradeIdPut } from '../fn/pollenexchange/pollenexchange-trade-trade-id-put';
import { PollenexchangeTradeTradeIdPut$Params } from '../fn/pollenexchange/pollenexchange-trade-trade-id-put';
import { pollenexchangeUsernamePollenoffersOpenGet } from '../fn/pollenexchange/pollenexchange-username-pollenoffers-open-get';
import { PollenexchangeUsernamePollenoffersOpenGet$Params } from '../fn/pollenexchange/pollenexchange-username-pollenoffers-open-get';
import { pollenexchangeUsernamePollenoffersStatisticsGet } from '../fn/pollenexchange/pollenexchange-username-pollenoffers-statistics-get';
import { PollenexchangeUsernamePollenoffersStatisticsGet$Params } from '../fn/pollenexchange/pollenexchange-username-pollenoffers-statistics-get';
import { pollenexchangeUsernameTradesGet } from '../fn/pollenexchange/pollenexchange-username-trades-get';
import { PollenexchangeUsernameTradesGet$Params } from '../fn/pollenexchange/pollenexchange-username-trades-get';
import { pollenexchangeUsernameTradeStatusGet } from '../fn/pollenexchange/pollenexchange-username-trade-status-get';
import { PollenexchangeUsernameTradeStatusGet$Params } from '../fn/pollenexchange/pollenexchange-username-trade-status-get';
import { PollenOfferDateContainerDto } from '../models/pollen-offer-date-container-dto';
import { PollenOfferDto } from '../models/pollen-offer-dto';
import { PollenOfferSpeciesStatisticsDto } from '../models/pollen-offer-species-statistics-dto';
import { TradeDateContainerDto } from '../models/trade-date-container-dto';
import { TradeDto } from '../models/trade-dto';
import { TradeRatingsDto } from '../models/trade-ratings-dto';
import {BaseService} from "../../../core/openApiGeneratedFiles/base-service";
import {StrictHttpResponse} from "../../../core/openApiGeneratedFiles/strict-http-response";
import {ApiConfiguration} from "../../../core/openApiGeneratedFiles/api-configuration";


/**
 * Operations to manage and retrive Users
 */
@Injectable({ providedIn: 'root' })
export class PollenexchangeService extends BaseService {
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

  /** Path part for operation `pollenexchangeTradesDatesGet()` */
  static readonly PollenexchangeTradesDatesGetPath = '/pollenexchange/trades/dates';

  /**
   * return stored dates (Month-Year).
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `pollenexchangeTradesDatesGet()` instead.
   *
   * This method doesn't expect any request body.
   */
  pollenexchangeTradesDatesGet$Response(params?: PollenexchangeTradesDatesGet$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<string>>> {
    return pollenexchangeTradesDatesGet(this.http, this.rootUrl, params, context);
  }

  /**
   * return stored dates (Month-Year).
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `pollenexchangeTradesDatesGet$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  pollenexchangeTradesDatesGet(params?: PollenexchangeTradesDatesGet$Params, context?: HttpContext): Observable<Array<string>> {
    return this.pollenexchangeTradesDatesGet$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<string>>): Array<string> => r.body)
    );
  }

  /** Path part for operation `pollenexchangeUsernameTradesGet()` */
  static readonly PollenexchangeUsernameTradesGetPath = '/pollenexchange/{username}/trades';

  /**
   * return all Trades and their status of the currently logged in user.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `pollenexchangeUsernameTradesGet()` instead.
   *
   * This method doesn't expect any request body.
   */
  pollenexchangeUsernameTradesGet$Response(params: PollenexchangeUsernameTradesGet$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<TradeDateContainerDto>>> {
    return pollenexchangeUsernameTradesGet(this.http, this.rootUrl, params, context);
  }

  /**
   * return all Trades and their status of the currently logged in user.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `pollenexchangeUsernameTradesGet$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  pollenexchangeUsernameTradesGet(params: PollenexchangeUsernameTradesGet$Params, context?: HttpContext): Observable<Array<TradeDateContainerDto>> {
    return this.pollenexchangeUsernameTradesGet$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<TradeDateContainerDto>>): Array<TradeDateContainerDto> => r.body)
    );
  }

  /** Path part for operation `pollenexchangeCreateTradePost()` */
  static readonly PollenexchangeCreateTradePostPath = '/pollenexchange/create/trade';

  /**
   * create a Trade.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `pollenexchangeCreateTradePost()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  pollenexchangeCreateTradePost$Response(params: PollenexchangeCreateTradePost$Params, context?: HttpContext): Observable<StrictHttpResponse<TradeDto>> {
    return pollenexchangeCreateTradePost(this.http, this.rootUrl, params, context);
  }

  /**
   * create a Trade.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `pollenexchangeCreateTradePost$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  pollenexchangeCreateTradePost(params: PollenexchangeCreateTradePost$Params, context?: HttpContext): Observable<TradeDto> {
    return this.pollenexchangeCreateTradePost$Response(params, context).pipe(
      map((r: StrictHttpResponse<TradeDto>): TradeDto => r.body)
    );
  }

  /** Path part for operation `pollenexchangeTradeTradeIdGet()` */
  static readonly PollenexchangeTradeTradeIdGetPath = '/pollenexchange/trade/{tradeId}';

  /**
   * get a specific Trade.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `pollenexchangeTradeTradeIdGet()` instead.
   *
   * This method doesn't expect any request body.
   */
  pollenexchangeTradeTradeIdGet$Response(params: PollenexchangeTradeTradeIdGet$Params, context?: HttpContext): Observable<StrictHttpResponse<TradeDto>> {
    return pollenexchangeTradeTradeIdGet(this.http, this.rootUrl, params, context);
  }

  /**
   * get a specific Trade.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `pollenexchangeTradeTradeIdGet$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  pollenexchangeTradeTradeIdGet(params: PollenexchangeTradeTradeIdGet$Params, context?: HttpContext): Observable<TradeDto> {
    return this.pollenexchangeTradeTradeIdGet$Response(params, context).pipe(
      map((r: StrictHttpResponse<TradeDto>): TradeDto => r.body)
    );
  }

  /** Path part for operation `pollenexchangeTradeTradeIdPut()` */
  static readonly PollenexchangeTradeTradeIdPutPath = '/pollenexchange/trade/{tradeId}';

  /**
   * accept or refuse a trade.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `pollenexchangeTradeTradeIdPut()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  pollenexchangeTradeTradeIdPut$Response(params: PollenexchangeTradeTradeIdPut$Params, context?: HttpContext): Observable<StrictHttpResponse<TradeDto>> {
    return pollenexchangeTradeTradeIdPut(this.http, this.rootUrl, params, context);
  }

  /**
   * accept or refuse a trade.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `pollenexchangeTradeTradeIdPut$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  pollenexchangeTradeTradeIdPut(params: PollenexchangeTradeTradeIdPut$Params, context?: HttpContext): Observable<TradeDto> {
    return this.pollenexchangeTradeTradeIdPut$Response(params, context).pipe(
      map((r: StrictHttpResponse<TradeDto>): TradeDto => r.body)
    );
  }

  /** Path part for operation `pollenexchangeUsernameTradeStatusGet()` */
  static readonly PollenexchangeUsernameTradeStatusGetPath = '/pollenexchange/{username}/trade/status';

  /**
   * return the status of all Trades from an User.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `pollenexchangeUsernameTradeStatusGet()` instead.
   *
   * This method doesn't expect any request body.
   */
  pollenexchangeUsernameTradeStatusGet$Response(params: PollenexchangeUsernameTradeStatusGet$Params, context?: HttpContext): Observable<StrictHttpResponse<TradeRatingsDto>> {
    return pollenexchangeUsernameTradeStatusGet(this.http, this.rootUrl, params, context);
  }

  /**
   * return the status of all Trades from an User.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `pollenexchangeUsernameTradeStatusGet$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  pollenexchangeUsernameTradeStatusGet(params: PollenexchangeUsernameTradeStatusGet$Params, context?: HttpContext): Observable<TradeRatingsDto> {
    return this.pollenexchangeUsernameTradeStatusGet$Response(params, context).pipe(
      map((r: StrictHttpResponse<TradeRatingsDto>): TradeRatingsDto => r.body)
    );
  }

}
