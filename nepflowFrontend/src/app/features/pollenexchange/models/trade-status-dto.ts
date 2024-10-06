/* tslint:disable */
/* eslint-disable */
import {ReviewType} from '../models/review-type';

/**
 * the Status of a Trade from a viewpoint of a specific User
 */
export interface TradeStatusDto {

  /**
   * the date the trade was accepted
   */
  creationDate?: string;
  status?: ReviewType;
  tradeId?: string;
}
