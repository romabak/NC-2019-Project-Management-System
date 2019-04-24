import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserDetailsComponent } from './user-details/user-details.component';
import { TaskTableComponent } from './task-table/task-table.component';
import { UserTableComponent } from './user-table/user-table.component';
import {AppRoutingModule} from "../../app-routing.module";
import {PopupModule} from "./popup/popup.module";
import {NewProjectComponent} from "./popup/new-project/new-project.component";
import {NgbModalModule} from "@ng-bootstrap/ng-bootstrap";
import {NewUserComponent} from "./popup/new-user/new-user.component";
import {NewTaskComponent} from "./popup/new-task/new-task.component";

@NgModule({
  declarations: [
    UserDetailsComponent,
    TaskTableComponent,
    UserTableComponent
  ],
  exports: [
    TaskTableComponent
  ],
  imports: [
    CommonModule,
    AppRoutingModule,
    PopupModule,
    NgbModalModule.forRoot()
  ],
  entryComponents:[
    NewProjectComponent,
    NewUserComponent,
    NewTaskComponent
  ]
})
export class MainPageModule { }
