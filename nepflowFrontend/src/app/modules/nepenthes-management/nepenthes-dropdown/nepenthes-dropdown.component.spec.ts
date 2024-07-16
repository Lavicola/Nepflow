import {ComponentFixture, TestBed} from '@angular/core/testing';

import {NepenthesDropdownComponent} from './nepenthes-dropdown.component';

describe('NepenthesDropdownComponent', () => {
  let component: NepenthesDropdownComponent;
  let fixture: ComponentFixture<NepenthesDropdownComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [NepenthesDropdownComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NepenthesDropdownComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
