import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NewTaskComponent } from './new-task/new-task.component';
import { NewProjectComponent } from './new-project/new-project.component';
import { NewUserComponent } from './new-user/new-user.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { NgbModalModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [NewTaskComponent, NewProjectComponent, NewUserComponent],
  imports: [
    CommonModule,
    FormsModule,
    NgbModalModule.forRoot(),
    ReactiveFormsModule
  ],
  exports:[
    NewProjectComponent,
    NewUserComponent,
    NewTaskComponent
  ]
})
export class PopupModule { }
