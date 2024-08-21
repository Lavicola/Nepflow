import {CanActivateFn} from '@angular/router';
import {inject} from "@angular/core";
import {from} from "rxjs";
import {AuthService} from "../services/auth.service";

export const authGuardAuthenticated: CanActivateFn = (route, state) => {
  console.log("authGuardAuthenticated")

  return from(inject(AuthService).isAuthenticated());
};
