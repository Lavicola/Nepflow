/* tslint:disable */
/* eslint-disable */
import {TradeDto} from '../models/trade-dto';

export interface TradeDateContainerDto {

  /**
   * MM-YYYY
   */
  date?: string;
  trades?: Array<TradeDto>;
}
