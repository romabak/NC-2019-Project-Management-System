import { Component } from '@angular/core';
import {UserRole} from "../../modules/models/user-role";
import {Subscription} from "rxjs";
import {UserRoleService} from "../../services/user-role.service";
import {TaskPriority} from "../../modules/models/task-priority";
import {TaskPriorityService} from "../../services/task-priority.service";
import {User} from "../../modules/models/user";
import {UserService} from "../../services/user.service";
import {Project} from "../../modules/models/project";
import {ProjectService} from "../../services/project.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})


export class HeaderComponent {

  userRole: UserRole[];
  taskPriority: TaskPriority[];
  editableUser: User = new User();
  newProject: Project = new Project();
  private subscriptions: Subscription[] = [];


  constructor(private userRoleService: UserRoleService,
              private taskPriorityService: TaskPriorityService,
              private userService: UserService,
              private projectService: ProjectService) { }

  public ngOnInit(){
    this.loadUserRole();
    this.loadTaskPriority();
  }

  private loadUserRole() : void {
    this.subscriptions.push(this.userRoleService.getUserRole().subscribe(role => {
      this.userRole = role as UserRole[];
    }));
  }

  private loadTaskPriority() : void{
      this.subscriptions.push(this.taskPriorityService.getPriority().subscribe(priority=>{
        this.taskPriority = priority as TaskPriority[];
      }));
  }

  private saveNewUser(){
    this.subscriptions.push(this.userService.saveNewUser(this.editableUser).subscribe(()=>{
    }))
  }

  private saveNewProject(){
    this.subscriptions.push(this.projectService.saveNewProject(this.newProject).subscribe());
  }
}
