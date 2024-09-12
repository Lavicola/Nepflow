import {Component, OnInit} from '@angular/core';
import {PollenexchangeService} from "../../services/pollenexchange.service";
import {BehaviorSubject, catchError, combineLatest, map, Observable, of} from "rxjs";
import {AuthService} from "../../../../core/services/auth.service";
import {UserDto} from "../../../../core/models/user-dto";
import {TradeDto} from "../../models/trade-dto";
import {AsyncPipe, NgForOf, NgIf} from "@angular/common";
import {NepenthesBasecardComponent} from "../nepenthes-basecard/nepenthes-basecard.component";
import {UserTradesClosedComponent} from "../user-trades-closed/user-trades-closed.component";
import {UserTradesOpenComponent} from "../user-trades-open/user-trades-open.component";
import {MatButton} from "@angular/material/button";
import {MatLabel} from "@angular/material/form-field";
import {MatButtonToggle, MatButtonToggleGroup} from "@angular/material/button-toggle";
import {ActivatedRoute} from "@angular/router";
import {TradeService} from "../../services/trade.service";

@Component({
  selector: 'app-user-trades-overviw',
  standalone: true,
  imports: [AsyncPipe, NgIf, NgForOf, NepenthesBasecardComponent, UserTradesClosedComponent, UserTradesOpenComponent, MatButton, MatLabel, MatButtonToggle, MatButtonToggleGroup],
  templateUrl: './user-trades-overviw.component.html',
  styleUrl: './user-trades-overviw.component.sass'
})
export class UserTradesOverviwComponent implements OnInit {

  private selectedDateSubject: BehaviorSubject<string> = new BehaviorSubject('');
  dates$: Observable<string[]> = this.tradeService.subscribeToDateSubject()
  selectedTrades$: Observable<TradeDto[]> = combineLatest([
    this.tradeService.subscribeTotradeDateCacheSubject(),
    this.selectedDateSubject.asObservable()
  ]).pipe(
    map(([container, selectedDate]) => {
      const trades = container.get(selectedDate) || [];
      return trades;
    }),
    catchError(err => {
      console.log('Error in selectedTrades$:', err);
      return of([]);
    })
  );

  public status: string = ""

  constructor(private userService: AuthService,
              private tradeService: TradeService,
              private route: ActivatedRoute) {
  };


  ngOnInit(): void {
    this.userService.getUser().subscribe({
      next: (user: UserDto) => {
        this.tradeService.setUser(user)
        this.tradeService.init()
        console.log('User fetched:', user);
      },
      error: (error) => {
        console.error('Error occurred while fetching the user:', error);
      },
      complete: () => {
        console.log('User fetching completed.');
      }
    });


    this.route.paramMap.subscribe(params => {
      const tradeParam = params.get('status');
      if (tradeParam) {
        this.status = tradeParam
      }
    });


  }


  updateByDate(date: string) {
    this.tradeService.updateByDate(date)
    this.selectedDateSubject.next(date)

  }
}
