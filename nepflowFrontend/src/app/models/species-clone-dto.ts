/* tslint:disable */
/* eslint-disable */
import { Clone } from '../models/clone';
import { CloneGrexDto } from '../models/clone-grex-dto';
import { LocationDto } from '../models/location-dto';
import { NepenthesDto } from '../models/nepenthes-dto';
export type SpeciesCloneDto = Clone & {
'nepenthes': NepenthesDto;
'Location'?: LocationDto;
'grex'?: CloneGrexDto;
};
