/* tslint:disable */
/* eslint-disable */
import { Clone } from '../models/clone';
import { SpeciesCloneDto } from '../models/species-clone-dto';
export interface CloneGrexDto {
  cloneId?: string;
  father?: (Clone | SpeciesCloneDto);
  mother?: (Clone | SpeciesCloneDto);
}
