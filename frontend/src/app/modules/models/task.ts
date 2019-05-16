import { User } from "./user";

export class Task {
  id:string;
  project: string;
  name: string;
  description: string;
  dueDate: string;
  priority: string;
  status: string;
  estimation: string;
  assignee: User;
  createdDate: string;
  updateDate: string;
  reporter: string;
  ticketCode: string;
}
