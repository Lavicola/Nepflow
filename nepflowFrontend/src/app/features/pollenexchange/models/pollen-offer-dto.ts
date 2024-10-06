/* tslint:disable */
/* eslint-disable */
import {UserDto} from '../models/user-dto';

export interface PollenOfferDto {
  cloneId?: string;
  id?: string;
  imageLocation?: string;
  location?: string;
  nepenthesName?: string;
  pollenOfferOpenedDate?: string;
  seller?: string;
  sex?: string;
  user?: UserDto;
}
