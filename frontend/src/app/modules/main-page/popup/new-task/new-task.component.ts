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
  assigneeUser:User;
  dataModel: any;
  private subscriptions: Subscription[] = [];

  public formControl: FormGroup;

  config = {
        displayKey:"firstName", //if objects array passed which key to be displayed defaults to description
        search:true, //true/false for the search functionlity defaults to false,
        height: 'auto', //height of the list so that if there are more no of items it can show a scroll defaults to auto. With auto height scroll will never appear
        placeholder:'Select', // text to be displayed when no item is selected defaults to Select,
        customComparator: ()=>{}, // a custom function using which user wants to sort the items. default is undefined and Array.sort() will be used in that case,
        // limitTo: this.allUsers.length, // a number thats limits the no of options displayed in the UI similar to angular's limitTo pipe
        moreText: 'more', // text to be displayed whenmore than one items are selected like Option 1 + 5 more
        noResultsFound: 'No results found!', // text to be displayed when no items are found while searching
        searchPlaceholder:'Search', // label thats displayed in search input,
        searchOnKey: 'firstName', // key on which search should be performed this will be selective search. if undefined this will be extensive search on all keys
      };

  // @Output() close: EventEmitter<any> = new EventEmitter();

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

  initFormControl() {
    this.formControl = this.fb.group({
      project:['', Validators.required],
      name:['', Validators.required],
      priority:['', Validators.required],
      dueDate:['', Validators.required],
      estimation:['', Validators.required],
      assignee:['', Validators.required]
    });
  }

  private addNewTask() {
   this.newTask = new Task(this.formControl.value);
   console.log(JSON.stringify(this.formControl.value));
  }

  private loadTaskPriority(): void {
    this.subscriptions.push(this.priorityService.getPriority().subscribe(priority=>{
      this.allPriority = priority as TaskPriority[];
    }));
  }

  private loadProjects(): void {
    this.subscriptions.push(this.projectService.getAllProject().subscribe( project=>{
      this.allProjects = project as Project[];
    }));
  }

  private loadUsers(): void {
    this.subscriptions.push(this.userService.getListOfDevelopersForCreateTask().subscribe( user=>{
      this.allUsers = user as User[];
    }));
  }

  selectionChanged($event) {
      console.log($event);
  }

  public saveNewTask() {
    this.addNewTask();
    this.newTask.reporter = new User();
    if (JSON.parse(localStorage.getItem('rememberMe'))) {
      this.newTask.reporter.email = localStorage.getItem('email');
    } else {
      this.newTask.reporter.email = sessionStorage.getItem('email');
    }
    this.subscriptions.push(this.taskService.saveNewTask(this.newTask).subscribe(() => {
      this.newTask = new Task();
      this.activeModal.close();
    }));
  }


}
