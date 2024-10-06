import {ComponentFixture, TestBed} from '@angular/core/testing';

import {UserFirstStepComponent} from './user-first-step.component';
import {provideHttpClientTesting} from "@angular/common/http/testing";
import {provideAnimationsAsync} from "@angular/platform-browser/animations/async";
import {provideHttpClient, withInterceptorsFromDi} from '@angular/common/http';

describe('UserFirstStepComponent', () => {
  let component: UserFirstStepComponent;
  let fixture: ComponentFixture<UserFirstStepComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
    imports: [UserFirstStepComponent],
    providers: [provideAnimationsAsync(), provideHttpClient(withInterceptorsFromDi()), provideHttpClientTesting()]
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
