import {Component, inject, OnInit} from '@angular/core';
import {TradesService} from "../../services/trades.service";
import {TradeDto} from "../../models/trade-dto";
import {Subject} from "rxjs";
import {AsyncPipe, NgForOf, NgIf} from "@angular/common";
import {getNameOfCross} from "../../services/male-female-name-combiner";
import {NepenthesCardTextComponent} from "../nepenthes-card-text/nepenthes-card-text.component";
import {MatButton} from "@angular/material/button";
import {MatDialog} from "@angular/material/dialog";
import {TradeRatingDialogComponent} from "../trade-rating-dialog/trade-rating-dialog.component";

@Component({
  selector: 'app-trade-ratings-overview',
  standalone: true,
  imports: [
    AsyncPipe,
    NepenthesCardTextComponent,
    NgIf,
    NgForOf,
    MatButton,

  ],
  templateUrl: './trade-ratings-overview.component.html',
  styleUrl: './trade-ratings-overview.component.sass'
})
export class TradeRatingsOverviewComponent implements OnInit {

  tradesSubject: Subject<TradeDto[]> = new Subject<TradeDto[]>();
  trades$ = this.tradesSubject.asObservable();
  // the trades which were rated until user switched page
  ratedTradesId: Map<string, boolean> = new Map();

  readonly dialog = inject(MatDialog);


  constructor(private tradesService: TradesService) {
  }

  ngOnInit(): void {


    this.tradesService.pollenexchangeTradesRateableGet().subscribe({
      next: (trades: TradeDto[]) => this.tradesSubject.next(trades),
      error: () => console.log("error, rating trade")

    })


  }

  protected readonly getNameOfCross = getNameOfCross;

  openDialog(tradeId: string | undefined) {

    const dialogRef = this.dialog.open(TradeRatingDialogComponent, {
      height: '400px',
      width: '500px',
      data: {
        tradeId: tradeId
      }
    });
    dialogRef.afterClosed().subscribe(result => {
      if (result && result.success) {
        // Handle success, e.g., refresh data or show a success message
        this.ratedTradesId.set(result.tradeId, true)
      } else {
        // Handle failure if needed
        console.log('Rating addition failed.');
      }
    });


  }


}
