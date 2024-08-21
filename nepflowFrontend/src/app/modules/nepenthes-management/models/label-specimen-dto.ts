/* tslint:disable */
/* eslint-disable */
import {LabelDto} from '../models/label-dto';
import {SpecimenCloneDto} from '../models/specimen-clone-dto';

export interface LabelSpecimenDto {
  clone?: SpecimenCloneDto;
  label?: LabelDto;
}
