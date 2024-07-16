import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {UserFirstStepComponent} from './user-first-step/user-first-step.component';
import {UserOverviewComponent} from './user-overview/user-overview.component';

const routes: Routes = [
  {path: "overview", component: UserOverviewComponent},
  {path: "first-steps", component: UserFirstStepComponent}

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserManagementRoutingModule { }
