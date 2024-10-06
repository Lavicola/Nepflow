import {ComponentFixture, TestBed} from '@angular/core/testing';

import {NepenthesCardSimpleComponent} from './nepenthes-card-simple.component';

describe('NepenthesCardSimpleComponent', () => {
  let component: NepenthesCardSimpleComponent;
  let fixture: ComponentFixture<NepenthesCardSimpleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NepenthesCardSimpleComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NepenthesCardSimpleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
