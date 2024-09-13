import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpecimenStatisticsComponent } from './specimen-statistics.component';

describe('SpecimenStatisticsComponent', () => {
  let component: SpecimenStatisticsComponent;
  let fixture: ComponentFixture<SpecimenStatisticsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SpecimenStatisticsComponent]
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
