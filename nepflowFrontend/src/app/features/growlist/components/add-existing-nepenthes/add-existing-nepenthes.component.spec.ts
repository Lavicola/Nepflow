import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddExistingNepenthesComponent } from './add-existing-nepenthes.component';
import { provideHttpClientTesting } from "@angular/common/http/testing";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { provideHttpClient, withInterceptorsFromDi } from '@angular/common/http';

describe('AddExistingNepenthesComponent', () => {
  let component: AddExistingNepenthesComponent;
  let fixture: ComponentFixture<AddExistingNepenthesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
    imports: [AddExistingNepenthesComponent, BrowserAnimationsModule],
    providers: [provideHttpClient(withInterceptorsFromDi()), provideHttpClientTesting()]
})
    .compileComponents();

    fixture = TestBed.createComponent(AddExistingNepenthesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
