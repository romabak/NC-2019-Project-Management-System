import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';

import { Task } from '../modules/models/task';
import { PageTask } from '../modules/models/page-task';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor(private http: HttpClient) { }

  saveNewTask(task: Task): Observable<Task> {
    return this.http.post<Task>('/api/task', task);
  }

  getAllTasks(): Observable<Task[]> {
    return this.http.get<Task[]>('/api/task');
  }

  getTaskPage(page: number, size: number, filter: string): Observable<PageTask> {
    var email = JSON.parse(localStorage.getItem('rememberMe')) ? localStorage.getItem('email') : sessionStorage.getItem('email');
    var role = JSON.parse(localStorage.getItem('rememberMe')) ? localStorage.getItem('role') : sessionStorage.getItem('role');
    if (filter === null || filter === '' ) {
      return this.http.get<PageTask>('/api/task/' + email + '?page=' + page + '&size=' + size + '&role=' + role);
    } else {
      return this.http.get<PageTask>('/api/task/' + email + '?page=' + page + '&size=' + size + '&filter=' + filter + '&role=' + role);
    }
  }

  getTaskById(id: string): Observable<Task> {
    return this.http.get<Task>('/api/task/' + id);
  }
}
