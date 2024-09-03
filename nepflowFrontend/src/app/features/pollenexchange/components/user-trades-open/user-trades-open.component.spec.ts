import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserTradesOpenComponent } from './user-trades-open.component';
import {provideHttpClient, withInterceptorsFromDi} from "@angular/common/http";
import {provideHttpClientTesting} from "@angular/common/http/testing";

describe('UserTradesOpenComponent', () => {
  let component: UserTradesOpenComponent;
  let fixture: ComponentFixture<UserTradesOpenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UserTradesOpenComponent],
      providers: [provideHttpClient(withInterceptorsFromDi()), provideHttpClientTesting()]

    })
    .compileComponents();

    fixture = TestBed.createComponent(UserTradesOpenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
