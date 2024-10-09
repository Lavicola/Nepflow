import {Component, ElementRef, Input, OnInit, Renderer2} from '@angular/core';
import {AsyncPipe, NgForOf, NgIf} from "@angular/common";
import {MatButton} from "@angular/material/button";
import {
  MatCard, MatCardAppearance,
  MatCardContent,
  MatCardHeader,
  MatCardLgImage,
  MatCardSubtitle,
  MatCardTitle
} from "@angular/material/card";
import {MatFormField, MatFormFieldAppearance, MatLabel} from "@angular/material/form-field";
import {MatOption} from "@angular/material/autocomplete";
import {MatSelect} from "@angular/material/select";
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
export class NepenthesBasecardComponent implements OnInit {


  @Input() public hasBorder: boolean = true


  constructor(private renderer: Renderer2, private el: ElementRef) {
  }

  // ngClass is not working, therefore workaround
  ngOnInit(): void {
    const matCard = this.el.nativeElement.querySelector('mat-card');


    if (this.hasBorder) {
      this.renderer.removeClass(matCard, 'mat-elevation-z0');
    } else {
      this.renderer.addClass(matCard, 'mat-elevation-z0');
    }


  }
}
