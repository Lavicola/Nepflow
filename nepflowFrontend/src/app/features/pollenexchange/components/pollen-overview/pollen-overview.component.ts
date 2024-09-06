import {Component, OnInit} from '@angular/core';
import {MatSnackBar} from "@angular/material/snack-bar";
import {UserDto} from "../../../../core/models/user-dto";
import {PollenOfferDto} from "../../models/pollen-offer-dto";
import {PollenOfferDateContainerDto} from "../../models/pollen-offer-date-container-dto";
import {PollenexchangeService} from "../../services/pollenexchange.service";
import {AuthService} from "../../../../core/services/auth.service";
import {BehaviorSubject, catchError, concatMap, of, tap} from "rxjs";
import {TradeDto} from "../../models/trade-dto";
import {TradeCreationDto} from "../../models/trade-creation-dto";
import {MatOption} from "@angular/material/autocomplete";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatSelect} from "@angular/material/select";
import {
  MatCard,
  MatCardContent,
  MatCardHeader,
  MatCardLgImage,
  MatCardSubtitle,
  MatCardTitle
} from "@angular/material/card";
import {MatGridList, MatGridTile} from "@angular/material/grid-list";
import {AsyncPipe, NgForOf, NgIf} from "@angular/common";
import {MatButton} from "@angular/material/button";
import {MatButtonToggle, MatButtonToggleGroup} from "@angular/material/button-toggle";
import {FormsModule} from "@angular/forms";
import {MatIcon} from "@angular/material/icon";
import {MatInput} from "@angular/material/input";
import {MatDivider} from "@angular/material/divider";
import {FilterboxComponent} from "../filterbox/filterbox.component";
import {NepenthesBasecardComponent} from "../nepenthes-basecard/nepenthes-basecard.component";
import {NepenthesCardDropdownComponent} from "../nepenthes-card-dropdown/nepenthes-card-dropdown.component";
import {
  MatExpansionPanel,
  MatExpansionPanelDescription,
  MatExpansionPanelHeader,
  MatExpansionPanelTitle
} from "@angular/material/expansion";

@Component({
  selector: 'app-overview',
  standalone: true,
  imports: [
    MatOption,
    MatFormField,
    MatLabel,
    MatSelect,
    MatCardSubtitle,
    MatCardTitle,
    MatCardHeader,
    MatCard,
    MatGridTile,
    MatGridList,
    MatCardContent,
    NgForOf,
    NgIf,
    MatCardLgImage,
    MatButton,
    MatButtonToggleGroup,
    MatButtonToggle,
    FormsModule,
    MatInput,
    MatIcon,
    MatDivider,
    FilterboxComponent,
    AsyncPipe,
    MatExpansionPanelDescription,
    MatExpansionPanelTitle,
    MatExpansionPanel,
    MatExpansionPanelHeader,
    NepenthesBasecardComponent,
    NepenthesCardDropdownComponent,
    MatExpansionPanel,
    MatExpansionPanelTitle,
    MatExpansionPanelDescription
  ],
  templateUrl: './pollen-overview.component.html',
  styleUrl: './pollen-overview.component.sass'
})
export class PollenOverviewComponent implements OnInit {

  user: UserDto = {};
  // lookup[externalPollenOfferId][myPollenOfferid] =  PollenOffer
  // --> O(1) to  check, if  for a specific PollenOffer(external), a  PollenOffer(of the current  User)  exists
  lookup = new Map<string, Map<string, PollenOfferDto>>()
  // all Dates which  exists for PollenOffers.
  allDates: string[] = []
  dates: string[] = []
  datesToRender: number = 3


  private myPollenOffersSubject = new BehaviorSubject<PollenOfferDto[]>([]);
  private otherPollenOffersSubject = new BehaviorSubject<PollenOfferDateContainerDto[]>([]);
  private filteredPollenOffersSubject = new BehaviorSubject<PollenOfferDateContainerDto[]>([]);

  myPollenOffers$ = this.myPollenOffersSubject.asObservable();
  otherPollenOffers$ = this.otherPollenOffersSubject.asObservable();
  filteredPollenOffers$ = this.filteredPollenOffersSubject.asObservable();


  constructor(private pollenExchangeService: PollenexchangeService,
              private userService: AuthService,
              private snackBar: MatSnackBar) {


  }

  ngOnInit(): void {
    this.fetchData();


  }


