import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PollenOffersOverviewComponent } from './pollen-offers-overview.component';

describe('PollenOffersOverviewComponent', () => {
  let component: PollenOffersOverviewComponent;
  let fixture: ComponentFixture<PollenOffersOverviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PollenOffersOverviewComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PollenOffersOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
