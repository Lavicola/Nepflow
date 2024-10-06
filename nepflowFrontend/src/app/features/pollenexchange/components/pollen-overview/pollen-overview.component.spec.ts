import {ComponentFixture, TestBed} from '@angular/core/testing';

import {PollenOverviewComponent} from './pollen-overview.component';
import {provideHttpClientTesting} from "@angular/common/http/testing";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {provideHttpClient, withInterceptorsFromDi} from '@angular/common/http';

describe('OverviewComponent', () => {
  let component: PollenOverviewComponent;
  let fixture: ComponentFixture<PollenOverviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
    imports: [PollenOverviewComponent, BrowserAnimationsModule],
    providers: [provideHttpClient(withInterceptorsFromDi()), provideHttpClientTesting()]
})
    .compileComponents();

    fixture = TestBed.createComponent(PollenOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
