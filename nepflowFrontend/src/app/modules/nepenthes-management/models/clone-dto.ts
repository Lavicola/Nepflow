/* tslint:disable */
/* eslint-disable */
import { LocationDto } from '../models/location-dto';
import { ProducerDto } from '../models/producer-dto';
export interface CloneDto {
  Location?: LocationDto;
  cloneId?: string;
  description?: string;
  internalCloneId?: string;
  nickname?: string;
  producer?: ProducerDto;
  sex?: string;
}
