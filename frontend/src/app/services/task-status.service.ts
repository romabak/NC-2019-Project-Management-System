import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {TaskStatus} from "../modules/models/task-status";

@Injectable({
  providedIn: 'root'
})
export class TaskStatusService {

  constructor(private http: HttpClient) { }

  getStatus(): Observable<TaskStatus[]>{
    return this.http.get<TaskStatus[]>("/api/status");
  }
}
