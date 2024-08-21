import {CanActivateFn} from '@angular/router';
import {from} from "rxjs";
import {inject} from "@angular/core";
import {AuthService} from "../services/auth.service";

export const firstStepGuard: CanActivateFn = (route, state) => {
  console.log("first step")
  return from(inject(AuthService).finishedFirstStep());
};
