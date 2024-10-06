import {ComponentFixture, TestBed} from '@angular/core/testing';

import {FilterboxComponent} from './filterbox.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

describe('FilterboxComponent', () => {
  let component: FilterboxComponent;
  let fixture: ComponentFixture<FilterboxComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FilterboxComponent,BrowserAnimationsModule]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FilterboxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
