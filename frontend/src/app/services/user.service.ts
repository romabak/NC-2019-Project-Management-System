import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {User} from "../modules/models/user";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  saveNewUser(user: User): Observable<User>{
    return this.http.post<User>("/api/user/", user);
  }

  getAllUsers(): Observable<User[]>{
    return this.http.get<User[]>("/api/user");
  }
}
