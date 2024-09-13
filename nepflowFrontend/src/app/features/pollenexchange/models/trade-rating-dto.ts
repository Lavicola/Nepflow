/* tslint:disable */
/* eslint-disable */
import { TradeStatus } from '../models/trade-status';
export interface TradeRatingDto {

  /**
   * MM-YYYY
   */
  date?: string;
  status?: TradeStatus;
  tradeId?: string;
}
