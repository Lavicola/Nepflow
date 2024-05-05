/* tslint:disable */
/* eslint-disable */
import { CloneDto } from '../models/clone-dto';
import { ProducerDto } from '../models/producer-dto';
export type IvCloneDto = CloneDto & {
'producer': ProducerDto;
};
