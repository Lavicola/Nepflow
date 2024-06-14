import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {SpecimenAddComponent} from "./specimen-add/specimen-add.component";

const routes: Routes = [

  {
    path: "nepenthes", component:SpecimenAddComponent
  }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class GrowlistManagementRoutingModule { }
