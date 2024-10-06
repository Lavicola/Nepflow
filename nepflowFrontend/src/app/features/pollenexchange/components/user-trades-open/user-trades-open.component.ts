import {Component, Input, OnInit} from '@angular/core';
import {AsyncPipe, NgForOf, NgIf} from "@angular/common";
import {NepenthesBasecardComponent} from "../nepenthes-basecard/nepenthes-basecard.component";
import {BehaviorSubject, combineLatest, map, Observable, startWith} from "rxjs";
import {TradeDto} from "../../models/trade-dto";
import {AuthService} from "../../../../core/services/auth.service";
import {UserDto} from "../../../../core/models/user-dto";
import {MatGridList, MatGridTile} from "@angular/material/grid-list";
import {MatFormField} from "@angular/material/form-field";
import {MatButton} from "@angular/material/button";
import {MatSnackBar} from "@angular/material/snack-bar";
import {getNameOfCross} from "../../services/male-female-name-combiner";
import {NepenthesCardTextComponent} from "../nepenthes-card-text/nepenthes-card-text.component";
import {NepenthesCardSimpleComponent} from "../nepenthes-card-simple/nepenthes-card-simple.component";
import {TradesService} from "../../services/trades.service";

@Component({
  selector: 'app-user-trades-open',
  standalone: true,
  imports: [
    AsyncPipe,
    NepenthesBasecardComponent,
    NgForOf,
    NgIf,
    MatGridList,
    MatGridTile,
    MatFormField,
    MatButton,
    NepenthesCardTextComponent,
    NepenthesCardSimpleComponent
  ],
  templateUrl: './user-trades-open.component.html',
  styleUrl: './user-trades-open.component.sass'
})
export class UserTradesOpenComponent implements OnInit {

  @Input() allTrades: Observable<TradeDto[]> = new BehaviorSubject<TradeDto[]>([]);

  private tradeUser$!: Observable<[TradeDto[], UserDto]>;
  public myInitiatedTrades$!:Observable<TradeDto[]>;
  private myTradesToAnswer$!:Observable<TradeDto[]>;
  public myTradesToAnswerFiltered$!:Observable<TradeDto[]>;

  myPendingTrades$!: Observable<TradeDto[]>;
  otherPendingTrades$!: Observable<TradeDto[]>;
  otherPendingTradesFiltered$!: Observable<TradeDto[]>
  private removeTradSubject = new BehaviorSubject<Set<string>>(new Set<string>());


  constructor(private userService: AuthService,
              private tradeService: TradesService,
              private snackBar: MatSnackBar) {


  }

  ngOnInit() {


    this.tradeUser$ = combineLatest([
      this.allTrades.pipe(startWith([])),
      this.userService.getUser()
    ])
    this.myInitiatedTrades$ = this.tradeUser$.pipe(
      map(([trades, user]) =>
        trades.filter(trade => trade.status == "WAITING" && trade?.InitiatedOffer?.user?.username === user.username)
      ));


    this.myTradesToAnswer$ = this.tradeUser$.pipe(
      map(([trades, user]) => {
        return trades.filter(trade => trade.status == "WAITING" && trade?.InitiatedOffer?.user?.username !== user.username);
      })
    );

    this.myTradesToAnswerFiltered$ = combineLatest([
      this.myTradesToAnswer$,
      this.removeTradSubject
    ]).pipe(
      map(([trades, removedTradeIds]) => {
        console.log("Filtering trades with removedTradeIds:", removedTradeIds);
        // @ts-ignore
        return trades.filter(trade => !removedTradeIds.has(trade.id));
      })
    );




  }

  answerTrade(answer: boolean, tradeId: string | undefined) {
    if (!tradeId) {
      return
    }
    this.tradeService.pollenexchangeTradeTradeIdPut({tradeId: tradeId, body: {acceptTrade: answer}}).subscribe({
        next: () => {
          this.snackBar.open("Your Answer was successfully stored!", "Close", {duration: 3000})
          this.updateRemoveTradeSubject(tradeId)
        },
       error: () => this.snackBar.open("There was an error, please try again alter", "Close", {duration: 3000})

      })
  }

  /**
   * Method used to remove answered Trades at runtime
   * @param tradeId
   * @private
   */
  private updateRemoveTradeSubject(tradeId:string){
    const removedids = this.removeTradSubject.value;
    removedids.add(tradeId)
    this.removeTradSubject.next(removedids)
  }


  protected readonly getNameOfCross = getNameOfCross;
}
