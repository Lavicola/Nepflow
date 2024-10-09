import {Component, Input} from '@angular/core';
import {FemaleDirective} from "../../directives/SVGIconFemaleAttributesDirective";
import {MaleDirective} from "../../directives/SVGIconMaleAttributesDirective";
import {MatCard, MatCardContent, MatCardHeader, MatCardLgImage} from "@angular/material/card";
import {MatGridList, MatGridTile} from "@angular/material/grid-list";
import {NgIf} from "@angular/common";
import {PollenOfferDto} from "../../models/pollen-offer-dto";
import {NepenthesBasecardComponent} from "../nepenthes-basecard/nepenthes-basecard.component";

@Component({
  selector: 'app-nepenthes-card-simple',
  standalone: true,
  imports: [
    FemaleDirective,
    MaleDirective,
    MatCard,
    MatCardContent,
    MatCardHeader,
    MatCardLgImage,
    MatGridList,
    MatGridTile,
    NgIf,
    NepenthesBasecardComponent
  ],
  templateUrl: './nepenthes-card-simple.component.html',
  styleUrl: './nepenthes-card-simple.component.sass'
})
export class NepenthesCardSimpleComponent {

  @Input() offer: PollenOfferDto = {};
  @Input() hasBorder: boolean = true;


}
