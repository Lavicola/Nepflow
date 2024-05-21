/* tslint:disable */
/* eslint-disable */
import { NepenthesDto } from '../models/nepenthes-dto';
import { SpeciesCloneDto } from '../models/species-clone-dto';
export interface NepenthesClonesDto {
  clones?: Array<SpeciesCloneDto>;
  nepenthes?: NepenthesDto;
}
