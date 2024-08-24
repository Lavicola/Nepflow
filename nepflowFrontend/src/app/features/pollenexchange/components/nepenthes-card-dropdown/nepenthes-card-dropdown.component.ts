import {Component, Input, OnInit} from '@angular/core';
import {AsyncPipe, NgForOf, NgIf} from "@angular/common";
import {MatButton} from "@angular/material/button";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatOption} from "@angular/material/autocomplete";
import {MatSelect} from "@angular/material/select";
import {PollenOfferDto} from "../../models/pollen-offer-dto";
import {Observable} from "rxjs";
import {TradeCreationDto} from "../../models/trade-creation-dto";
import {TradeDto} from "../../models/trade-dto";
import {PollenexchangeService} from "../../services/pollenexchange.service";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-nepenthes-card-dropdown',
  standalone: true,
  imports: [
    AsyncPipe,
    MatButton,
    MatFormField,
    MatLabel,
    MatOption,
    MatSelect,
    NgForOf,
    NgIf,

  ],
  templateUrl: './nepenthes-card-dropdown.component.html',
  styleUrl: './nepenthes-card-dropdown.component.sass'
})
export class NepenthesCardDropdownComponent implements OnInit {


  @Input() lookup!: Map<string, Map<string, PollenOfferDto>> | undefined;
  @Input() selectedOffer: PollenOfferDto = {};
  @Input() myPollenOffers!: Observable<PollenOfferDto[]>;

  selectedOwnOffer: PollenOfferDto | undefined = undefined


  constructor(private tradeService: PollenexchangeService,
              private snackBar: MatSnackBar) {

  }

  createTrade(otherOffer: PollenOfferDto) {
    const myOffer = this.selectedOwnOffer


    if (!myOffer || !myOffer.id || !this.selectedOffer.user || !myOffer.user) {
      return
    }

    let trade: TradeCreationDto = {
      userInitiated: myOffer.user.username,
      userInitiatedOffer: myOffer.id,
      userRequestedOffer: otherOffer.id,
      userRequested: otherOffer.user?.username
    }


    this.updateLookup(myOffer,otherOffer)
    this.selectedOwnOffer = undefined
    this.tradeService.pollenexchangeCreateTradePost({body: trade}).subscribe({
      next: (trade: TradeDto) => {
        this.updateLookup(myOffer,otherOffer)
        this.selectedOwnOffer = undefined
        this.snackDialog("Request was sent!", "Close", 3000)

      },
      error: (err) => this.snackDialog("There was an error", "Close", 3000)
    })


  }

  private updateLookup(myOffer: PollenOfferDto, otherOffer: PollenOfferDto) {
    if (!(myOffer && myOffer.id && otherOffer && otherOffer.id)) {
      return
    }
    if (!this.lookup?.has(otherOffer.id)) {
      this.lookup?.set(otherOffer.id, new Map<string, PollenOfferDto>)
    }
    this.lookup?.get(otherOffer.id)?.set(myOffer.id, myOffer)

  }

  private snackDialog(msg: string, action: string, duration: number) {
    this.snackBar.open(msg, action, {
      duration: duration,
      verticalPosition: 'bottom', // Options: 'top', 'bottom'
    });
  }


  ngOnInit(): void {

    // @ts-ignore
    console.log(this.lookup)

  }

}
