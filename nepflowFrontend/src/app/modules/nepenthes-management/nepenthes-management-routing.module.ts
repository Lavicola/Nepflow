import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {NepenthesCloneComponent} from "./nepenthes-clone/nepenthes-clone.component";
import {UserGrowlistComponent} from "./user-growlist/user-growlist.component";
import {AllUsersOverviewComponent} from "./all-users-overview/all-users-overview.component";
import {PollenOffersOverviewComponent} from "./pollen-offers-overview/pollen-offers-overview.component";

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
  {path: "users/growlist",
    component: AllUsersOverviewComponent,
    // canActivate: [authGuardAuthenticated]
  },
  {path: "pollenoffers",
    component: PollenOffersOverviewComponent,
    // canActivate: [authGuardAuthenticated]
  },


];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class NepenthesManagementRoutingModule {
}
