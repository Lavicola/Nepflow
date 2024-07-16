import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {NepenthesCloneComponent} from "./nepenthes-clone/nepenthes-clone.component";
import {UserGrowlistComponent} from "./user-growlist/user-growlist.component";

const routes: Routes = [

  {path: "nepenthes/add",
    component: NepenthesCloneComponent,
    // canActivate: [authGuardAuthenticated]
  },

  {path: "growlist/:user",
    component: UserGrowlistComponent,
    // canActivate: [authGuardAuthenticated]
  },
  {path: "growlist",
    component: UserGrowlistComponent,
    // canActivate: [authGuardAuthenticated]
  },

 // {path: "users/growlist",
 //   component: PublicUsersGrowlistComponent,
    // canActivate: [authGuardAuthenticated]
 // },


];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class NepenthesManagementRoutingModule {
}
