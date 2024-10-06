import {ComponentFixture, TestBed} from '@angular/core/testing';

import {NepenthesCardDropdownComponent} from './nepenthes-card-dropdown.component';
import {provideHttpClient, withInterceptorsFromDi} from "@angular/common/http";
import {provideHttpClientTesting} from "@angular/common/http/testing";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

describe('NepenthesCardDropdownComponent', () => {
  let component: NepenthesCardDropdownComponent;
  let fixture: ComponentFixture<NepenthesCardDropdownComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NepenthesCardDropdownComponent,BrowserAnimationsModule],
      providers: [provideHttpClient(withInterceptorsFromDi()), provideHttpClientTesting()]

    })
    .compileComponents();

    fixture = TestBed.createComponent(NepenthesCardDropdownComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
