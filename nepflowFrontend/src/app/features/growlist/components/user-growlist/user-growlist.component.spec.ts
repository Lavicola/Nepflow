import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserGrowlistComponent } from './user-growlist.component';
import {HttpClientTestingModule} from "@angular/common/http/testing";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {RouterModule} from "@angular/router";

describe('UserGrowlistComponent', () => {
  let component: UserGrowlistComponent;
  let fixture: ComponentFixture<UserGrowlistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UserGrowlistComponent,HttpClientTestingModule,BrowserAnimationsModule,RouterModule.forRoot([])]
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
