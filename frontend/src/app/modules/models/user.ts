import { UserRole } from './user-role';

export class User {
  id: string;
  firstName: string;
  secondName: string;
  email: string;
  role: UserRole;

  public setEmail(email: string){
  	this.email = email;
  }
}
