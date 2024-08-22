import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NepenthesCloneTableComponent } from './nepenthes-clone-table.component';
import { provideHttpClientTesting } from "@angular/common/http/testing";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { provideHttpClient, withInterceptorsFromDi } from '@angular/common/http';

describe('NepenthesCloneTableComponent', () => {
  let component: NepenthesCloneTableComponent;
  let fixture: ComponentFixture<NepenthesCloneTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
    imports: [NepenthesCloneTableComponent, BrowserAnimationsModule],
    providers: [provideHttpClient(withInterceptorsFromDi()), provideHttpClientTesting()]
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
