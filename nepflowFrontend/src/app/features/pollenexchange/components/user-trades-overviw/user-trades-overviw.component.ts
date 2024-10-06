import {Component, OnInit} from '@angular/core';
import {BehaviorSubject, Subject} from "rxjs";
import {TradeDto} from "../../models/trade-dto";
import {AsyncPipe, NgForOf, NgIf} from "@angular/common";
import {NepenthesBasecardComponent} from "../nepenthes-basecard/nepenthes-basecard.component";
import {UserTradesClosedComponent} from "../user-trades-closed/user-trades-closed.component";
import {UserTradesOpenComponent} from "../user-trades-open/user-trades-open.component";
import {MatButton} from "@angular/material/button";
import {MatLabel} from "@angular/material/form-field";
import {MatButtonToggle, MatButtonToggleGroup} from "@angular/material/button-toggle";
import {ActivatedRoute} from "@angular/router";
import {TradeRatingsOverviewComponent} from "../trade-ratings-overview/trade-ratings-overview.component";
import {TradesService} from "../../services/trades.service";

@Component({
  selector: 'app-user-trades-overviw',
  standalone: true,
  imports: [AsyncPipe, NgIf, NgForOf, NepenthesBasecardComponent, UserTradesClosedComponent, UserTradesOpenComponent, MatButton, MatLabel, MatButtonToggle, MatButtonToggleGroup, TradeRatingsOverviewComponent],
  templateUrl: './user-trades-overviw.component.html',
  styleUrl: './user-trades-overviw.component.sass'
})
export class UserTradesOverviwComponent implements OnInit {

  tradeDateCacheSubject: BehaviorSubject<Map<string, TradeDto[]>> =
    new BehaviorSubject<Map<string, TradeDto[]>>(new Map());


  private datesSubject: Subject<string[]> = new Subject<string[]>();
  public dates$ = this.datesSubject.asObservable();
  private tradesSubject: Subject<TradeDto[]> = new Subject<TradeDto[]>();
  public trades$ = this.tradesSubject.asObservable();

  public currentDate = new Subject<string>();


  public status: string = ""

  constructor(private tradeService: TradesService,
              private route: ActivatedRoute) {
  };


  ngOnInit(): void {

    this.route.paramMap.subscribe(params => {
      const tradeParam = params.get('status');
      if (tradeParam) {
        this.status = tradeParam
      }
    });

    this.tradeService.pollenexchangeTradesDatesGet().subscribe({
      next: (dates) => this.datesSubject.next(dates),
      error: (err) => console.log(err)
    })


  }

  updateByDate(date: string) {

    this.tradeService.pollenexchangeTradesGet({dates: [date]}).subscribe({
      next: (tradeContainer) => {
        if (tradeContainer.length == 1 && tradeContainer[0].trades) {
          this.tradesSubject.next(tradeContainer[0].trades)
        }
      }
    })


  }


}
