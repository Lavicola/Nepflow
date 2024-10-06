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
  pollenexchangeCreateTradePost,
  PollenexchangeCreateTradePost$Params
} from '../fn/trades/pollenexchange-create-trade-post';
import {
  pollenexchangeTradesDatesGet,
  PollenexchangeTradesDatesGet$Params
} from '../fn/trades/pollenexchange-trades-dates-get';
import {pollenexchangeTradesGet, PollenexchangeTradesGet$Params} from '../fn/trades/pollenexchange-trades-get';
import {
  pollenexchangeTradesRateableGet,
  PollenexchangeTradesRateableGet$Params
} from '../fn/trades/pollenexchange-trades-rateable-get';
import {
  pollenexchangeTradeTradeIdGet,
  PollenexchangeTradeTradeIdGet$Params
} from '../fn/trades/pollenexchange-trade-trade-id-get';
import {
  pollenexchangeTradeTradeIdPut,
  PollenexchangeTradeTradeIdPut$Params
} from '../fn/trades/pollenexchange-trade-trade-id-put';
import {
  pollenexchangeUsernameTradesStatusGet,
  PollenexchangeUsernameTradesStatusGet$Params
} from '../fn/trades/pollenexchange-username-trades-status-get';
import {RatingDto} from '../models/rating-dto';
import {RatingPage} from '../models/rating-page';
import {TradeDateContainerDto} from '../models/trade-date-container-dto';
import {TradeDto} from '../models/trade-dto';
import {TradeStatusDto} from '../models/trade-status-dto';
import {tradesTradeIdRatingPost, TradesTradeIdRatingPost$Params} from '../fn/trades/trades-trade-id-rating-post';
import {tradesUsernameRatingsGet, TradesUsernameRatingsGet$Params} from '../fn/trades/trades-username-ratings-get';


/**
 * Operations to manage and retrive Trades and their related Entities
 */
@Injectable({ providedIn: 'root' })
export class TradesService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `pollenexchangeTradesDatesGet()` */
  static readonly PollenexchangeTradesDatesGetPath = '/pollenexchange/trades/dates';

  /**
   * return stored dates (Month-Year) the current logged in user has trades.
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
   * return stored dates (Month-Year) the current logged in user has trades.
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

  /** Path part for operation `pollenexchangeTradesGet()` */
  static readonly PollenexchangeTradesGetPath = '/pollenexchange/trades';

  /**
   * return all Trades and their status of the currently logged in user.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `pollenexchangeTradesGet()` instead.
   *
   * This method doesn't expect any request body.
   */
  pollenexchangeTradesGet$Response(params?: PollenexchangeTradesGet$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<TradeDateContainerDto>>> {
    return pollenexchangeTradesGet(this.http, this.rootUrl, params, context);
  }

  /**
   * return all Trades and their status of the currently logged in user.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `pollenexchangeTradesGet$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  pollenexchangeTradesGet(params?: PollenexchangeTradesGet$Params, context?: HttpContext): Observable<Array<TradeDateContainerDto>> {
    return this.pollenexchangeTradesGet$Response(params, context).pipe(
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

  /** Path part for operation `pollenexchangeTradesRateableGet()` */
  static readonly PollenexchangeTradesRateableGetPath = '/pollenexchange/trades/rateable';

  /**
   * return all rateable trades of the currently logged in user.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `pollenexchangeTradesRateableGet()` instead.
   *
   * This method doesn't expect any request body.
   */
  pollenexchangeTradesRateableGet$Response(params?: PollenexchangeTradesRateableGet$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<TradeDto>>> {
    return pollenexchangeTradesRateableGet(this.http, this.rootUrl, params, context);
  }

  /**
   * return all rateable trades of the currently logged in user.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `pollenexchangeTradesRateableGet$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  pollenexchangeTradesRateableGet(params?: PollenexchangeTradesRateableGet$Params, context?: HttpContext): Observable<Array<TradeDto>> {
    return this.pollenexchangeTradesRateableGet$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<TradeDto>>): Array<TradeDto> => r.body)
    );
  }

  /** Path part for operation `tradesTradeIdRatingPost()` */
  static readonly TradesTradeIdRatingPostPath = '/trades/{tradeId}/rating';

  /**
   * leave feedback/rate a specific Trade.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `tradesTradeIdRatingPost()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  tradesTradeIdRatingPost$Response(params: TradesTradeIdRatingPost$Params, context?: HttpContext): Observable<StrictHttpResponse<RatingDto>> {
    return tradesTradeIdRatingPost(this.http, this.rootUrl, params, context);
  }

  /**
   * leave feedback/rate a specific Trade.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `tradesTradeIdRatingPost$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  tradesTradeIdRatingPost(params: TradesTradeIdRatingPost$Params, context?: HttpContext): Observable<RatingDto> {
    return this.tradesTradeIdRatingPost$Response(params, context).pipe(
      map((r: StrictHttpResponse<RatingDto>): RatingDto => r.body)
    );
  }

  /** Path part for operation `tradesUsernameRatingsGet()` */
  static readonly TradesUsernameRatingsGetPath = '/trades/{username}/ratings';

  /**
   * get received ratings of a specific User.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `tradesUsernameRatingsGet()` instead.
   *
   * This method doesn't expect any request body.
   */
  tradesUsernameRatingsGet$Response(params: TradesUsernameRatingsGet$Params, context?: HttpContext): Observable<StrictHttpResponse<RatingPage>> {
    return tradesUsernameRatingsGet(this.http, this.rootUrl, params, context);
  }

  /**
   * get received ratings of a specific User.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `tradesUsernameRatingsGet$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  tradesUsernameRatingsGet(params: TradesUsernameRatingsGet$Params, context?: HttpContext): Observable<RatingPage> {
    return this.tradesUsernameRatingsGet$Response(params, context).pipe(
      map((r: StrictHttpResponse<RatingPage>): RatingPage => r.body)
    );
  }

  /** Path part for operation `pollenexchangeUsernameTradesStatusGet()` */
  static readonly PollenexchangeUsernameTradesStatusGetPath = '/pollenexchange/{username}/trades/status';

  /**
   * return the status of all Trades from the Viewpoint of the User.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `pollenexchangeUsernameTradesStatusGet()` instead.
   *
   * This method doesn't expect any request body.
   */
  pollenexchangeUsernameTradesStatusGet$Response(params: PollenexchangeUsernameTradesStatusGet$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<TradeStatusDto>>> {
    return pollenexchangeUsernameTradesStatusGet(this.http, this.rootUrl, params, context);
  }

  /**
   * return the status of all Trades from the Viewpoint of the User.
   *
   *
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `pollenexchangeUsernameTradesStatusGet$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  pollenexchangeUsernameTradesStatusGet(params: PollenexchangeUsernameTradesStatusGet$Params, context?: HttpContext): Observable<Array<TradeStatusDto>> {
    return this.pollenexchangeUsernameTradesStatusGet$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<TradeStatusDto>>): Array<TradeStatusDto> => r.body)
    );
  }

}
