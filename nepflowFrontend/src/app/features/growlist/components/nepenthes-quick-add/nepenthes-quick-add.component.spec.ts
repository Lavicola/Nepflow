import {ComponentFixture, TestBed} from '@angular/core/testing';

import {NepenthesQuickAddComponent} from './nepenthes-quick-add.component';
import {provideHttpClient, withInterceptorsFromDi} from "@angular/common/http";
import {provideHttpClientTesting} from "@angular/common/http/testing";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

describe('NepenthesQuickAddComponent', () => {
  let component: NepenthesQuickAddComponent;
  let fixture: ComponentFixture<NepenthesQuickAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NepenthesQuickAddComponent, BrowserAnimationsModule],
      providers: [provideHttpClient(withInterceptorsFromDi()), provideHttpClientTesting()]

    })
      .compileComponents();

    fixture = TestBed.createComponent(NepenthesQuickAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
