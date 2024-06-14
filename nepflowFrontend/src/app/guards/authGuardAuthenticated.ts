import { CanActivateFn } from '@angular/router';
import {inject} from "@angular/core";
import {AuthService} from "../services/AuthService";
import {from} from "rxjs";

export const authGuardAuthenticated: CanActivateFn = (route, state) => {
  console.log("authGuardAuthenticated")

  return from(inject(AuthService).isAuthenticated());
};
