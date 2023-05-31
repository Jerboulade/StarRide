import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainComponent } from './modules/main/main.component';
import { AuthComponent } from './shared/component/auth/auth.component';

const routes: Routes = [
  { path : '', loadChildren : () => import('./modules/main/main.module').then(m => m.MainModule)},
  { path : 'login', component : AuthComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
