/* tslint:disable */
/* eslint-disable */
import { CloneDto } from '../models/clone-dto';
import { HybridCloneDto } from '../models/hybrid-clone-dto';
export interface CloneGrexDto {
  cloneId?: string;
  father?: (CloneDto | HybridCloneDto);
  mother?: (CloneDto | HybridCloneDto);
}
