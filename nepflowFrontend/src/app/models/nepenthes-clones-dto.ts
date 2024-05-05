/* tslint:disable */
/* eslint-disable */
import { CloneDto } from '../models/clone-dto';
import { IvCloneDto } from '../models/iv-clone-dto';
import { NepenthesDto } from '../models/nepenthes-dto';
export interface NepenthesClonesDto {
  clones?: Array<(CloneDto | IvCloneDto)>;
  nepenthes?: NepenthesDto;
}
