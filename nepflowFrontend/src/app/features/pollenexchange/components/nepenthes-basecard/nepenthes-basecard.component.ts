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

@Component({
  selector: 'app-nepenthes-basecard',
  standalone: true,
    imports: [
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
        NgIf
    ],
  templateUrl: './nepenthes-basecard.component.html',
  styleUrl: './nepenthes-basecard.component.sass'
})
export class NepenthesBasecardComponent {
  @Input() offer: PollenOfferDto = {};



}
