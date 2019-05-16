import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserDetailsComponent } from './user-details/user-details.component';
import { TaskTableComponent } from './task-table/task-table.component';
import { UserTableComponent } from './user-table/user-table.component';
import { AppRoutingModule } from '../../app-routing.module';
import { PopupModule } from './popup/popup.module';
import { NewProjectComponent } from './popup/new-project/new-project.component';
import { NgbModalModule, NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NewUserComponent } from './popup/new-user/new-user.component';
import { NewTaskComponent } from './popup/new-task/new-task.component';
import { FormsModule } from '@angular/forms';
import { ButtonsComponent } from './buttons/buttons.component';

@NgModule({
  declarations: [
    UserDetailsComponent,
    TaskTableComponent,
    UserTableComponent,
    ButtonsComponent
  ],
  exports: [
    TaskTableComponent,
    UserTableComponent,
    ButtonsComponent
  ],
  imports: [
    CommonModule,
    AppRoutingModule,
    PopupModule,
    NgbModalModule.forRoot(),
    NgbModule,
    FormsModule
  ],
  entryComponents:[
    NewProjectComponent,
    NewUserComponent,
    NewTaskComponent
  ],
  bootstrap:[
    TaskTableComponent,
    ButtonsComponent
  ]
})
export class MainPageModule { }
