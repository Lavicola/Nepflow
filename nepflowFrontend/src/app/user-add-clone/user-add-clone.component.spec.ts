import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserAddCloneComponent } from './user-add-clone.component';

describe('UserAddCloneComponent', () => {
  let component: UserAddCloneComponent;
  let fixture: ComponentFixture<UserAddCloneComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UserAddCloneComponent]
    });
    fixture = TestBed.createComponent(UserAddCloneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
