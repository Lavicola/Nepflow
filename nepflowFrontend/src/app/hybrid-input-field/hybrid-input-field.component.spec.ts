import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HybridInputFieldComponent } from './hybrid-input-field.component';

describe('HybridInputFieldComponent', () => {
  let component: HybridInputFieldComponent;
  let fixture: ComponentFixture<HybridInputFieldComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HybridInputFieldComponent]
    });
    fixture = TestBed.createComponent(HybridInputFieldComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
