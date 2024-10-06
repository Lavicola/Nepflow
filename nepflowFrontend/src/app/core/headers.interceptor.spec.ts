import {TestBed} from '@angular/core/testing';

import {HeadersInterceptor} from './headers.interceptor';
import {provideHttpClientTesting} from "@angular/common/http/testing";
import {provideHttpClient, withInterceptorsFromDi} from '@angular/common/http';

describe('HeadersInterceptor', () => {
  beforeEach(() => TestBed.configureTestingModule({
    imports: [],
    providers: [
        HeadersInterceptor,
        provideHttpClient(withInterceptorsFromDi()),
        provideHttpClientTesting()
    ]
}));

  it('should be created', () => {
    const interceptor: HeadersInterceptor = TestBed.inject(HeadersInterceptor);
    expect(interceptor).toBeTruthy();
  });
});
