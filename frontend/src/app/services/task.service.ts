import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Task} from '../modules/models/task';
import {Observable} from 'rxjs';

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

  getTaskByName(name: String): Observable<Task>{
    return this.http.get<Task>("/api/task" + name);
  }

  getTaskById(id: string): Observable<Task>{
    return this.http.get<Task>("/api/task/" + id);
  }

}
