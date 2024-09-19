import {Component, Input} from '@angular/core';
import {AsyncPipe, NgForOf, NgIf} from "@angular/common";
import {MatButton} from "@angular/material/button";
import {
    MatCard,
    MatCardContent,
    MatCardHeader,
    MatCardLgImage,
    MatCardSubtitle,
    MatCardTitle
} from "@angular/material/card";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatOption} from "@angular/material/autocomplete";
import {MatSelect} from "@angular/material/select";
import {PollenOfferDto} from "../../models/pollen-offer-dto";
import {FlexLayoutModule} from "@angular/flex-layout";
import {MatTooltip} from "@angular/material/tooltip";
import {MatGridList, MatGridTile} from "@angular/material/grid-list";
import {FemaleDirective} from "../../directives/SVGIconFemaleAttributesDirective";
import {MaleDirective} from "../../directives/SVGIconMaleAttributesDirective";

@Component({
  selector: 'app-nepenthes-basecard',
  standalone: true,
  imports: [
    FlexLayoutModule,
    AsyncPipe,
    MatButton,
    MatCard,
    MatCardContent,
    MatCardHeader,
    MatCardLgImage,
    MatCardSubtitle,
    MatCardTitle,
    MatFormField,
    MatLabel,
    MatOption,
    MatSelect,
    NgForOf,
    NgIf,
    MatTooltip,
    MatGridTile,
    MatGridList,
    MaleDirective,
    MaleDirective,
    FemaleDirective
  ],
  templateUrl: './nepenthes-basecard.component.html',
  styleUrl: './nepenthes-basecard.component.sass'
})
export class NepenthesBasecardComponent {

}
