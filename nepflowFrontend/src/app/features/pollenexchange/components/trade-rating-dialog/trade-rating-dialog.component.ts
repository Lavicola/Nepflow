import {Component, Inject} from '@angular/core';
import {ReviewType} from "../../models/review-type";
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {TradesService} from "../../services/trades.service";
import {MatSnackBar} from "@angular/material/snack-bar";
import {FileUploadComponent, requiredFileType} from "../../../../core/components/file-upload/file-upload.component";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {RatingDto} from "../../models/rating-dto";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatRadioButton, MatRadioGroup} from "@angular/material/radio";
import {MatCard, MatCardContent, MatCardTitle} from "@angular/material/card";
import {MatInput} from "@angular/material/input";
import {MatButton} from "@angular/material/button";
import {NgForOf} from "@angular/common";

@Component({
  selector: 'app-trade-rating-dialog',
  standalone: true,
  imports: [
    FileUploadComponent,
    MatLabel,
    MatFormField,
    MatRadioGroup,
    MatCardTitle,
    MatCardContent,
    MatRadioButton,
    MatCard,
    ReactiveFormsModule,
    MatInput,
    MatButton,
    NgForOf
  ],
  templateUrl: './trade-rating-dialog.component.html',
  styleUrl: './trade-rating-dialog.component.sass'
})
export class TradeRatingDialogComponent {

  private tradeId!: string;
  reviewTypes = [ReviewType.SUCCESS, ReviewType.FAILURE]
  ratingForm: FormGroup
  image: any;

  constructor(@Inject(MAT_DIALOG_DATA) private data: any,
              public dialogRef: MatDialogRef<TradeRatingDialogComponent>,
              private formBuilder: FormBuilder,
              private tradeService: TradesService,
              private _snackBar: MatSnackBar) {
    this.tradeId = data.tradeId

    this.ratingForm = this.formBuilder.group({
      reviewType: ['', Validators.required],
      comment: ['', []],
      file: [null, requiredFileType(["png", "jpg"])],
    });
  }


  submit() {
    let rating: RatingDto = {};
    Object.assign(rating, this.ratingForm.value);


    this.tradeService.tradesTradeIdRatingPost({tradeId: this.tradeId, body: rating}).subscribe({
      next: () => {
        this._snackBar.open("Rating added!", "Ok", {
          duration: 1500,
          horizontalPosition: 'center',
          verticalPosition: 'bottom',
          panelClass: ['snackbar-success']
        })
        this.dialogRef.close({ success: true,tradeId:this.tradeId });
      },
      error: () => this._snackBar.open("Failed to add Rating, please try again", "Ok", {
        duration: 1500,
        horizontalPosition: 'center',
        verticalPosition: 'bottom',
        panelClass: ['snackbar-error']
      })
    })
  }

}
