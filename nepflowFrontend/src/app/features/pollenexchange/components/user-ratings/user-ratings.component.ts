import {Component, Input, OnInit} from '@angular/core';
import {TradesService} from "../../services/trades.service";
import {Observable, Subject} from "rxjs";
import {RatingPage} from "../../models/rating-page";
import {CdkTextareaAutosize} from "@angular/cdk/text-field";
import {FormsModule} from "@angular/forms";
import {MatButton} from "@angular/material/button";
import {
  MatCell,
  MatCellDef,
  MatColumnDef,
  MatHeaderCell,
  MatHeaderCellDef,
  MatHeaderRow,
  MatHeaderRowDef,
  MatRow,
  MatRowDef,
  MatTable,
  MatTableDataSource
} from "@angular/material/table";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {RatingDto} from "../../models/rating-dto";

@Component({
  selector: 'app-user-ratings',
  standalone: true,
  imports: [
    CdkTextareaAutosize,
    FormsModule,
    MatButton,
    MatCell,
    MatCellDef,
    MatColumnDef,
    MatFormField,
    MatHeaderCell,
    MatHeaderRow,
    MatHeaderRowDef,
    MatInput,
    MatLabel,
    MatRow,
    MatRowDef,
    MatTable,
    MatHeaderCellDef
  ],
  templateUrl: './user-ratings.component.html',
  styleUrl: './user-ratings.component.sass'
})
export class UserRatingsComponent implements OnInit {

  @Input() username: string | undefined;
  ratingPage: Subject<RatingPage> = new Subject<RatingPage>()
  ratingPage$: Observable<RatingPage> = this.ratingPage.asObservable()
  dataSource: MatTableDataSource<RatingDto> = new MatTableDataSource<RatingDto>();
  displayedColumns: string[] = ['comment', 'reviewType'];

  constructor(private tradeService: TradesService) {
    this.ratingPage$.subscribe({
      next: (page: RatingPage) => {
        if (page && page.ratings) {
          this.dataSource.data = page.ratings
        }
      }
    })


  }

  ngOnInit(): void {
    if (!this.username) {
      return
    }
    this.tradeService.tradesUsernameRatingsGet({username: this.username}).subscribe({
      next: (page: RatingPage) => this.ratingPage.next(page),
      error: (err) => console.log(err)
    })

  }


}
