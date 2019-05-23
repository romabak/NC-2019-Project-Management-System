import { Component, OnInit } from '@angular/core';
import { AppService } from '../services/app.service';
import { Subscription } from 'rxjs';
import { first } from 'rxjs/operators';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

import { UserService } from '../services/user.service';


@Component({
  selector: 'app-authorization',
  templateUrl: './authorization.component.html',
  styleUrls: ['./authorization.component.css']
})

export class AuthorizationComponent implements OnInit {

  public loginForm: FormGroup;
  public rememberMe: boolean = false;
  public submitted = false;

  private subscriptions: Subscription[] = [];

  constructor(
    private userService: UserService,
    private authService: AppService,
    private fb: FormBuilder
    ) { }

  ngOnInit() {
    this.initLoginForm();
    this.authService.checkCredentials('/main');
  }

  public login() {
    localStorage.setItem('rememberMe', JSON.stringify(this.rememberMe));
    this.authService.obtainAccessToken(this.loginForm.value);
  }

  public logout() {
    this.authService.logout();
  }

  private initLoginForm() {
 	this.loginForm = this.fb.group({
  		email: ['', Validators.required, Validators.email],
  		password: ['']
  	});
  }

  get f() { return this.loginForm.controls; }

  onSubmit(){
    this.submitted = true;

    if(this.loginForm.invalid) {
      return;
    }
  }

}
