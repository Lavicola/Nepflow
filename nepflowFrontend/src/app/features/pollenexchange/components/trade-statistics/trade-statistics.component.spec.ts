import {ComponentFixture, TestBed} from '@angular/core/testing';

import {TradeStatisticsComponent} from './trade-statistics.component';
import {provideHttpClient, withInterceptorsFromDi} from "@angular/common/http";
import {provideHttpClientTesting} from "@angular/common/http/testing";

describe('TradeStatisticsComponent', () => {
  let component: TradeStatisticsComponent;
  let fixture: ComponentFixture<TradeStatisticsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TradeStatisticsComponent],
      providers: [provideHttpClient(withInterceptorsFromDi()), provideHttpClientTesting()]

    })
    .compileComponents();

    fixture = TestBed.createComponent(TradeStatisticsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
