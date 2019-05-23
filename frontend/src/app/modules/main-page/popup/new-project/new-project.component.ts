import { Component, OnInit } from '@angular/core';
import {ProjectService} from '../../../../services/project.service';
import {Subscription} from 'rxjs';
import {Project} from '../../../models/project';
import {NgbActiveModal, NgbModalOptions} from '@ng-bootstrap/ng-bootstrap';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-new-project',
  templateUrl: './new-project.component.html',
  styleUrls: ['./new-project.component.css']
})
export class NewProjectComponent implements OnInit {

  newProject: Project = new Project();
  private subscriptions: Subscription[] = [];

  formControl: FormGroup;

  constructor(private projectService: ProjectService,
              private fb: FormBuilder,
              public activeModal: NgbActiveModal) { }

  ngOnInit() {
    this.initReactForm();
  }

  initReactForm(): void {
    this.formControl = this.fb.group({
      code: ['', Validators.compose([
          Validators.required,
          Validators.pattern('[0-9]{4}')])],
      name: ['', Validators.required],
      summary: ['', Validators.required]
    });
  }

  private saveNewProject() {
    this.newProject = new Project(this.formControl.value);
    this.subscriptions.push(this.projectService.saveNewProject(this.newProject).subscribe(() => {
      this.newProject = new Project();
      this.activeModal.close();
    }));
  }

}
