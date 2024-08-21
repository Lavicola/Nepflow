import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllUsersOverviewComponent } from './all-users-overview.component';
import {HttpClientTestingModule} from "@angular/common/http/testing";

describe('AllUsersOverviewComponent', () => {
  let component: AllUsersOverviewComponent;
  let fixture: ComponentFixture<AllUsersOverviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AllUsersOverviewComponent],
      imports: [HttpClientTestingModule]
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
