import { Component, OnInit } from '@angular/core';
import {formatDate} from '@angular/common';
import { TaskStatusService } from '../services/task-status.service';
import { TaskStatus } from '../modules/models/task-status';
import { Subscription } from 'rxjs';
import { TaskService } from '../services/task.service';
import { Task } from '../modules/models/task';
import { ActivatedRoute, Router } from '@angular/router';
import { FormGroup, FormBuilder } from '@angular/forms';
import { TaskPriority } from '../modules/models/task-priority';
import { TaskPriorityService } from '../services/task-priority.service';
import { AppService } from '../services/app.service';

@Component({
  selector: 'app-project-page',
  templateUrl: './project-page.component.html',
  styleUrls: ['./project-page.component.css']
})
export class ProjectPageComponent implements OnInit {

  id: string;
  private sub: any;
  taskStatus: TaskStatus[];
  taskPriority: TaskPriority[];
  task: Task;
  disable: boolean = true;

  isStatus: Map<string, boolean> = new Map();
  isRole: Map<string, boolean> = new Map();

  formControl: FormGroup;

  private subscriptions: Subscription[] = [];

  constructor(private taskStatusService: TaskStatusService,
              private taskPriorityService: TaskPriorityService,
              private taskService: TaskService,
              private auth: AppService,
              private route: ActivatedRoute,
              private router: Router,
              private fb: FormBuilder) { }

  ngOnInit() {
    this.auth.checkCredentials(this.router.url);
    this.loadTaskStatus();
    this.initFormDisabled();
    this.loadTaskPriority();
    this.initRoleOfUser();
  }

  initFormDisabled() {
    this.formControl = this.fb.group({
      priority: [''],
      status: [''],
      assignee: [''],
      reported: [''],
      estimation: [''],
      description: ['']
    });
    this.formControl.disable();
  }

  public inableWriteMode(): void {
    this.formControl.enable();
    this.statusTask();
  }

  private statusTask(): void {
    for (const status of this.taskStatus) {
      status.status === this.task.status ? this.isStatus.set(status.status, true) : this.isStatus.set(status.status, false);
    }
  }

  private setId(): void {
    this.sub = this.route.params.subscribe(params => {
      this.id = params[ 'id' ];
    });
  }

  private loadTask(): void {
    this.setId();
    this.subscriptions.push(this.taskService.getTaskById(this.id).subscribe(task => {
      this.task = task as Task;
      this.statusTask();
    }));
  }

  private loadTaskStatus(): void {
    this.subscriptions.push(this.taskStatusService.getStatus().subscribe(status => {
      this.taskStatus = status as TaskStatus[];
      this.loadTask();
    }));
  }

  private loadTaskPriority(): void {
    this.subscriptions.push(this.taskPriorityService.getPriority().subscribe(priority => {
      this.taskPriority = priority as TaskPriority[];
    }));
  }

  public saveChanges(): void {
    this.subscriptions.push(this.taskService.saveNewTask(this.task).subscribe(() => {
      this.formControl.disable();
    }));
  }

  private changeStatus(status: string): void {
    console.log(formatDate(new Date(), 'yyyy-MM-dd', 'en'));
    this.isStatus.set(this.task.status, false);
    this.task.status = status;
    this.isStatus.set(this.task.status, true);
    if(this.task.status === 'closed') {
      this.task.closedDate = formatDate(new Date(), 'yyyy-MM-dd', 'en').toString();
    }
    this.saveChanges();
  }

  private initRoleOfUser(): void {
    if (JSON.parse(localStorage.getItem('rememberMe'))) {
        this.isRole.set(localStorage.getItem('role'), true);
    } else {  
      this.isRole.set(sessionStorage.getItem('role'), true);
    }
  }
}
