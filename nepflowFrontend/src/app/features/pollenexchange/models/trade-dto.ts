/* tslint:disable */
/* eslint-disable */
import {PollenOfferDto} from '../models/pollen-offer-dto';

export interface TradeDto {
  InitiatedOffer?: PollenOfferDto;
  RequestedOffer?: PollenOfferDto;
  id?: string;
  status?: string;
  tradeOpenedDate?: string;
}
