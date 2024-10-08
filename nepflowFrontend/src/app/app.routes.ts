import {Routes} from '@angular/router';
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
import {UserStatisticsComponent} from "./features/user-management/components/user-statistics/user-statistics.component";
import {
  NepenthesQuickAddComponent
} from "./features/growlist/components/nepenthes-quick-add/nepenthes-quick-add.component";
import {
  TradeRatingsOverviewComponent
} from "./features/pollenexchange/components/trade-ratings-overview/trade-ratings-overview.component";
import {UserRatingsComponent} from "./features/pollenexchange/components/user-ratings/user-ratings.component";

export const routes: Routes = [

  { path: '',
    redirectTo: 'user/first-steps',
    pathMatch: 'full',
  },

  {path: "user/overview",component: UserStatisticsComponent},
  {path: "user/first-steps", component: UserFirstStepComponent,
  },
  {path: "nepenthes/quick/add", component: NepenthesQuickAddComponent,},

  {path: "nepenthes/guided/add", component: AddExistingNepenthesComponent,},

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
  {path: "trades/:status",
    component: TradeRatingsOverviewComponent,
    // canActivate: [authGuardAuthenticated]
  },
  {path: "user/ratings",
    component: UserRatingsComponent,
    // canActivate: [authGuardAuthenticated]
  },
  {path: "user/:username/ratings",
    component: UserRatingsComponent,
    // canActivate: [authGuardAuthenticated]
  },

];
