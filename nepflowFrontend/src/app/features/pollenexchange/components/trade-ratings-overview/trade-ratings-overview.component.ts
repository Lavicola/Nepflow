import {Component, OnInit} from '@angular/core';
import {TradesService} from "../../services/trades.service";
import {TradeDto} from "../../models/trade-dto";
import {BehaviorSubject, Observable, Subject} from "rxjs";
import {AsyncPipe, KeyValuePipe, NgForOf, NgIf} from "@angular/common";
import {NepenthesCardTextComponent} from "../nepenthes-card-text/nepenthes-card-text.component";
import {MatButton} from "@angular/material/button";
import {RateTradeComponent} from "../rate-trade/rate-trade.component";
import {UsernameService} from "../../../../core/services/UsernameService";
import {map} from "rxjs/operators";

@Component({
  selector: 'app-trade-ratings-overview',
  standalone: true,
  imports: [
    AsyncPipe,
    NepenthesCardTextComponent,
    NgIf,
    NgForOf,
    MatButton,
    RateTradeComponent,
    KeyValuePipe,
  ],
  templateUrl: './trade-ratings-overview.component.html',
  styleUrl: './trade-ratings-overview.component.sass'
})
export class TradeRatingsOverviewComponent implements OnInit {

  private tradesMapSubject: BehaviorSubject<Map<string, TradeDto>> = new BehaviorSubject<Map<string, TradeDto>>(new Map<string, TradeDto>());
  tradesMap$ = this.tradesMapSubject.asObservable();
  trades$: Observable<TradeDto[]> = this.tradesMap$.pipe(
    map(tradesMap => Array.from(tradesMap.values())) // Convert the Map to an array of TradeDto
  );
  username: string = ""
  // the trades which were rated until user switched page
  ratedTradesId: Map<string, boolean> = new Map();


  constructor(private tradesService: TradesService,
              private userService: UsernameService) {
  }

  ngOnInit(): void {
    this.tradesService.pollenexchangeTradesRateableGet().subscribe({
      next: (trades: TradeDto[]) => {
        let tradeMap = new Map<string, TradeDto>()
        trades.forEach(trade => {
          if (trade.id != null) {
            tradeMap.set(trade.id, trade);
          }
        });
        console.log(tradeMap)
        this.tradesMapSubject.next(tradeMap)
      },
      error: () => console.log("error, rating trade")

    })

    this.userService.getUsernameObs().subscribe({
      next: (username) => this.username = username
    })


  }


  handleRatingEvent(event: { success: boolean; tradeId: string }) {
    if (event.success) {
      const currentMap = this.tradesMapSubject.value
      currentMap.delete(event.tradeId)
      this.tradesMapSubject.next(currentMap);
    }
  }

}
