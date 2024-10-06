/* tslint:disable */
/* eslint-disable */
import {ReviewType} from '../models/review-type';

export interface RatingDto {
  comment?: string;
  file?: Blob;
  rater?: string;
  receivedOn?: string;
  reviewType?: ReviewType;
  tradeId?: string;
}
