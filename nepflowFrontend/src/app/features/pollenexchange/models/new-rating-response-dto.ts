/* tslint:disable */
/* eslint-disable */
import {ReviewType} from '../models/review-type';

export interface NewRatingResponseDto {
  comment?: string;
  imageLocation?: string;
  reviewType?: ReviewType;
}
