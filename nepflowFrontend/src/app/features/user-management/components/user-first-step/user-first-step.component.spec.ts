import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserFirstStepComponent } from './user-first-step.component';
import {HttpClientTestingModule} from "@angular/common/http/testing";
import {provideAnimationsAsync} from "@angular/platform-browser/animations/async";

describe('UserFirstStepComponent', () => {
  let component: UserFirstStepComponent;
  let fixture: ComponentFixture<UserFirstStepComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UserFirstStepComponent,HttpClientTestingModule],
      providers: [provideAnimationsAsync()]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserFirstStepComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
