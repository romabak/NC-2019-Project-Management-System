import { AppService } from '../../../services/app.service';
import { Component, OnInit, OnDestroy } from '@angular/core';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit, OnDestroy{

  public isAdmin:boolean = false;

  constructor(private auth: AppService) { }

  ngOnInit(){
  	this.checkUserRole();
  	this.auth.checkCredentials();
  }

  ngOnDestroy(){
    // if(JSON.parse(localStorage.getItem('rememberMe'))){
    //   this.auth.logout();
    // }
  }

  private checkUserRole(){
  	  if(localStorage.getItem('role') === 'admin' || sessionStorage.getItem('role') === 'admin'){
  		  this.isAdmin = true;
  	  } else {
        this.isAdmin = false;
      }
    }
  
}
