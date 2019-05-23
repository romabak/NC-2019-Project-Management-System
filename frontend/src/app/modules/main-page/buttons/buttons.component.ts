import { Component, OnInit } from '@angular/core';
import { NewProjectComponent } from '../popup/new-project/new-project.component';
import { NewTaskComponent } from '../popup/new-task/new-task.component';
import { NewUserComponent } from '../popup/new-user/new-user.component';
import { NgbModal, NgbPaginationModule } from '@ng-bootstrap/ng-bootstrap';
import { AppService } from '../../../services/app.service';

const MODALS = {
  project: NewProjectComponent,
  task: NewTaskComponent,
  user: NewUserComponent,
};

@Component({
  selector: 'app-buttons',
  templateUrl: './buttons.component.html',
  styleUrls: ['./buttons.component.css']
})

export class ButtonsComponent implements OnInit {

  public isAdmin:boolean = false;
  public isPM:boolean = false;

  constructor(private modalService: NgbModal,
              private auth: AppService) { }

  ngOnInit() {
    this.checkRole();
  }
  
  open(name: string) {
    this.modalService.open(MODALS[name]);
  }

  private checkRole():void{
    if(localStorage.getItem('role') === 'admin' || sessionStorage.getItem('role') === 'admin'){
      this.isAdmin = true;
    } else if(localStorage.getItem('role') === 'project manager' || sessionStorage.getItem('role') === 'project manager'){
      this.isPM = true;
    }
  }

  public logout(){
    this.auth.logout();
  }

}
