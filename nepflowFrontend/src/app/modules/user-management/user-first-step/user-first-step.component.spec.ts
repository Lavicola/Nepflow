import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserFirstStepComponent } from './user-first-step.component';

describe('UserFirstStepComponent', () => {
  let component: UserFirstStepComponent;
  let fixture: ComponentFixture<UserFirstStepComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UserFirstStepComponent]
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
