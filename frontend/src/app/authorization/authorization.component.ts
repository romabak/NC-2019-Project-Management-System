import { Component, OnInit } from '@angular/core';
import { AppService } from '../services/app.service';
import { Subscription } from 'rxjs';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

import { UserService } from '../services/user.service';


@Component({
  selector: 'app-authorization',
  templateUrl: './authorization.component.html',
  styleUrls: ['./authorization.component.css']
})

export class AuthorizationComponent implements OnInit {

  public loginForm: FormGroup;
  public rememberMe:boolean = false;

  private subscriptions: Subscription[] = [];

  constructor(
    private userService:UserService,
    private authService: AppService, 
    private fb: FormBuilder
    ) { }

  ngOnInit() {
    this.initLoginForm();
    this.authService.checkCredentials();
  }

  login(){
    localStorage.setItem('rememberMe', JSON.stringify(this.rememberMe));
    this.authService.obtainAccessToken(this.loginForm.value);
  }

  logout(){
    this.authService.logout();
  }

  initLoginForm(){
 	this.loginForm = this.fb.group({
  		email: [''],
  		password: ['']
  	});
}

}
