import { NgModule } from '@angular/core';
import { RouterModule, Routes} from "@angular/router";
import {AuthorizationComponent} from "./authorization/authorization.component";
import {ProjectPageComponent} from "./project-page/project-page.component";
import {HeaderComponent} from "./main-page/header/header.component";

const routes: Routes = [
  {path: '', component: AuthorizationComponent},
  {path: 'main', component: HeaderComponent},
  {path: 'project-page', component: ProjectPageComponent}
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
