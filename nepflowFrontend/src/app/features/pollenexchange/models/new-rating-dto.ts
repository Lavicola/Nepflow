/* tslint:disable */
/* eslint-disable */
import {ReviewType} from '../models/review-type';

export interface NewRatingDto {
  comment?: string;
  file?: Blob;
  reviewType?: ReviewType;
}
