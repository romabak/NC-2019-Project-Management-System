import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { LoginUser } from '../modules/models/login-user';
import { User } from '../modules/models/user';
import { Token } from '../modules/models/token';
import { CookieService } from 'ngx-cookie-service';
import { Subscription } from 'rxjs';
import { UserService } from './user.service';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class AppService {

  private subscriptions: Subscription[] = [];

  constructor(
    private router: Router, 
    private http: HttpClient, 
    private cookie: CookieService,
    private userService: UserService
    ){}

  public obtainAccessToken(loginData: LoginUser){
     this.subscriptions.push(
      this.http.post<any>('/api/token/generate-token', loginData).subscribe(token=>{
         this.userService.getUserByEmail(loginData.email).subscribe(user => {
          this.saveUserInfo(user, token);
        });
      }));
  }

  private saveUserInfo(user: User, token: Token){
    if(JSON.parse(localStorage.getItem('rememberMe'))){
      localStorage.setItem('email', user.email);
      localStorage.setItem('role', user.role.role);
      this.cookie.set('token', token.token, 365);
    } else {
      sessionStorage.setItem('email', user.email);
      sessionStorage.setItem('role', user.role.role);
      this.cookie.set('token', token.token);
    }
    this.router.navigate(['main']);
  }

  checkCredentials(path: string) {
    if (!this.cookie.check('token') || !(localStorage.getItem('email') || sessionStorage.getItem('email'))){
        this.cookie.deleteAll();
        this.router.navigate(['']);
    } else{
      this.router.navigate([path]);
    }
  }

  logout() {
    this.cookie.delete('token');
    localStorage.clear();
    sessionStorage.clear();      
    this.router.navigate(['']);
  }
}
