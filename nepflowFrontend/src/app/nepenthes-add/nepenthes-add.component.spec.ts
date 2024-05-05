import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NepenthesAddComponent } from './nepenthes-add.component';

describe('NepenthesAddComponent', () => {
  let component: NepenthesAddComponent;
  let fixture: ComponentFixture<NepenthesAddComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NepenthesAddComponent]
    });
    fixture = TestBed.createComponent(NepenthesAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
