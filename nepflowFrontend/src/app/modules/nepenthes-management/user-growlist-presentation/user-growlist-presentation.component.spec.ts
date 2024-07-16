import {ComponentFixture, TestBed} from '@angular/core/testing';

import {UserGrowlistPresentationComponent} from './user-growlist-presentation.component';

describe('UserGrowlistPresentationComponent', () => {
  let component: UserGrowlistPresentationComponent;
  let fixture: ComponentFixture<UserGrowlistPresentationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UserGrowlistPresentationComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserGrowlistPresentationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
