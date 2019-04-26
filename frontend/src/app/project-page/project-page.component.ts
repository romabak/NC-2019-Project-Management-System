import { Component, OnInit } from '@angular/core';
import {TaskStatusService} from "../services/task-status.service";
import {TaskStatus} from "../modules/models/task-status";
import {Subscription} from "rxjs";
import {TaskService} from "../services/task.service";
import {Task} from "../modules/models/task";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-project-page',
  templateUrl: './project-page.component.html',
  styleUrls: ['./project-page.component.css']
})
export class ProjectPageComponent implements OnInit {

  id: string;
  private sub: any;
  taskStatus: TaskStatus[];
  task: Task;

  private subscriptions: Subscription[] = [];

  constructor(private taskStatusService: TaskStatusService,
              private taskService: TaskService,
              private route: ActivatedRoute
              ) { }

  ngOnInit() {
    this.loadTaskStatus();
    this.loadTask();
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
}
