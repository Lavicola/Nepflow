import {Component, OnInit} from '@angular/core';
import {PollenexchangeService} from "../../services/pollenexchange.service";
import {TradeDateContainerDto} from "../../models/trade-date-container-dto";
import {BehaviorSubject, catchError, combineLatest, concatMap, map, Observable, of, tap} from "rxjs";
import {PollenOfferDto} from "../../models/pollen-offer-dto";
import {AuthService} from "../../../../core/services/auth.service";
import {UserDto} from "../../../../core/models/user-dto";
import {TradeDto} from "../../models/trade-dto";
import {AsyncPipe, NgForOf, NgIf} from "@angular/common";
import {NepenthesBasecardComponent} from "../nepenthes-basecard/nepenthes-basecard.component";
import {UserTradesClosedComponent} from "../user-trades-closed/user-trades-closed.component";
import {error} from "@angular/compiler-cli/src/transformers/util";
import {UserTradesOpenComponent} from "../user-trades-open/user-trades-open.component";

@Component({
  selector: 'app-user-trades-overviw',
  standalone: true,
  imports: [AsyncPipe, NgIf, NgForOf, NepenthesBasecardComponent, UserTradesClosedComponent, UserTradesOpenComponent],
  templateUrl: './user-trades-overviw.component.html',
  styleUrl: './user-trades-overviw.component.sass'
})
export class UserTradesOverviwComponent implements OnInit {

  tradeDateCacheSubject: BehaviorSubject<Map<string, TradeDto[]>> =
    new BehaviorSubject<Map<string, TradeDto[]>>(new Map());
  private selectedDateSubject: BehaviorSubject<string> = new BehaviorSubject('');

  selectedTrades$: Observable<TradeDto[]> = combineLatest([
    this.tradeDateCacheSubject.asObservable(),
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



  private datesSubject = new BehaviorSubject<string[]>([]);
  dates$ = this.datesSubject.asObservable();
  private tradesSubject = new BehaviorSubject<TradeDateContainerDto[]>([]);


  private user: UserDto | undefined = undefined;

  constructor(private tradeService: PollenexchangeService,
              private userService: AuthService) {


  };


  ngOnInit(): void {



    this.userService.getUser().pipe(
      concatMap(lUser => {
        // Assign user
        this.user = lUser;

        // Check if the user and username are present
        if (this.user && this.user.username) {
          // Fetch dates if the user exists
          return this.tradeService.pollenexchangeTradesDatesGet();
        } else {
          // Return an observable of null if the user doesn't exist
          return of(null);
        }
      }),
      concatMap(dates => {
        if (dates) {
          this.datesSubject.next(dates)
          // @ts-ignore
          //this.tradeService.pollenexchangeUsernameTradesGet({username:this.user?.username.username,dates:dates}).subscribe()
          return of(dates);
        } else {
          return of(null);
        }
      })
    ).subscribe({
      next: (dates) => {
        // @ts-ignore
        this.tradeService.pollenexchangeUsernameTradesGet({username: this.user.username, dates: dates}).subscribe({
          next: (tradeContainer) => this.tradesSubject.next(tradeContainer),
          error: (err) => console.log("could not get trades" + err)
        })
      }
    })
  }


  updateByDate(date: string) {
    if( !(this.user && this.user.username)){
      return
    }

    this.getTradesByDateAndUsername(date, this.user.username).subscribe(trades => {
      this.addOrUpdateTradeDate(date, trades);
      this.selectedDateSubject.next(date);
    });

  }


  private getTradesByDateAndUsername(date: string, username: string): Observable<TradeDto[]> {
    return this.tradeService.pollenexchangeUsernameTradesGet({ username, dates: [date] }).pipe(
      map(tradeContainer => {
        if (tradeContainer.length && tradeContainer[0].trades) {
          return tradeContainer[0].trades;
        } else {
          console.log('No trades found:', tradeContainer);
          return [];
        }
      }),
      catchError(err => {
        console.log('Error fetching trades:', err);
        return of([]);
      })
    );
  }

  private addOrUpdateTradeDate(key: string, value: TradeDto[]) {
    const currentCache = this.tradeDateCacheSubject.value;
    currentCache.set(key, value);
    this.tradeDateCacheSubject.next(currentCache);
  }


}
