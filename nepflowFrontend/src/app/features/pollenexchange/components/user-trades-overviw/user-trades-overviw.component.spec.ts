import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserTradesOverviwComponent } from './user-trades-overviw.component';
import {provideHttpClient, withInterceptorsFromDi} from "@angular/common/http";
import {provideHttpClientTesting} from "@angular/common/http/testing";

describe('UserTradesOverviwComponent', () => {
  let component: UserTradesOverviwComponent;
  let fixture: ComponentFixture<UserTradesOverviwComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UserTradesOverviwComponent],
      providers: [provideHttpClient(withInterceptorsFromDi()), provideHttpClientTesting()]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserTradesOverviwComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
