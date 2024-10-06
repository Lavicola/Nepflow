import {ComponentFixture, TestBed} from '@angular/core/testing';

import {TradeRatingDialogComponent} from './trade-rating-dialog.component';
import {provideHttpClient, withInterceptorsFromDi} from "@angular/common/http";
import {provideHttpClientTesting} from "@angular/common/http/testing";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {provideAnimationsAsync} from "@angular/platform-browser/animations/async";

describe('TradeRatingDialogComponent', () => {
  let component: TradeRatingDialogComponent;
  let fixture: ComponentFixture<TradeRatingDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TradeRatingDialogComponent],
      providers: [
        [provideAnimationsAsync(), provideHttpClient(withInterceptorsFromDi()), provideHttpClientTesting()],
        {provide: MAT_DIALOG_DATA, useValue: {success: true, tradeId: "5452"}},
        {provide: MatDialogRef, useValue: {success: true, tradeId: "id"}}

      ]

    })
      .compileComponents();

    fixture = TestBed.createComponent(TradeRatingDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
