import {ComponentFixture, TestBed} from '@angular/core/testing';

import {NepenthesCloneComponent} from './nepenthes-clone.component';

describe('NepenthesCloneComponent', () => {
  let component: NepenthesCloneComponent;
  let fixture: ComponentFixture<NepenthesCloneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [NepenthesCloneComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NepenthesCloneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
