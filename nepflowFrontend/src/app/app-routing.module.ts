import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {UserOverviewComponent} from "./user-overview/user-overview.component";
import {NepenthesOverviewComponent} from "./nepenthes-overview/nepenthes-overview.component";

const routes: Routes = [

  { path: '', redirectTo: 'user/profile', pathMatch: 'full' },

  {path: "user/profile", component: UserOverviewComponent},
  {path: "user/:name/profile", component: UserOverviewComponent},

  {path: "user/profile/nepenthes", component: NepenthesOverviewComponent},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
