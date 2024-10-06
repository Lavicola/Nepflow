import {Injectable} from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HttpXsrfTokenExtractor} from '@angular/common/http';
import {Observable} from 'rxjs';


/**
 * Interceptor is necessary since openAPI use absolute URL,
 * but HttpXsrfInterceptor does not set cookie for absolute URLs
 * see: https://stackoverflow.com/questions/50510998/angular-6-does-not-add-x-xsrf-token-header-to-http-request
 *
 */

@Injectable()
export class HeadersInterceptor implements HttpInterceptor {



  constructor(private tokenService: HttpXsrfTokenExtractor) {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    const lcUrl = request.url.toLowerCase();
    // TODO how to use @Inject(XSRF_HEADER_NAME) private headerName: string) {} ?
    const HEADER_NAME = "X-XSRF-TOKEN"



    if (
      (request.method === 'POST' || request.method === 'PUT'|| request.method === 'DELETE' || request.method === 'PATCH' ) &&
      (lcUrl.startsWith('http://') ||
      lcUrl.startsWith('https://'))
    ) {
      const token = this.tokenService.getToken();

      if (token !== null && !request.headers.has(HEADER_NAME)) {
        request = request.clone({headers: request.headers.set(HEADER_NAME, token)});
      }

    }

    return next.handle(request);
  }
}
