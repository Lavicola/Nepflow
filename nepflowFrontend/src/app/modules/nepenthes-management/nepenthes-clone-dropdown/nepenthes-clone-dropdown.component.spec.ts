import {ComponentFixture, TestBed} from '@angular/core/testing';

import {NepenthesCloneDropdownComponent} from './nepenthes-clone-dropdown.component';

describe('NepenthesCloneDropdownComponent', () => {
  let component: NepenthesCloneDropdownComponent;
  let fixture: ComponentFixture<NepenthesCloneDropdownComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [NepenthesCloneDropdownComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NepenthesCloneDropdownComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
