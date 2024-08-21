import { TestBed } from '@angular/core/testing';

import { UsermanagementService } from './usermanagement.service';
import {HttpClientTestingModule} from "@angular/common/http/testing";

describe('UsermanagementService', () => {
  let service: UsermanagementService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule]
    });
    service = TestBed.inject(UsermanagementService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
