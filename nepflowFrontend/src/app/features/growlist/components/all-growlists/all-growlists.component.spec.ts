import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllGrowlistsComponent } from './all-growlists.component';
import {HttpClientTestingModule} from "@angular/common/http/testing";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

describe('AllGrowlistsComponent', () => {
  let component: AllGrowlistsComponent;
  let fixture: ComponentFixture<AllGrowlistsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AllGrowlistsComponent,HttpClientTestingModule,BrowserAnimationsModule]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AllGrowlistsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
