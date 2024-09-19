import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NepenthesCardTextComponent } from './nepenthes-card-text.component';

describe('NepenthesCardTextComponent', () => {
  let component: NepenthesCardTextComponent;
  let fixture: ComponentFixture<NepenthesCardTextComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NepenthesCardTextComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NepenthesCardTextComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
