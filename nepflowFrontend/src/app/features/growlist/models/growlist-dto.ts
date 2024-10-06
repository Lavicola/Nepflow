/* tslint:disable */
/* eslint-disable */
import {SpecimenCloneDto} from '../models/specimen-clone-dto';

export interface GrowlistDto {
  id?: string;
  isPublic?: boolean;
  specimens?: Array<SpecimenCloneDto>;
  username?: string;
}
