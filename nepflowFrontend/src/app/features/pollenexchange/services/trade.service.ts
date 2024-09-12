import {Injectable} from '@angular/core';
import {PollenexchangeService} from "./pollenexchange.service";
import {AuthService} from "../../../core/services/auth.service";
import {ActivatedRoute} from "@angular/router";
import {BehaviorSubject, catchError, concatMap, map, Observable, of} from "rxjs";
import {TradeDateContainerDto} from "../models/trade-date-container-dto";
import {UserDto} from "../../../core/models/user-dto";
import {TradeDto} from "../models/trade-dto";

@Injectable({
  providedIn: 'root'
})
export class TradeService {
  private selectedDateSubject: BehaviorSubject<string> = new BehaviorSubject('');

  tradeDateCacheSubject: BehaviorSubject<Map<string, TradeDto[]>> =
    new BehaviorSubject<Map<string, TradeDto[]>>(new Map());
  private tradesSubject = new BehaviorSubject<TradeDateContainerDto[]>([]);
  private user: UserDto | undefined = undefined;
  private datesSubject = new BehaviorSubject<string[]>([]);


  constructor(private tradeService: PollenexchangeService) {


  };

  public setUser(user: UserDto) {
    this.user = user;
  }


  public init() {
    this.tradeService.pollenexchangeTradesDatesGet().pipe(
      concatMap(dates => {
        if (dates) {
          this.datesSubject.next(dates);
          // @ts-ignore
          return this.tradeService.pollenexchangeUsernameTradesGet({username: this.user.username, dates: dates}); // Replace 'some-username' with the actual username or mechanism to get it
        } else {
          return of([]);
        }
      })
    ).subscribe({
      next: (tradeContainer) => {
        if (tradeContainer) {
          this.tradesSubject.next(tradeContainer);
        }
      },
      error: (err) => console.log("could not get trades", err)
    });
  }

  public subscribeToDateSubject(){
    return  this.datesSubject.asObservable()
  }

  public subscribeTotradeDateCacheSubject(){
    return this.tradeDateCacheSubject.asObservable()
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


  private addOrUpdateTradeDate(key: string, value: TradeDto[]) {
    const currentCache = this.tradeDateCacheSubject.value;
    currentCache.set(key, value);
    this.tradeDateCacheSubject.next(currentCache);
  }



  private getTradesByDateAndUsername(date: string, username: string): Observable<TradeDto[]> {
    return this.tradeService.pollenexchangeUsernameTradesGet({username, dates: [date]}).pipe(
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


}
