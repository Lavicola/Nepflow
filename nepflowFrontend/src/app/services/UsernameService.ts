import {Injectable} from "@angular/core";
import {AuthService} from "./AuthService";
import {Observable, Subject} from "rxjs";
import {UserDto} from "../modules/user-management/models/user-dto";

@Injectable({
  providedIn: 'root'
})
export class UsernameService {


  usernameSubject: Subject<string> = new Subject<string>();
  usernameObs: Observable<string> = this.usernameSubject.asObservable();

  constructor(private authService: AuthService) {
    this.authService.getUser().subscribe({
      next: (user: UserDto) => {
        if (user && user.username) {
          this.usernameSubject.next(user.username);
        }
      }
    })
  }


  getUsernameObs(): Observable<string> {
    return this.usernameObs;
  }


}
