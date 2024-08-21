import {ComponentFixture, TestBed} from '@angular/core/testing';

import {NepenthesCloneTableComponent} from './nepenthes-clone-table.component';

describe('NepenthesCloneTableComponent', () => {
  let component: NepenthesCloneTableComponent;
  let fixture: ComponentFixture<NepenthesCloneTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [NepenthesCloneTableComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NepenthesCloneTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
