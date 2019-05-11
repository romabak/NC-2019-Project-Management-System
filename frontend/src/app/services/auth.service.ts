import { Injectable } from '@angular/core';
import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CookieService } from 'ngx-cookie-service';


@Injectable({
  providedIn: 'root'
})
export class AuthService implements HttpInterceptor {

  constructor(private cookie: CookieService) { }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if (!this.cookie.check('token')) {
      request = request.clone({
        setHeaders: {
          Authorization: "Bearer " + this.cookie.get('token')
        }
      });
    }
    return next.handle(request);
	}
}
