import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {NepenthesCloneDropdownComponent} from "./nepenthes-clone-dropdown/nepenthes-clone-dropdown.component";
import {NepenthesDropdownComponent} from "./nepenthes-dropdown/nepenthes-dropdown.component";
import {authGuardAuthenticated} from "../../guards/authGuardAuthenticated";
import {NepenthesCloneComponent} from "./nepenthes-clone/nepenthes-clone.component";

const routes: Routes = [

  {path: "add",
    component: NepenthesCloneDropdownComponent,
    // canActivate: [authGuardAuthenticated]
  },
  {path: "test",
    component: NepenthesCloneComponent,
    // canActivate: [authGuardAuthenticated]
  },

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class NepenthesManagementRoutingModule {
}
