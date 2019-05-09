import { Component, OnInit } from '@angular/core';
import { LoginUser } from '../modules/models/login-user';
import { AppService } from '../services/app.service';
import { Subscription } from 'rxjs';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-authorization',
  templateUrl: './authorization.component.html',
  styleUrls: ['./authorization.component.css']
})
export class AuthorizationComponent implements OnInit {
  public isLoggedIn = false;

  public email: string;
  public password: string;

  public loginUser = {
  	'email': this.email,
  	'password': this.password
  }

  loginForm: FormGroup;

  private subscriptions: Subscription[] = [];

  constructor(private authService: AppService, private fb: FormBuilder) { }

  ngOnInit() {
    this.authService.checkCredentials();
    this.initLoginForm();
  }

  login(){
  	this.subscriptions.push(this.authService.obtainAccessToken(this.loginForm.value).subscribe(token=>{
  		console.log(token);
  		this.authService.saveToken(token);
  	}));
    console.log(this.loginForm.value);
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
