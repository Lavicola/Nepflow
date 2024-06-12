import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: 'nepenthes', loadChildren: () => import('./modules/nepenthes-management/nepenthes-management.module').then(m => m.NepenthesManagementModule) },
  //{ path: 'growlist', loadChildren: () => import('./modules/growlist-management/growlist-management.module').then(m => m.GrowlistManagementModule) },



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
