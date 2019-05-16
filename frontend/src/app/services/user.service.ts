import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { User } from "../modules/models/user";
import { Observable } from "rxjs";
import { PageTask } from "../modules/models/page-task";
import { PageUser } from "../modules/models/page-user";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  saveNewUser(user: User): Observable<User>{
    return this.http.post<User>('/api/user', user);
  }

  getUserById(id: string): Observable<User>{
  	return this.http.get<User>('/api/user/' + id);
  }

  getUserByEmail(email: string): Observable<User>{
  	return this.http.get<User>('/api/user/' + email);
  }

  getAllUsers(): Observable<User[]>{
    return this.http.get<User[]>('/api/user');
  }

  getUserPage(page: number, size: number): Observable<PageUser> {
    return this.http.get<PageUser>('/api/user?page=' + page + '&size=' + size);
  }

  deleteUser(id: string): Observable<User>{
    return this.http.delete<User>('/api/user/' + id);
  }

  getListOfDevelopersForCreateTask(){
    return this.http.get<User[]>('/api/user/dev');
  }
}

