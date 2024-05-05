import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {UserOverviewComponent} from "./user-overview/user-overview.component";
import {NepenthesOverviewComponent} from "./nepenthes-overview/nepenthes-overview.component";
import {NepenthesAddComponent} from "./nepenthes-add/nepenthes-add.component";
import {CloneComponent} from "./clone/clone.component";
import {UserCloneAddComponent} from "./user-clone-add/user-clone-add.component";

const routes: Routes = [

  { path: '', redirectTo: 'user/profile', pathMatch: 'full' },
  {path: "nepenthes/add", component: NepenthesAddComponent},
  {path: "nepenthes/clone/add", component: CloneComponent},

  {path: "user/profile", component: UserOverviewComponent},
  {path: "user/nepenthes/add", component: UserCloneAddComponent},

  {path: "user/:name/profile", component: UserOverviewComponent},

  {path: "user/profile/nepenthes", component: NepenthesOverviewComponent},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
