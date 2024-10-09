import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {TradeDto} from "../../models/trade-dto";
import {NepenthesCardSimpleComponent} from "../nepenthes-card-simple/nepenthes-card-simple.component";
import {NgClass, NgForOf, NgIf} from "@angular/common";
import {MatButton} from "@angular/material/button";
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {FileUploadComponent, requiredFileType} from "../../../../core/components/file-upload/file-upload.component";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {MatRadioButton, MatRadioGroup} from "@angular/material/radio";
import {ReviewType} from "../../models/review-type";
import {RatingDto} from "../../models/rating-dto";
import {MatSnackBar} from "@angular/material/snack-bar";
import {TradesService} from "../../services/trades.service";
import {MatButtonToggle, MatButtonToggleGroup} from "@angular/material/button-toggle";
import {MatDivider} from "@angular/material/divider";
import {MatGridList, MatGridTile} from "@angular/material/grid-list";

@Component({
  selector: 'app-rate-trade',
  standalone: true,
  imports: [
    NepenthesCardSimpleComponent,
    NgIf,
    MatButton,
    FileUploadComponent,
    MatFormField,
    MatInput,
    MatLabel,
    MatRadioButton,
    MatRadioGroup,
    NgForOf,
    ReactiveFormsModule,
    MatButtonToggleGroup,
    MatButtonToggle,
    MatDivider,
    NgClass,
    MatGridList,
    MatGridTile
  ],
  templateUrl: './rate-trade.component.html',
  styleUrl: './rate-trade.component.sass'
})
export class RateTradeComponent implements OnInit {


  @Input() trade!: TradeDto
  @Input() loggedInUser!: string
  @Output() tradeRated = new EventEmitter<{ success: boolean, tradeId: string }>();

  public cardWithBorder:boolean = false
  public otherUser: string = ""
  ratingForm: FormGroup
  reviewTypes = [ReviewType.SUCCESS, ReviewType.FAILURE]
  selectedReviewType: ReviewType = ReviewType.PENDING;


  constructor(private formBuilder: FormBuilder,
              private snackBar: MatSnackBar,
              private tradeService: TradesService) {
    this.ratingForm = this.formBuilder.group({
      reviewType: ['', Validators.required],
      comment: ['', []],
      file: [null, requiredFileType(["png", "jpeg","jpg"])],
    });


  }

  ngOnInit(): void {

    if (this.trade &&
      this.trade.InitiatedOffer?.user?.username != undefined &&
      this.trade.RequestedOffer?.user?.username != undefined) {
      this.otherUser = this.trade.InitiatedOffer?.user?.username ?
        this.loggedInUser = this.trade.RequestedOffer?.user?.username :
        this.otherUser = this.trade.InitiatedOffer?.user?.username

    }

    if (this.trade) {
      // make sure that male offer is left.
      let tmp = this.trade.InitiatedOffer
      if (this.trade.InitiatedOffer?.sex == "Male") {
        return
      } else {
        this.trade.InitiatedOffer = this.trade.RequestedOffer;
        this.trade.RequestedOffer = tmp;
      }
    }



  }
  // @ts-ignore
  submit() {
    if(!this.trade.id){
      return
    }
    let rating: RatingDto = {};
    Object.assign(rating, this.ratingForm.value);
    this.tradeService.tradesTradeIdRatingPost({tradeId: this.trade.id, body: rating}).subscribe({
      next: () => {
        this.snackBar.open("Rating added!", "Ok", {
          duration: 1500,
          horizontalPosition: 'center',
          verticalPosition: 'bottom',
          panelClass: ['snackbar-success']
        })
        // @ts-ignore
        this.tradeRated.emit({ success: true, tradeId: this.trade.id });

      },
      error: () => {
        this.snackBar.open("Failed to add Rating, please try again", "Ok", {
          duration: 1500,
          horizontalPosition: 'center',
          verticalPosition: 'bottom',
          panelClass: ['snackbar-error']
        })
        // @ts-ignore
        this.tradeRated.emit({ success: false, tradeId: this.trade.id });
      }
    })
  }





  protected readonly ReviewType = ReviewType;
}
