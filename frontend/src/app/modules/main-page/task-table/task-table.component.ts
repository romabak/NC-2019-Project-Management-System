import { Component, OnInit } from '@angular/core';
import { TaskService } from '../../../services/task.service';
import { Subscription } from 'rxjs';
import { Task } from '../../models/task';
import { NgbModal, NgbPaginationModule } from '@ng-bootstrap/ng-bootstrap';
import { NewProjectComponent } from '../popup/new-project/new-project.component';
import { NewTaskComponent } from '../popup/new-task/new-task.component';
import { NewUserComponent } from '../popup/new-user/new-user.component';
import { PageTask } from '../../models/page-task';
import { AppService } from '../../../services/app.service';

@Component({
  selector: 'app-task-table',
  templateUrl: './task-table.component.html',
  styleUrls: ['./task-table.component.css']
})

export class TaskTableComponent implements OnInit {


  public tasks: PageTask;
  public page = 1;
  public pageSize: number = 5;
  private subscriptions: Subscription[] = [];
  sorting = ['projectCode', 'ticketCode'];
  public typeInput = 'date';

  constructor(private taskService: TaskService,
              private auth: AppService) { }

  ngOnInit() {
    this.loadPageTasks(this.page);
  }

  public loadPageTasks($event: number): void {
    this.subscriptions.push(this.taskService.getTaskPage($event - 1, this.pageSize).subscribe( task => {
      this.tasks = task as PageTask;
    }, err=>{
      console.log('error in task-tableCompnent');
    }));
  }

  public logout(): void{
    this.auth.logout();
  }

}
