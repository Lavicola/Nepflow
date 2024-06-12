/* tslint:disable */
/* eslint-disable */
import { CloneGrexDto } from '../models/clone-grex-dto';
import { LocationDto } from '../models/location-dto';
import { ProducerDto } from '../models/producer-dto';
export interface CloneDto {
  Location?: LocationDto;
  cloneId?: string;
  grex?: CloneGrexDto;
  internalcloneId?: string;
  producer?: ProducerDto;
  sex?: string;
}