  fetchData(): void {
    this.pollenExchangeService.pollenexchangePollenoffersDatesGet().pipe(
      concatMap(dates => {
        this.allDates = dates;
        this.dates = dates.slice(0, this.datesToRender);
        return this.pollenExchangeService.pollenexchangePollenoffersOpenGet({dates: this.dates});
      }),
      concatMap(containers => this.userService.getUser().pipe(
        tap(user => {
          this.user = user;
          this.splitOffers(containers, this.user?.username);
        }),
        catchError(error => {
          // Handle error fetching user data
          console.error('Error fetching user:', error);
          this.splitOffers(containers, undefined); // Provide fallback for unauthenticated user
          return of(null); // Return an observable to continue the stream
        })
      )),
      concatMap(user => {
        if (!user || !user.username) {
          return of(null);
        }
        this.pollenExchangeService.pollenexchangeUsernameTradesGet({
          dates: this.dates,
          username: user.username
        }).subscribe({
          next: (myTradeContainer) => {
            myTradeContainer.forEach(container => {
              container.trades?.forEach(trade => {
                this.processTrade(trade)

              })
            })
          }
        });

        return of(null);

      }),

      catchError(error => {
        // Handle error fetching pollen offers
        console.error('Error fetching pollen offers:', error);
        this.splitOffers([], undefined); // Provide fallback for error in pollen offers fetching
        return of([]);
      })
    ).subscribe();

  }

  splitOffers(offerContainers: PollenOfferDateContainerDto[], username: string | undefined): [PollenOfferDto[], PollenOfferDateContainerDto[]] {
    let containers: PollenOfferDateContainerDto[] = []
    let myOffers: PollenOfferDto[] = []

    if (username == undefined) {
      this.myPollenOffersSubject.next(myOffers);
      this.otherPollenOffersSubject.next(offerContainers);

      return [myOffers, offerContainers]
    }

    offerContainers.forEach(container => {
      let otherOffers: PollenOfferDto[] = []

      container.pollenOffers?.forEach(offer => {
        if (offer.user?.username == username) {
          myOffers.push(offer)
        } else {
          otherOffers.push(offer)
        }

      })

      containers.push({
        date: container.date,
        pollenOffers: otherOffers
      })
    })
    this.myPollenOffersSubject.next(myOffers);
    this.otherPollenOffersSubject.next(containers);

    return [myOffers, containers]

  }


  private updateLookup(offerId: string | undefined, relatedOfferId: string | undefined, offer: PollenOfferDto) {
    if (!(offerId && relatedOfferId)) {
      return
    }


    if (!this.lookup.has(offerId)) {
      this.lookup.set(offerId, new Map<string, PollenOfferDto>());
    }

    const offerMap = this.lookup.get(offerId);
    if (offerMap?.has(relatedOfferId)) {
      // Should never happen because a trade is not allowed to have two identical ones
      console.error("Error: Duplicate entry detected.");
    } else {
      offerMap?.set(relatedOfferId, offer);
    }
  }

  private processTrade(trade: TradeDto) {
    if (!(trade.InitiatedOffer && trade.RequestedOffer)) {
      return
    }

    const initiatedOfferUser = trade.InitiatedOffer?.user?.username;
    const requestedOfferUser = trade.RequestedOffer?.user?.username;
    const currentUser = this.user.username;

    if (initiatedOfferUser === currentUser) {
      this.updateLookup(trade.RequestedOffer?.id, trade.InitiatedOffer?.id, trade.InitiatedOffer);
    } else if (requestedOfferUser === currentUser) {
      this.updateLookup(trade.InitiatedOffer?.id, trade.RequestedOffer?.id, trade.RequestedOffer);
    }

  }
/*
  createTrade(offer: PollenOfferDto) {
    if (this.selectedOwnOffer && offer && offer.id && offer.user?.username) {
      return
    }
    let trade: TradeCreationDto = {
      userInitiated: this.selectedOwnOffer.user?.username,
      userRequestedOffer: offer.id,
      userRequested: offer.user?.username,
      userInitiatedOffer: this.selectedOwnOffer.id
    }

    this.pollenExchangeService.pollenexchangeCreateTradePost({body: trade}).subscribe({
      next: (trade: TradeDto) => {
        this.processTrade(trade)
        this.snackDialog("Request was sent!", "Close", 3000)

      },
      error: (err) => this.snackDialog("There was an error", "Close", 3000)
    })


  }
*/
  private snackDialog(msg: string, action: string, duration: number) {
    this.snackBar.open(msg, action, {
      duration: duration,
      verticalPosition: 'bottom', // Options: 'top', 'bottom'
    });
  }


  onFiltered($event: PollenOfferDateContainerDto[]) {
    this.filteredPollenOffersSubject.next($event)
  }

}
