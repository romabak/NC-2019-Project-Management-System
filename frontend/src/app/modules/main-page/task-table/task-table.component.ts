import { Component, OnInit } from '@angular/core';
import {TaskService} from "../../../services/task.service";
import {Subscription} from "rxjs";
import {Task} from "../../models/task";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {NewProjectComponent} from "../popup/new-project/new-project.component";
import {NewTaskComponent} from "../popup/new-task/new-task.component";
import {NewUserComponent} from "../popup/new-user/new-user.component";

const MODALS = {
  project: NewProjectComponent,
  task: NewTaskComponent,
  user: NewUserComponent,
};

@Component({
  selector: 'app-task-table',
  templateUrl: './task-table.component.html',
  styleUrls: ['./task-table.component.css']
})

export class TaskTableComponent implements OnInit {

  public tasks: Task[];
  private subscriptions: Subscription[] = [];

  constructor(private taskService: TaskService,
              private modalService: NgbModal) { }

  ngOnInit() {
    this.loadTasks();
  }

  open(name: string) {
    this.modalService.open(MODALS[name]);
  }

  private loadTasks(): void{
    this.subscriptions.push(this.taskService.getAllTasks().subscribe( task=>{
      this.tasks = task as Task[];
    }))
  }

}
