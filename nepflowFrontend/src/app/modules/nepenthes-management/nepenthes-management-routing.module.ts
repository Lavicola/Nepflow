import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {NepenthesCloneDropdownComponent} from "./nepenthes-clone-dropdown/nepenthes-clone-dropdown.component";
import {NepenthesDropdownComponent} from "./nepenthes-dropdown/nepenthes-dropdown.component";
import {authGuardAuthenticated} from "../../guards/authGuardAuthenticated";
import {NepenthesCloneComponent} from "./nepenthes-clone/nepenthes-clone.component";
import {UserGrowlistComponent} from "./user-growlist/user-growlist.component";

const routes: Routes = [

  {path: "add",
    component: NepenthesCloneComponent,
    // canActivate: [authGuardAuthenticated]
  },

  {path: "growlist",
    component: UserGrowlistComponent,
    // canActivate: [authGuardAuthenticated]
  },

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class NepenthesManagementRoutingModule {
}
