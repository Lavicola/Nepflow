import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HybridCloneComponent } from './hybrid-clone.component';

describe('HybridCloneComponent', () => {
  let component: HybridCloneComponent;
  let fixture: ComponentFixture<HybridCloneComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HybridCloneComponent]
    });
    fixture = TestBed.createComponent(HybridCloneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
