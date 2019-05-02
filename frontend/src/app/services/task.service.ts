import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';

import { Task } from '../modules/models/task';
import { PageTask } from "../modules/models/page-task";

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor(private http : HttpClient) { }

  saveNewTask(task : Task) : Observable<Task>{
	  return this.http.post<Task>("/api/task", task);
	}

	getAllTasks(): Observable<Task[]>{
    return this.http.get<Task[]>("/api/task");
  }

  getTaskPage(page: number, size: number): Observable<PageTask>{
    return this.http.get<PageTask>("/api/task?page=" + page + "&size=" + size);
  }

  getTaskById(id: string): Observable<Task>{
    return this.http.get<Task>("/api/task/" + id);
  }
}
