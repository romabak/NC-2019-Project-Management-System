import { Component, OnInit } from '@angular/core';
import { UserService } from '../../../services/user.service';
import { AppService } from '../../../services/app.service';
import { User } from '../../models/user';
import { Subscription } from 'rxjs';
import { PageTask } from '../../models/page-task';
import { PageUser } from '../../models/page-user';

@Component({
  selector: 'app-user-table',
  templateUrl: './user-table.component.html',
  styleUrls: ['./user-table.component.css']
})
export class UserTableComponent implements OnInit {

  allUsers: User[];
  public users: PageUser;
  public page = 1;
  public pageSize: number = 5;
  public filter: string = null;
  private subscriptions: Subscription[] = [];

  constructor(private userService: UserService,
              private auth: AppService) { }

  ngOnInit() {
    this.loadPageForTables(this.page);
  }

  private loadUsers(): void {
    this.subscriptions.push(this.userService.getAllUsers().subscribe( user => {
      this.allUsers = user as User[];
    }));
  }

  private  loadPageForTables($event: number): void {
    this.subscriptions.push(this.userService.getUserPage($event - 1, this.pageSize, this.filter).subscribe(user=>{
        this.users = user as PageUser;
        this.page = $event;
    }));
  }

  public deleteUser(id: string): void {
    this.subscriptions.push(this.userService.deleteUser(id).subscribe(() => {
      this.loadPageForTables(this.page);
    }));
  }
}
