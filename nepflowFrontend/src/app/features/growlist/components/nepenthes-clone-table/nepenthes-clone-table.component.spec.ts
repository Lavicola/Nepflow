import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NepenthesCloneTableComponent } from './nepenthes-clone-table.component';
import {HttpClientTestingModule} from "@angular/common/http/testing";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

describe('NepenthesCloneTableComponent', () => {
  let component: NepenthesCloneTableComponent;
  let fixture: ComponentFixture<NepenthesCloneTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NepenthesCloneTableComponent,HttpClientTestingModule,BrowserAnimationsModule]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NepenthesCloneTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
