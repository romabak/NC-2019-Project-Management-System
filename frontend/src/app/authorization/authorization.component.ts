import { Component, OnInit } from '@angular/core';
import { User } from '../../user';

@Component({
  selector: 'app-authorization',
  templateUrl: './authorization.component.html',
  styleUrls: ['./authorization.component.css']
})
export class AuthorizationComponent implements OnInit {

  user = new User('Roma', 'password', 'junior', 'Developer');
  constructor() { }

  ngOnInit() {
  }

}
