import {TestBed} from '@angular/core/testing';

import {HeadersInterceptor} from './headers.interceptor';
import {HttpClientTestingModule} from "@angular/common/http/testing";

describe('HeadersInterceptor', () => {
  beforeEach(() => TestBed.configureTestingModule({
    providers: [
      HeadersInterceptor
      ],
    imports:[
      HttpClientTestingModule
    ]
  }));

  it('should be created', () => {
    const interceptor: HeadersInterceptor = TestBed.inject(HeadersInterceptor);
    expect(interceptor).toBeTruthy();
  });
});
