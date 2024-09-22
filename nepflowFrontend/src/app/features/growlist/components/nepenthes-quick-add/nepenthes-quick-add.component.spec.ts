import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NepenthesQuickAddComponent } from './nepenthes-quick-add.component';

describe('NepenthesQuickAddComponent', () => {
  let component: NepenthesQuickAddComponent;
  let fixture: ComponentFixture<NepenthesQuickAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NepenthesQuickAddComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NepenthesQuickAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
