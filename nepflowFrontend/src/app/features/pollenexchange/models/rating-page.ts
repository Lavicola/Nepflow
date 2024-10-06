/* tslint:disable */
/* eslint-disable */
import {RatingDto} from '../models/rating-dto';

export interface RatingPage {
  pageNumber?: number;
  pageSize?: number;
  ratings?: Array<RatingDto>;
  totalPages?: number;
}
