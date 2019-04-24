import { Component, OnInit } from '@angular/core';
import {ProjectService} from "../../../../services/project.service";
import {Subscription} from "rxjs";
import {Project} from "../../../models/project";
import {NgbActiveModal, NgbModalOptions} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-new-project',
  templateUrl: './new-project.component.html',
  styleUrls: ['./new-project.component.css']
})
export class NewProjectComponent implements OnInit {

  newProject: Project = new Project();
  private subscriptions: Subscription[] = [];

  constructor(private projectService: ProjectService,
              public activeModal: NgbActiveModal) { }

  ngOnInit() {
  }


  private saveNewProject(){
    this.subscriptions.push(this.projectService.saveNewProject(this.newProject).subscribe(()=>{
      this.newProject = new Project();
    }))
  }

}
