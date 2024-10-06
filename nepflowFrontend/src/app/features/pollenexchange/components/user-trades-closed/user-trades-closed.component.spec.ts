import {ComponentFixture, TestBed} from '@angular/core/testing';

import {UserTradesClosedComponent} from './user-trades-closed.component';

describe('UserTradesClosedComponent', () => {
  let component: UserTradesClosedComponent;
  let fixture: ComponentFixture<UserTradesClosedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UserTradesClosedComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserTradesClosedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
