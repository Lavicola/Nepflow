import { Injectable } from '@angular/core';
import { Location } from '@angular/common';
import { BehaviorSubject, lastValueFrom, Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';

const headers = new HttpHeaders().set('Accept', 'application/json');

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  $authenticationState = new BehaviorSubject<boolean>(false);

  constructor(private http: HttpClient, private location: Location) {
  }

  login(): void {
    location.href = `${location.origin}${this.location.prepareExternalUrl('oauth2/authorization/okta')}`;
  }

  logout(): void {
    this.http.post('/api/logout', {}, { withCredentials: true }).subscribe((response: any) => {
      location.href = response.logoutUrl;
    });
  }
}
