import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NewTaskComponent } from './new-task/new-task.component';
import { NewProjectComponent } from './new-project/new-project.component';
import { NewUserComponent } from './new-user/new-user.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { NgbModalModule } from '@ng-bootstrap/ng-bootstrap';
import { SelectDropDownModule } from 'ngx-select-dropdown';

@NgModule({
  declarations: [NewTaskComponent, NewProjectComponent, NewUserComponent],
  imports: [
    CommonModule,
    FormsModule,
    SelectDropDownModule,
    NgbModalModule.forRoot(),
    ReactiveFormsModule.withConfig({warnOnNgModelWithFormControl: 'never'})
  ],
  exports:[
    NewProjectComponent,
    NewUserComponent,
    NewTaskComponent
  ]
})
export class PopupModule { }
