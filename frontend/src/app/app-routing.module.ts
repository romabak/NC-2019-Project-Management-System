import { NgModule } from '@angular/core';
import { HeaderComponent } from "./header/header.component";
import { RouterModule, Routes} from "@angular/router";
import {NewPojectComponent} from "./new-poject/new-poject.component";
import {NewUserComponent} from "./new-user/new-user.component";
import {NewTaskComponent} from "./new-task/new-task.component";

const routes: Routes = [
  {path: 'main', component: HeaderComponent},
  {path: 'new-project', component: NewPojectComponent},
  {path: 'new-user', component: NewUserComponent},
  {path: 'new-task', component: NewTaskComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})

export class AppRoutingModule { }
