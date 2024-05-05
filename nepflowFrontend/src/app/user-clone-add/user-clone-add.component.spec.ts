import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserCloneAddComponent } from './user-clone-add.component';

describe('UserCloneAddComponent', () => {
  let component: UserCloneAddComponent;
  let fixture: ComponentFixture<UserCloneAddComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UserCloneAddComponent]
    });
    fixture = TestBed.createComponent(UserCloneAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
