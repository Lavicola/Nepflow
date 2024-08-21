import {Component, OnInit} from '@angular/core';
import {PollenexchangeService} from "../services/pollenexchange.service";
import {PollenOfferDateContainerDto} from "../models/pollen-offer-date-container-dto";
import {TradeCreationDto} from "../models/trade-creation-dto";
import {TradeDateContainerDto} from "../models/trade-date-container-dto";
import {error} from "@angular/compiler-cli/src/transformers/util";
import {PollenOfferDto} from "../models/pollen-offer-dto";
import {UsernameService} from "../../../services/UsernameService";
import {combineLatest, concatMap, of} from "rxjs";
import {TradeDto} from "../models/trade-dto";
import {AuthService} from "../../../services/AuthService";
import {UserDto} from "../models/user-dto";
import {MatSnackBar} from "@angular/material/snack-bar";


@Component({
  selector: 'app-pollen-offers-overview',
  templateUrl: './pollen-offers-overview.component.html',
  styleUrl: './pollen-offers-overview.component.css'
})
export class PollenOffersOverviewComponent implements OnInit {

  user: UserDto = {};
  // lookup[externalPollenOfferId][myPollenOfferid] =  PollenOffer
  // --> O(1) to  check, if  for a specific PollenOffer(external), a  PollenOffer(of the current  User)  exists
  lookup = new Map<string, Map<string, PollenOfferDto>>()

  otherPollenOffers: PollenOfferDateContainerDto[] = []
  myPollenOffers: PollenOfferDto[] = []
  // all Dates which  exists for PollenOffers.
  allDates:string[]  =  []
  dates:string[]  =  []
  datesToRender:number  = 2


  selectedOwnOffer!: PollenOfferDto;

  constructor(private pollenExchangeService: PollenexchangeService,
              private userService: AuthService,
              private snackBar: MatSnackBar) {


  }

  ngOnInit(): void {


    let containers: PollenOfferDateContainerDto[] = []

    this.pollenExchangeService.pollenexchangePollenoffersDatesGet().pipe(
      concatMap(dates => {
        this.allDates = dates;
        this.dates  = dates.slice(0,this.datesToRender)
        console.log(dates)
        return this.pollenExchangeService.pollenexchangePollenoffersOpenGet({dates: this.dates});
      }),
      concatMap(container => {
        containers = container;
        return this.userService.getUser();
      })
    )
      .subscribe({
        next: (user: UserDto) => {
          this.user = user
        },
        error: () => {
          //  anonymous User, show all
          this.otherPollenOffers =  containers
        },
        complete: () => {
          if (this.user != null && this.user.username) {
            [this.myPollenOffers, this.otherPollenOffers] = splitOffers(containers, this.user?.username);
            this.pollenExchangeService.pollenexchangeUsernameTradesGet({
              username: this.user.username,
              dates: this.dates
            }).subscribe({
              next: (myTradeContainer) => {
                myTradeContainer.forEach(container => {
                  container.trades?.forEach(trade => {
                    this.processTrade(trade)
                  })
                })
              }
            })
          }
        }
      });

    function splitOffers(offerContainers: PollenOfferDateContainerDto[], username: string | undefined): [PollenOfferDto[], PollenOfferDateContainerDto[]] {
      let containers: PollenOfferDateContainerDto[] = []
      let myOffers: PollenOfferDto[] = []


      if (username == undefined) {
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

      return [myOffers, containers]

    }

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

  processTrade(trade: TradeDto) {
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

  createTrade(offer: PollenOfferDto) {
    if (!this.selectedOwnOffer && offer && offer.id && offer.user?.username) {
      return
    }
    let trade: TradeCreationDto = {
      userInitiated: this.selectedOwnOffer.user?.username,
      userRequestedOffer: offer.id,
      userRequested: offer.user?.username,
      userInitiatedOffer: this.selectedOwnOffer.id
    }

     this.pollenExchangeService.pollenexchangeCreateTradePost({body: trade}).subscribe({
       next: (trade:TradeDto) => {
         this.processTrade(trade)
         this.snackDialog("Request was sent!","Close",3000)

       },
      error: (err) => this.snackDialog("There was an error","Close",3000)
    })


  }

  private snackDialog(msg:string,action:string,duration:number){
    this.snackBar.open(msg, action, {
      duration: duration,
      verticalPosition: 'bottom', // Options: 'top', 'bottom'
    });
  }



}
