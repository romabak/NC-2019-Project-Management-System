import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthorizationComponent } from './authorization/authorization.component';
import { ProjectPageComponent } from './project-page/project-page.component';
import { MainPageComponent } from './modules/layout/main-page/main-page.component';

const routes: Routes = [
  {path: '', component: AuthorizationComponent},
  {path: 'main', component: MainPageComponent},
  {path: 'project-page/:id', component: ProjectPageComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
  ],
  exports: [
    RouterModule
  ]
})

export class AppRoutingModule { }
