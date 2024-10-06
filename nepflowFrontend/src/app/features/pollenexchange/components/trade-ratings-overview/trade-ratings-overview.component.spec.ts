import {ComponentFixture, TestBed} from '@angular/core/testing';

import {TradeRatingsOverviewComponent} from './trade-ratings-overview.component';
import {provideHttpClient, withInterceptorsFromDi} from "@angular/common/http";
import {provideHttpClientTesting} from "@angular/common/http/testing";

describe('TradeRatingsOverviewComponent', () => {
  let component: TradeRatingsOverviewComponent;
  let fixture: ComponentFixture<TradeRatingsOverviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TradeRatingsOverviewComponent],
      providers: [provideHttpClient(withInterceptorsFromDi()), provideHttpClientTesting()]

    })
      .compileComponents();

    fixture = TestBed.createComponent(TradeRatingsOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
