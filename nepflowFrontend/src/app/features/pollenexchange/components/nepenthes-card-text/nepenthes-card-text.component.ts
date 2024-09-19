import {Component, Input} from '@angular/core';
import {NepenthesBasecardComponent} from "../nepenthes-basecard/nepenthes-basecard.component";
import {MatCardSubtitle, MatCardTitle} from "@angular/material/card";
import {PollenOfferDto} from "../../models/pollen-offer-dto";

@Component({
  selector: 'app-nepenthes-card-text',
  standalone: true,
  imports: [
    NepenthesBasecardComponent,
    MatCardTitle,
    MatCardSubtitle
  ],
  templateUrl: './nepenthes-card-text.component.html',
  styleUrl: './nepenthes-card-text.component.sass'
})
export class NepenthesCardTextComponent {
  @Input() offer: PollenOfferDto = {};

}
