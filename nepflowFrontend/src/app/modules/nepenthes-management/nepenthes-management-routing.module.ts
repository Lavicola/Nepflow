import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {NepenthesCloneDropdownComponent} from "./nepenthes-clone-dropdown/nepenthes-clone-dropdown.component";
import {NepenthesDropdownComponent} from "./nepenthes-dropdown/nepenthes-dropdown.component";

const routes: Routes = [

  {path: "add", component: NepenthesCloneDropdownComponent},

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class NepenthesManagementRoutingModule {
}
