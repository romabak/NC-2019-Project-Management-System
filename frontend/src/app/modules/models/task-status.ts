export class TaskStatus {
  id: string;
  status: string;

  static cloneBase(status: TaskStatus) : TaskStatus{
    const clonedTaskStatus: TaskStatus = new TaskStatus();
    clonedTaskStatus.id = status.id;
    clonedTaskStatus.status = status.status;
    return clonedTaskStatus;
  }

  public getStatus() :string{
    return this.status;
  }
}
