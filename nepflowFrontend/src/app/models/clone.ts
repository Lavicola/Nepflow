/* tslint:disable */
/* eslint-disable */
import { CloneGrexDto } from '../models/clone-grex-dto';
import { ProducerDto } from '../models/producer-dto';
export interface Clone {
  cloneId?: string;
  grex?: CloneGrexDto;
  name: string;
  producer?: ProducerDto;
  sex: string;
}
