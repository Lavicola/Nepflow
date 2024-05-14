/* tslint:disable */
/* eslint-disable */
import { IcCloneDto } from '../models/ic-clone-dto';
import { IvCloneDto } from '../models/iv-clone-dto';
export interface CloneGrexDto {
  cloneId?: string;
  father?: (IcCloneDto | IvCloneDto);
  mother?: (IcCloneDto | IvCloneDto);
}
