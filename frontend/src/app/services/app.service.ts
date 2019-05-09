import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { OAuthService } from 'angular-oauth2-oidc';
import { Router } from '@angular/router';
import { LoginUser } from '../modules/models/login-user';
import { RequestOptions } from '@angular/http';
import { User } from '../modules/models/user';
import { CookieService } from 'ngx-cookie-service';


@Injectable({
  providedIn: 'root'
})
export class AppService {
  
  constructor(
    private router: Router, private http: HttpClient, private cookie: CookieService){}

  obtainAccessToken(loginData: LoginUser): Observable<LoginUser>{
    console.log(loginData);
    return this.http.post<LoginUser>('http://localhost:8081/token/generate-token', loginData);
  }

  saveToken(token){
    console.log("token = " + token.token);
    this.cookie.set('token', token);
    this.router.navigate(['main']);
  }

  // getResource(resourceUrl): Observable<User>{
    // var headers = new Headers({'Content-type': 'application/x-www-form-urlencoded; charset=utf-8',
    //   'Authorization': 'Bearer ' + this.cookie.get('access_token')});
    // var options = new RequestOptions({ headers: headers });
    // return this.http.get(resourceUrl);
  // }

  checkCredentials(){
    if (!this.cookie.check('token')){
      this.router.navigate(['login']);
    }
  }

  logout() {
    this.cookie.delete('token');
    this.router.navigate(['']);
  }
}
