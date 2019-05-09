import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Project } from '../modules/models/project';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  constructor( private http: HttpClient) { }

  getAllProject(): Observable<Project[]> {
    return this.http.get<Project[]>('/api/project');
  }

  saveNewProject(project: Project): Observable<Project> {
    return this.http.post<Project>('/api/project', project);
  }
}
