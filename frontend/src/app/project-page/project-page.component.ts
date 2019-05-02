import { Component, OnInit } from '@angular/core';
import {TaskStatusService} from "../services/task-status.service";
import {TaskStatus} from "../modules/models/task-status";
import {Subscription} from "rxjs";
import {TaskService} from "../services/task.service";
import {Task} from "../modules/models/task";
import {ActivatedRoute} from "@angular/router";
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import {TaskPriority} from "../modules/models/task-priority";
import {TaskPriorityService} from "../services/task-priority.service";

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
  disable : boolean = true;

  formControl: FormGroup;

  private subscriptions: Subscription[] = [];

  constructor(private taskStatusService: TaskStatusService,
              private taskPriorityService: TaskPriorityService,
              private taskService: TaskService,
              private route: ActivatedRoute,
              private fb: FormBuilder) { }

  ngOnInit() {
    this.loadTaskStatus();
    this.loadTask();
    this.initFormDisabled();
    this.loadTaskPriority();
  }

  initFormDisabled(){
    this.formControl = this.fb.group({
      priority: [''],
      status: [''],
      assignee: [''],
      reported: [''],
      estimation: ['']
    });
    this.formControl.disable();
  }

  public inableWriteMode(): void{
    this.formControl.enable();
  }

  private getId():void{
    this.sub = this.route.params.subscribe(params => {
      this.id = params['id'];
    });
  }

  private loadTask(): void{
    this.getId();
    this.subscriptions.push(this.taskService.getTaskById(this.id).subscribe(task=>{
      this.task = task as Task;
    }))
  }

  private loadTaskStatus(): void{
    this.subscriptions.push(this.taskStatusService.getStatus().subscribe(status=>{
      this.taskStatus = status as TaskStatus[];
    }));
  }

  private loadTaskPriority(): void{
    this.subscriptions.push(this.taskPriorityService.getPriority().subscribe(priority=>{
      this.taskPriority = priority as TaskPriority[];
    }))
  }

  private saveChanges(): void{
    this.subscriptions.push(this.taskService.saveNewTask(this.task).subscribe(()=>{
      this.formControl.disable();
    }))
  }
}
