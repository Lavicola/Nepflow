import {Component, EventEmitter, Input, OnDestroy, OnInit, Output} from '@angular/core';
import {FormsModule} from "@angular/forms";
import {MatButtonToggle, MatButtonToggleGroup} from "@angular/material/button-toggle";
import {MatCard} from "@angular/material/card";
import {MatDivider} from "@angular/material/divider";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatIcon} from "@angular/material/icon";
import {MatInput} from "@angular/material/input";
import {PollenOfferDateContainerDto} from "../../models/pollen-offer-date-container-dto";
import {PollenOfferDto} from "../../models/pollen-offer-dto";
import {NgForOf, NgIf} from "@angular/common";
import {BehaviorSubject, combineLatest, map, Observable, of, Subscription} from "rxjs";

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
    NgIf,
    NgForOf
  ],
  templateUrl: './filterbox.component.html',
  styleUrl: './filterbox.component.sass'
})
export class FilterboxComponent implements OnInit, OnDestroy {
  @Input() offerContainers$: Observable<PollenOfferDateContainerDto[]> = of([]); // Observable list of offer containers
  @Input() searchFilter: boolean = true;
  @Input() regionFilter: boolean = true;
  @Input() sexFilter: boolean = true;
  @Input() dateFilter: boolean = true;
  @Output() filteredElements = new EventEmitter<PollenOfferDateContainerDto[]>(); // Emit filtered results
  private criteriaSubject = new BehaviorSubject<Criteria>(new NullCriteria()); // Manage filter criteria
  selectedRegions: string[] = [];
  selectedSexes: string[] = [];
  selectedDates: string[] = [];
  searchTerm: string = '';
  uniqueDates: string[] = [];

  private createConcatenatedCriteriaFilter(): Criteria {
    const nullCriteria = new NullCriteria();
    let sexCriteria: Criteria = nullCriteria;
    let regionCriteria: Criteria = nullCriteria;
    let textCriteria: Criteria = nullCriteria;

    // Filter by Sex if selected
    if (this.selectedSexes.length > 0) {
      if (this.selectedSexes.length === 1) {
        sexCriteria = CriteriaGetter.getCriteria(this.selectedSexes[0]);
      } else {
        // If multiple sexes are selected, treat as all are selected
        sexCriteria = nullCriteria;
      }
    }

    // Filter by Region if selected
    if (this.selectedRegions.length > 0) {
      if (this.selectedRegions.length === 1) {
        regionCriteria = CriteriaGetter.getCriteria(this.selectedRegions[0]);
      } else if (this.selectedRegions.length === 2) {
        regionCriteria = new OrCriteria(
          CriteriaGetter.getCriteria(this.selectedRegions[0]),
          CriteriaGetter.getCriteria(this.selectedRegions[1])
        );
      } else {
        // If more than two regions are selected, treat as all are selected
        regionCriteria = nullCriteria;
      }
    }

    // Filter by search text
    if (this.searchTerm) {
      textCriteria = new TextCriteria(this.searchTerm);
    }

    // Combine all criteria
    return new AndCriteria(textCriteria, new AndCriteria(sexCriteria, regionCriteria));
  }

  private subscriptions: Subscription = new Subscription();

  ngOnInit(): void {
    this.offerContainers$.subscribe(containers => {
      containers.forEach(container => {
        if (container.date) {
          this.uniqueDates.push(container.date)
        }
      })
      if(this.uniqueDates.length>=1){
        this.uniqueDates.reverse();
      }

    });

    this.subscriptions.add(
      combineLatest([this.offerContainers$, this.criteriaSubject]).pipe(
        map(([containers, criteria]) => this.applyFilters(containers, criteria))
      ).subscribe(filtered => this.filteredElements.emit(filtered))
    );
  }

  ngOnDestroy(): void {
    this.subscriptions.unsubscribe(); // Unsubscribes from all subscriptions added
  }


  private applyFilters(offerContainers: PollenOfferDateContainerDto[], criteria: Criteria): PollenOfferDateContainerDto[] {

    return offerContainers.map(container => {
      let filteredOffers: PollenOfferDto[] = []

      if (!container.pollenOffers || !container.date) {
        // this case should be impossible
        return {
          date: "???",
          pollenOffers: filteredOffers
        };

      }


      //prefilter, either container is of date or not
      if (this.selectedDates.length) {
        filteredOffers = this.selectedDates.includes(container.date) ? container.pollenOffers : [];
      } else {
        filteredOffers = container.pollenOffers
      }

      filteredOffers = criteria.meetCriteria(filteredOffers);

      return {
        date: container.date,
        pollenOffers: filteredOffers
      };
    });
  }

  updateFilter() {
    const concatenatedCriteria = this.createConcatenatedCriteriaFilter();
    this.criteriaSubject.next(concatenatedCriteria);
  }

  clearFilters(): void {
    this.criteriaSubject.next(new NullCriteria()); // Reset to no filters
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

