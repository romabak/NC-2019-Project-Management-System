import { Component } from '@angular/core';
declare var $: any;

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})


export class HeaderComponent {

  public table = [
    "Project code",
    "Task",
    "Priority",
    "Status",
    "Created",
    "Updated",
    "Due Date",
    "Estimation",
    "Assignee",
    "Description",
    "Action"
  ];

  public exampleForTh1 =[
    "Project code",
    "Task",
    "Priority",
    "Status",
    "Created",
    "Updated",
    "Due Date",
    "Estimation",
    "Assignee",
    "Description"
  ];
  public exampleForTh2 = [
    "asda",
    "asdfagf",
    "asda",
    "asdfagf",
    "asda",
    "asdfagf",
    "asda",
    "asdfagf",
    "asda",
    "asdfagf"
  ];

  public exampleForTr = [
    this.exampleForTh1,
    this.exampleForTh2
  ];

    public userRole = [
    "Project manager",
    "Developer",
    "Tester"
  ];

  public ngOnInit(){
    $(document).ready(function() {
      $("#myInput").on("keyup", function () {
        var value = $(this).val().toLowerCase();
        $("#myTable tr").filter(function () {
          $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
      });
    });
  }

  constructor() { }

}
