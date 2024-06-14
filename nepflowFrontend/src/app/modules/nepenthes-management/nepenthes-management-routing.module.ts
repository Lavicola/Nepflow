import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {NepenthesCloneDropdownComponent} from "./nepenthes-clone-dropdown/nepenthes-clone-dropdown.component";
import {NepenthesDropdownComponent} from "./nepenthes-dropdown/nepenthes-dropdown.component";
import {authGuardAuthenticated} from "../../guards/authGuardAuthenticated";

const routes: Routes = [

  {path: "add",
  component: NepenthesCloneDropdownComponent,
 // canActivate: [authGuardAuthenticated]
  },

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class NepenthesManagementRoutingModule {
}
