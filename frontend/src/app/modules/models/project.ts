export class Project {
  id: string;
  code: string;
  name: string;
  summary: string;

  public constructor(init?: Partial<Project>) {
  	Object.assign(this, init);
  }
}
