import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpecimenAddComponent } from './specimen-add.component';

describe('SpecimenAddComponent', () => {
  let component: SpecimenAddComponent;
  let fixture: ComponentFixture<SpecimenAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [SpecimenAddComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SpecimenAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
