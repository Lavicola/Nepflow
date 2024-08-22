import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NepenthesDropdownComponent } from './nepenthes-dropdown.component';
import { provideHttpClientTesting } from "@angular/common/http/testing";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { provideHttpClient, withInterceptorsFromDi } from '@angular/common/http';

describe('NepenthesDropdownComponent', () => {
  let component: NepenthesDropdownComponent;
  let fixture: ComponentFixture<NepenthesDropdownComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
    imports: [NepenthesDropdownComponent, BrowserAnimationsModule],
    providers: [provideHttpClient(withInterceptorsFromDi()), provideHttpClientTesting()]
})
    .compileComponents();

    fixture = TestBed.createComponent(NepenthesDropdownComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
