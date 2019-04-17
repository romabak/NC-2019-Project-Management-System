import { Component, OnInit } from '@angular/core';
import {TaskStatusService} from "../services/task-status.service";
import {TaskStatus} from "../modules/models/task-status";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-project-page',
  templateUrl: './project-page.component.html',
  styleUrls: ['./project-page.component.css']
})
export class ProjectPageComponent implements OnInit {

  taskStatus: TaskStatus[];

  private subscriptions: Subscription[] = [];

  constructor(private taskStatusService: TaskStatusService) { }

  ngOnInit() {
    this.loadTaskStatus();
  }

  private loadTaskStatus(): void{
    this.subscriptions.push(this.taskStatusService.getStatus().subscribe(status=>{
      this.taskStatus = status as TaskStatus[];
    }));
  }
}
