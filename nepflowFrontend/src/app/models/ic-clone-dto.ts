/* tslint:disable */
/* eslint-disable */
import { CloneGrexDto } from '../models/clone-grex-dto';
import { LocationDto } from '../models/location-dto';
import {NepenthesDto} from "./nepenthes-dto";
export interface IcCloneDto {
  Location?: LocationDto;
  cloneId?: string;
  grex?: CloneGrexDto;
  name?: string;
  nepenthes?: NepenthesDto;
  sex?: string;
}
