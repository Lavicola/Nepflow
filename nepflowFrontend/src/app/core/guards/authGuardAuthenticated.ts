import {CanActivateFn} from '@angular/router';
import {inject} from "@angular/core";
import {from} from "rxjs";
import {AuthService} from "../services/auth.service";

export const authGuardAuthenticated: CanActivateFn = (route, state) => {

  return from(inject(AuthService).isAuthenticated());
};
