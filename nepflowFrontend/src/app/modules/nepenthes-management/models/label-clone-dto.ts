/* tslint:disable */
/* eslint-disable */
import { CloneDto } from './clone-dto';
import { HybridCloneDto } from './hybrid-clone-dto';
import { LabelDto } from './label-dto';
export interface LabelCloneDto {
  clone?: (CloneDto | HybridCloneDto);
  label?: LabelDto;
}
