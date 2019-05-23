import { Component, OnInit } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { UserRoleService } from '../../../../services/user-role.service';
import { User } from '../../../models/user';
import { UserRole } from '../../../models/user-role';
import { Subscription } from 'rxjs';
import { UserService } from '../../../../services/user.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-new-user',
  templateUrl: './new-user.component.html',
  styleUrls: ['./new-user.component.css']
})
export class NewUserComponent implements OnInit {

  editableUser: User = new User();
  userRole: UserRole[];

  private subscriptions: Subscription[] = [];

  public formControl: FormGroup;

  constructor(private activeModal: NgbActiveModal,
              private fb: FormBuilder,
              private roleService: UserRoleService,
              private userService: UserService) { }

  ngOnInit() {
    this.loadUserRole();
    this.initFormControl();
  }

  private initFormControl() {
    this.formControl = this.fb.group({
      name: ['', [Validators.required, Validators.minLength(2)]],
      surname: ['', [Validators.required, Validators.minLength(2)]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      role: ['', Validators.required]
    });
  }

  private loadUserRole(): void {
    this.subscriptions.push(this.roleService.getUserRole().subscribe(role => {
      this.userRole = role as UserRole[];
    }));
  }

  private saveNewUser() {
    this.subscriptions.push(this.userService.saveNewUser(this.editableUser).subscribe(() => {
      this.editableUser = new User();
      this.activeModal.close();
    }));
  }



}
