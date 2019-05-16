import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { FormBuilder, FormGroup, Validators } from '@angular/forms'
import { Project } from '../../../models/project';
import { Task } from '../../../models/task';
import { User } from '../../../models/user';
import { Subscription } from 'rxjs';
import { TaskPriority } from '../../../models/task-priority';
import { TaskPriorityService } from '../../../../services/task-priority.service';
import { ProjectService } from '../../../../services/project.service';
import { UserService } from '../../../../services/user.service';
import { TaskService } from '../../../../services/task.service';

@Component({
  selector: 'app-new-task',
  templateUrl: './new-task.component.html',
  styleUrls: ['./new-task.component.css']
})
export class NewTaskComponent implements OnInit {

  allProjects: Project[];
  allPriority: TaskPriority[];
  allUsers: User[];
  newTask: Task = new Task();
  private subscriptions: Subscription[] = [];

  public formControl: FormGroup;

  @Output() close: EventEmitter<any> = new EventEmitter();

  constructor(private activeModal: NgbActiveModal,
              private fb: FormBuilder,
              private priorityService: TaskPriorityService,
              private projectService: ProjectService,
              private userService: UserService,
              private taskService: TaskService) { }

  ngOnInit() {
    this.loadProjects();
    this.loadTaskPriority();
    this.loadUsers();
    this.initFormControl();
  }

  initFormControl(){
    this.formControl = this.fb.group({
      projectCode:['', Validators.required],
      name:['', Validators.required],
      description:['', Validators.required],
      priority:['', Validators.required],
      dueDate:['', Validators.required],
      estimation:['', Validators.required],
      assignee:['', Validators.required],
    })
  }

  private loadTaskPriority() : void{
    this.subscriptions.push(this.priorityService.getPriority().subscribe(priority=>{
      this.allPriority = priority as TaskPriority[];
    }));
  }

  private loadProjects() : void{
    this.subscriptions.push(this.projectService.getAllProject().subscribe( project=>{
      this.allProjects = project as Project[];
    }))
  }

  private loadUsers() : void{
    this.subscriptions.push(this.userService.getListOfDevelopersForCreateTask().subscribe( user=>{
      this.allUsers = user as User[];
    }));
  }

  public saveNewTask(){
    if(JSON.parse(localStorage.getItem('rememberMe'))){
      this.newTask.reporter = localStorage.getItem('email');
    } else {
      console.log('reporter = ' +  sessionStorage.getItem('email'));
      this.newTask.reporter = sessionStorage.getItem('email');
    }
    this.subscriptions.push(this.taskService.saveNewTask(this.newTask).subscribe(()=>{
      this.newTask = new Task();
      this.activeModal.close();
      this.close.emit(null);
    }))
  }


}
