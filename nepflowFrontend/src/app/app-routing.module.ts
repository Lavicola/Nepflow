import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

const routes: Routes = [


  { path: '',
    redirectTo: '/user/first-steps',
    pathMatch: 'full' }, // Redirect empty path to /user
  { path: '',
    loadChildren: () => import('./modules/nepenthes-management/nepenthes-management.module').then(m => m.NepenthesManagementModule) ,
  //  canActivate: [authGuardAuthenticated,firstStepGuard]

  },
  { path: 'user', loadChildren: () => import('./modules/user-management/user-management.module').then(m => m.UserManagementModule) },



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
