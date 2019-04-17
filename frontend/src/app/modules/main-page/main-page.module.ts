import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserDetailsComponent } from './user-details/user-details.component';
import { TaskTableComponent } from './task-table/task-table.component';
import { UserTableComponent } from './user-table/user-table.component';

@NgModule({
  declarations: [UserDetailsComponent, TaskTableComponent, UserTableComponent],
  imports: [
    CommonModule
  ]
})
export class MainPageModule { }
