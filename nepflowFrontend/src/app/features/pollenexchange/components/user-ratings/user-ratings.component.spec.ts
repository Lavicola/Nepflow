import {ComponentFixture, TestBed} from '@angular/core/testing';

import {UserRatingsComponent} from './user-ratings.component';
import {provideHttpClient, withInterceptorsFromDi} from "@angular/common/http";
import {provideHttpClientTesting} from "@angular/common/http/testing";

describe('UserRatingsComponent', () => {
  let component: UserRatingsComponent;
  let fixture: ComponentFixture<UserRatingsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UserRatingsComponent],
      providers: [provideHttpClient(withInterceptorsFromDi()), provideHttpClientTesting()]

    })
    .compileComponents();

    fixture = TestBed.createComponent(UserRatingsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
