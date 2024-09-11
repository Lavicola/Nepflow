import { Routes } from '@angular/router';
import {UserFirstStepComponent} from "./features/user-management/components/user-first-step/user-first-step.component";
import {
  AddExistingNepenthesComponent
} from "./features/growlist/components/add-existing-nepenthes/add-existing-nepenthes.component";
import {PollenOverviewComponent} from "./features/pollenexchange/components/pollen-overview/pollen-overview.component";
import {UserGrowlistComponent} from "./features/growlist/components/user-growlist/user-growlist.component";
import {AllGrowlistsComponent} from "./features/growlist/components/all-growlists/all-growlists.component";
import {
  UserTradesOverviwComponent
} from "./features/pollenexchange/components/user-trades-overviw/user-trades-overviw.component";

export const routes: Routes = [

  {path: "first-steps", component: UserFirstStepComponent},

  {path: "nepenthes/add",
    component: AddExistingNepenthesComponent,
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
    component: AllGrowlistsComponent,
    // canActivate: [authGuardAuthenticated]
  },
  {path: "pollenoffers",
    component: PollenOverviewComponent,
    // canActivate: [authGuardAuthenticated]
  },
  {path: "trades/:status",
    component: UserTradesOverviwComponent,
    // canActivate: [authGuardAuthenticated]
  },
  {path: "trades/:status",
    component: UserTradesOverviwComponent,
    // canActivate: [authGuardAuthenticated]
  },

];
