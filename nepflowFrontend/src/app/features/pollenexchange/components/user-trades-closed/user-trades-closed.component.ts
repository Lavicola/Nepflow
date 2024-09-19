import {Component, Input} from '@angular/core';
import {TradeDto} from "../../models/trade-dto";
import {map, Observable} from "rxjs";
import {AsyncPipe, NgForOf, NgIf} from "@angular/common";
import {MatGridList, MatGridTile} from "@angular/material/grid-list";
import {NepenthesBasecardComponent} from "../nepenthes-basecard/nepenthes-basecard.component";
import {MatButton} from "@angular/material/button";
import {getNameOfCross} from "../../services/male-female-name-combiner";
import {PollenOfferDto} from "../../models/pollen-offer-dto";
import {NepenthesCardSimpleComponent} from "../nepenthes-card-simple/nepenthes-card-simple.component";
import {NepenthesCardTextComponent} from "../nepenthes-card-text/nepenthes-card-text.component";

@Component({
  selector: 'app-user-trades-closed',
  standalone: true,
  imports: [AsyncPipe, NgForOf, MatGridList, MatGridTile, NepenthesBasecardComponent, NgIf, MatButton, NepenthesCardSimpleComponent, NepenthesCardTextComponent],
  templateUrl: './user-trades-closed.component.html',
  styleUrl: './user-trades-closed.component.sass'
})
export class UserTradesClosedComponent {

  @Input() allTrades:Observable<TradeDto[]> = new Observable<TradeDto[]>();
  acceptedTrades$:Observable<TradeDto[]> = new Observable<TradeDto[]>();
  declinedTrades$:Observable<TradeDto[]> = new Observable<TradeDto[]>();


  ngOnInit() {
    this.acceptedTrades$ = this.allTrades.pipe(
      map(trades => trades.filter(trade => trade.status === 'ACCEPTED'))
    );

    this.declinedTrades$ = this.allTrades.pipe(
      map(trades => trades.filter(trade => trade.status === 'REFUSED'))
    );
  }

  protected readonly getNameOfCross = getNameOfCross;
}
