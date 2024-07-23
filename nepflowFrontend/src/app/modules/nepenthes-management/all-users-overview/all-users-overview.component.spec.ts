import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllUsersOverviewComponent } from './all-users-overview.component';

describe('AllUsersOverviewComponent', () => {
  let component: AllUsersOverviewComponent;
  let fixture: ComponentFixture<AllUsersOverviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AllUsersOverviewComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AllUsersOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
