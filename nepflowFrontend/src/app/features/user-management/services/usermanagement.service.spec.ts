import { TestBed } from '@angular/core/testing';

import { UsermanagementService } from './usermanagement.service';
import { provideHttpClientTesting } from "@angular/common/http/testing";
import { provideHttpClient, withInterceptorsFromDi } from '@angular/common/http';

describe('UsermanagementService', () => {
  let service: UsermanagementService;

  beforeEach(() => {
    TestBed.configureTestingModule({
    imports: [],
    providers: [provideHttpClient(withInterceptorsFromDi()), provideHttpClientTesting()]
});
    service = TestBed.inject(UsermanagementService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
