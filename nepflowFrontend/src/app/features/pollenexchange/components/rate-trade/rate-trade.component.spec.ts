import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RateTradeComponent } from './rate-trade.component';
import {provideHttpClient, withInterceptorsFromDi} from "@angular/common/http";
import {provideHttpClientTesting} from "@angular/common/http/testing";
import {provideAnimationsAsync} from "@angular/platform-browser/animations/async";

describe('RateTradeComponent', () => {
  let component: RateTradeComponent;
  let fixture: ComponentFixture<RateTradeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RateTradeComponent],
      providers: [provideAnimationsAsync(), provideHttpClient(withInterceptorsFromDi()), provideHttpClientTesting()]

    })
    .compileComponents();

    fixture = TestBed.createComponent(RateTradeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
