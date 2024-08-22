import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllGrowlistsComponent } from './all-growlists.component';
import { provideHttpClientTesting } from "@angular/common/http/testing";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { provideHttpClient, withInterceptorsFromDi } from '@angular/common/http';

describe('AllGrowlistsComponent', () => {
  let component: AllGrowlistsComponent;
  let fixture: ComponentFixture<AllGrowlistsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
    imports: [AllGrowlistsComponent, BrowserAnimationsModule],
    providers: [provideHttpClient(withInterceptorsFromDi()), provideHttpClientTesting()]
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
