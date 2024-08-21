import {ComponentFixture, TestBed} from '@angular/core/testing';

import {UserGrowlistComponent} from './user-growlist.component';
import {HttpClientTestingModule} from "@angular/common/http/testing";

describe('UserGrowlistComponent', () => {
  let component: UserGrowlistComponent;
  let fixture: ComponentFixture<UserGrowlistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UserGrowlistComponent],
      imports: [HttpClientTestingModule]

    })
    .compileComponents();

    fixture = TestBed.createComponent(UserGrowlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
