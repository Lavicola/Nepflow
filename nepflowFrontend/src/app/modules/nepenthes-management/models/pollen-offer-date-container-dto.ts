/* tslint:disable */
/* eslint-disable */
import { PollenOfferDto } from '../models/pollen-offer-dto';
export interface PollenOfferDateContainerDto {

  /**
   * MM-YYYY
   */
  date?: string;
  pollenOffers?: Array<PollenOfferDto>;
}
