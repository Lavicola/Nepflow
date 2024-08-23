import {AfterContentInit, Component, EventEmitter, Input, Output} from '@angular/core';
import {FormsModule} from "@angular/forms";
import {MatButtonToggle, MatButtonToggleGroup} from "@angular/material/button-toggle";
import {MatCard} from "@angular/material/card";
import {MatDivider} from "@angular/material/divider";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatIcon} from "@angular/material/icon";
import {MatInput} from "@angular/material/input";
import {PollenOfferDateContainerDto} from "../../models/pollen-offer-date-container-dto";
import {PollenOfferDto} from "../../models/pollen-offer-dto";
import {NgIf} from "@angular/common";

@Component({
  selector: 'app-filterbox',
  standalone: true,
  imports: [
    FormsModule,
    MatButtonToggle,
    MatButtonToggleGroup,
    MatCard,
    MatDivider,
    MatFormField,
    MatIcon,
    MatInput,
    MatLabel,
    NgIf
  ],
  templateUrl: './filterbox.component.html',
  styleUrl: './filterbox.component.sass'
})
export class FilterboxComponent {

  @Input() offerContainers: PollenOfferDateContainerDto[] = []
  @Input() searchFilter: boolean = true
  @Input() regionFilter: boolean = true
  @Input() sexFilter: boolean = true

  @Output() filteredElements = new EventEmitter<PollenOfferDateContainerDto[]>();


  selectedRegions: any;
  selectedSexes: any;
  searchTerm: any;


  constructor() {
  }

  doFilter() {

    const filteredContainers: PollenOfferDateContainerDto[] = []
    let concatenatedCriteria = this.createConcatenatedCriteriaFilter();
    this.offerContainers.forEach(container => {
      let filteredOffers: PollenOfferDto[] = []
      if (container.pollenOffers) {
        filteredOffers = concatenatedCriteria.meetCriteria(container.pollenOffers)
      } else {
        filteredOffers = []

      }
      filteredContainers.push({
        date: container.date,
        pollenOffers: filteredOffers
      })
    })
    this.filteredElements.emit(filteredContainers)


  }

  createConcatenatedCriteriaFilter(): Criteria {

    let nullCriteria = new NullCriteria();
    let sexCriteria;
    let regionCriteria;
    let textCriteria;

    // Filter by Sex if selected
    if (this.selectedSexes) {
      switch (this.selectedSexes.length) {
        case 1:
          sexCriteria = CriteriaGetter.getCriteria(this.selectedSexes[0]);
          break
        default:
          // if both are selected, all are selected
          sexCriteria = nullCriteria;
      }
    } else {
      sexCriteria = nullCriteria
    }
    // Filter by Region if selected
    if (this.selectedRegions) {
      switch (this.selectedRegions.length) {
        case 1:
          regionCriteria = CriteriaGetter.getCriteria(this.selectedRegions[0]);
          break
        case 2:
          regionCriteria = new OrCriteria(CriteriaGetter.getCriteria(this.selectedRegions[0]), CriteriaGetter.getCriteria(this.selectedRegions[1]));
          break
        default:
          // if three are selected, all are selected
          regionCriteria = nullCriteria;
      }
    } else {
      regionCriteria = nullCriteria
    }
    // Filter by search text
    if (this.searchTerm) {
      textCriteria = new TextCriteria(this.searchTerm)
    } else {
      textCriteria = new NullCriteria();
    }

    return new AndCriteria(textCriteria, new AndCriteria(sexCriteria, regionCriteria))


  }


}


class CriteriaGetter {
  public static getCriteria(filtername: string): Criteria {
    switch (filtername) {
      case "Male":
        return new CriteriaMale();
      case "Female":
        return new CriteriaFemale();
      case "USA":
        return new CriteriaUSA();
      case "Asia":
        return new CriteriaAsia();
      case "Europe":
        return new CriteriaEurope();
      default:
        return new NullCriteria()
    }

  }

}

interface Criteria {
  meetCriteria(pollenoffers: PollenOfferDto[]): PollenOfferDto[]
}

class OrCriteria implements Criteria {
  private criteria: Criteria;
  private otherCriteria: Criteria;


  constructor(criteria: Criteria, otherCriteria: Criteria) {

    this.criteria = criteria;
    this.otherCriteria = otherCriteria;

  }

  meetCriteria(pollenoffers: PollenOfferDto[]): PollenOfferDto[] {
    const firstCriteriaItems = this.criteria.meetCriteria(structuredClone(pollenoffers));
    const otherCriteriaItems = this.otherCriteria.meetCriteria(structuredClone(pollenoffers));

    otherCriteriaItems.forEach((offer) => {
      if (!firstCriteriaItems.includes(offer)) {
        firstCriteriaItems.push(offer)
      }
    })

    return firstCriteriaItems;
  }
}

class AndCriteria implements Criteria {
  private criteria: Criteria;
  private otherCriteria: Criteria;

  constructor(criteria: Criteria, otherCriteria: Criteria) {
    this.criteria = criteria;
    this.otherCriteria = otherCriteria;

  }

  meetCriteria(pollenoffers: PollenOfferDto[]): PollenOfferDto[] {

    const firstCriteriaItems = this.criteria.meetCriteria(pollenoffers);

    return this.otherCriteria.meetCriteria(firstCriteriaItems);
  }
}

class NullCriteria implements Criteria {

  meetCriteria(pollenoffers: PollenOfferDto[]): PollenOfferDto[] {
    return pollenoffers;
  }


}

class TextCriteria implements Criteria {

  searchText: string = "";

  constructor(text: string) {
    this.searchText = text;

  }

  meetCriteria(pollenoffers: PollenOfferDto[]): PollenOfferDto[] {
    const lPollenOffers = pollenoffers.filter(offer => offer.nepenthesName?.includes(this.searchText))
    return lPollenOffers;
  }


}

class CriteriaUSA implements Criteria {
  meetCriteria(pollenoffers: PollenOfferDto[]): PollenOfferDto[] {

    const lPollenOffers = pollenoffers.filter(offer => {
      if (offer.user?.country) {
        return offer.user.country == "USA"
      } else {
        return false;
      }
    });
    return lPollenOffers;
  }
}

class CriteriaAsia implements Criteria {
  meetCriteria(pollenoffers: PollenOfferDto[]): PollenOfferDto[] {

    const lPollenOffers = pollenoffers.filter(offer => {
      if (offer.user?.country) {
        return offer.user.country == "Asia"
      } else {
        return false;
      }
    });
    return lPollenOffers;
  }
}

class CriteriaEurope implements Criteria {
  meetCriteria(pollenoffers: PollenOfferDto[]): PollenOfferDto[] {

    const lPollenOffers = pollenoffers.filter(offer => {
      if (offer.user?.country) {
        return offer.user.country == "Europe"
      } else {
        return false;
      }
    });
    return lPollenOffers;
  }
}

class CriteriaMale implements Criteria {
  meetCriteria(pollenoffers: PollenOfferDto[]): PollenOfferDto[] {
    const lPollenOffers = pollenoffers.filter(offer => offer.sex == "Male");
    return lPollenOffers;
  }

}

class CriteriaFemale implements Criteria {
  meetCriteria(pollenoffers: PollenOfferDto[]): PollenOfferDto[] {
    const lPollenOffers = pollenoffers.filter(offer => offer.sex == "Female");
    return lPollenOffers;
  }

}

