/* tslint:disable */
/* eslint-disable */
import { CloneGrexDto } from './clone-grex-dto';
import { LocationDto } from './location-dto';
import { ProducerDto } from './producer-dto';
export interface CloneDto {
  Location?: LocationDto;
  cloneId?: string;
  grex?: CloneGrexDto;
  internalcloneId?: string;
  producer?: ProducerDto;
  sex?: string;
}
