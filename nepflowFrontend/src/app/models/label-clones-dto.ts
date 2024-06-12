/* tslint:disable */
/* eslint-disable */
import { CloneDto } from '../models/clone-dto';
import { HybridCloneDto } from '../models/hybrid-clone-dto';
import { LabelDto } from '../models/label-dto';
export interface LabelClonesDto {
  clones?: Array<(CloneDto | HybridCloneDto)>;
  label?: LabelDto;
}
