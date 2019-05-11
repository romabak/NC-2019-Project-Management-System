import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { OAuthService } from 'angular-oauth2-oidc';
import { Router } from '@angular/router';
import { LoginUser } from '../modules/models/login-user';
import { RequestOptions } from '@angular/http';
import { User } from '../modules/models/user';
import { Token } from '../modules/models/token';
import { CookieService } from 'ngx-cookie-service';


@Injectable({
  providedIn: 'root'
})
export class AppService {
  
  readonly httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Authorization': 'my-auth-token'
  })
};

  readonly options = {
        headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'Bearer'
      })
        // "observe": "response", // to display the full response
        // "responseType": "json"
    };

  constructor(
    private router: Router, private http: HttpClient, private cookie: CookieService){}

  obtainAccessToken(loginData: LoginUser): Observable<Token>{
    return this.http.post<Token>("http://<localhost:8081></localhost:8081>/token/generate-token", loginData, this.options);
  }

  saveToken(token){
    this.cookie.set('token', token.token);
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
