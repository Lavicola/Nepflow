import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NepenthesBasecardComponent } from './nepenthes-basecard.component';

describe('NepenthesBasecardComponent', () => {
  let component: NepenthesBasecardComponent;
  let fixture: ComponentFixture<NepenthesBasecardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NepenthesBasecardComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NepenthesBasecardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
