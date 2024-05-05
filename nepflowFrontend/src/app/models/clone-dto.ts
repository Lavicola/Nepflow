/* tslint:disable */
/* eslint-disable */
import { MountainDto } from '../models/mountain-dto';
import { NepenthesDto } from '../models/nepenthes-dto';
export interface CloneDto {
  id?: string;
  mountain?: MountainDto;
  nepenthes?: NepenthesDto;
  sex?: string;
}
