/* tslint:disable */
/* eslint-disable */
import {SpecimenCloneDto} from '../models/specimen-clone-dto';

export interface SpecimensBulkRequestDto {
  failure?: Array<string>;
  success?: Array<SpecimenCloneDto>;
}
