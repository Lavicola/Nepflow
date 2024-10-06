import {ComponentFixture, TestBed} from '@angular/core/testing';

import {SpecimenStatisticsComponent} from './specimen-statistics.component';
import {provideHttpClient, withInterceptorsFromDi} from "@angular/common/http";
import {provideHttpClientTesting} from "@angular/common/http/testing";

describe('SpecimenStatisticsComponent', () => {
  let component: SpecimenStatisticsComponent;
  let fixture: ComponentFixture<SpecimenStatisticsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SpecimenStatisticsComponent],
      providers: [provideHttpClient(withInterceptorsFromDi()), provideHttpClientTesting()]

    })
    .compileComponents();

    fixture = TestBed.createComponent(SpecimenStatisticsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
