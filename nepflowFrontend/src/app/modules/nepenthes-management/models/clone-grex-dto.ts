/* tslint:disable */
/* eslint-disable */
import { CloneDto } from './clone-dto';
import { HybridCloneDto } from './hybrid-clone-dto';
export interface CloneGrexDto {
  cloneId?: string;
  father?: (CloneDto | HybridCloneDto);
  mother?: (CloneDto | HybridCloneDto);
}
