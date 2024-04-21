import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NepenthesOverviewComponent } from './nepenthes-overview.component';

describe('NepenthesOverviewComponent', () => {
  let component: NepenthesOverviewComponent;
  let fixture: ComponentFixture<NepenthesOverviewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NepenthesOverviewComponent]
    });
    fixture = TestBed.createComponent(NepenthesOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
