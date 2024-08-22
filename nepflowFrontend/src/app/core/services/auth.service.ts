import { Injectable } from '@angular/core';
import {Location} from '@angular/common';
import {BehaviorSubject, lastValueFrom, map, Observable} from "rxjs";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import {UserDto} from "../models/user-dto";

const headers = new HttpHeaders().set('Accept', 'application/json');


@Injectable({
  providedIn: 'root'
})
export class AuthService {
  $authenticationState = new BehaviorSubject<boolean>(false);

  constructor(private http: HttpClient, private location: Location) {
  }

  getUser(): Observable<UserDto> {
    return this.http.get<UserDto>('/api/user', { headers },)
      .pipe(map((response: UserDto) => {
          if (response !== null) {
            this.$authenticationState.next(true);
          }
          return response;
        })
      );
  }


  async isAuthenticated(): Promise<boolean> {
    const user = await lastValueFrom(this.getUser());
    return user !== null;
  }
  async finishedFirstStep(): Promise<boolean> {
    const user = await lastValueFrom(this.getUser());
    return user.contactInformation !== null &&user.contactInformation !== "";
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
