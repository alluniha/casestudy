import { Component, OnInit } from '@angular/core';
import { Task } from '../Task';
import { TaskServices } from '../task.service';
import { FormGroup, FormControl, Validators } from "@angular/forms";
import { Router } from '@angular/router';
@Component({
  selector: 'app-create-task',
  templateUrl: './create-task.component.html',
  styleUrls: ['./create-task.component.css']
})
export class CreateTaskComponent implements OnInit {
  form1: any;

  tasdata!: Task;

  task_Id!: number;
  owner_Id!: number;
  creator_Id!: number;
  name!: string;
  description!: string;
  status!: string;
  priority!: string;
  notes!: string;
  isBookmarked!: string;
  created_On!: string;
  statusChanged_On!: string;
  constructor(private taskService: TaskServices, private router: Router) { }

  ngOnInit() {
    this.form1 = new FormGroup({
      task_Id: new FormControl("",
         Validators.compose([Validators.required])
      ),
      owner_Id: new FormControl("",
        Validators.compose([Validators.required])
      ),
      creator_Id: new FormControl("",
         Validators.compose([Validators.required])
      ),
      name: new FormControl(""
        ,
        Validators.compose([Validators.required,Validators.minLength(3)])
      ),
      description: new FormControl("",
        Validators.compose([Validators.required,Validators.minLength(3)])
      ),
      status: new FormControl(""),
      priority: new FormControl(""),
      notes: new FormControl(""),
      isBookmarked: new FormControl(""),
      created_On: new FormControl(""),
      statusChanged_On: new FormControl("")
    });

  }
  onSubmit(task: any) {


    this.tasdata = task
    console.log(this.tasdata)
    this.taskService.createtask(this.tasdata).subscribe(data => console.log(data));
    this.gotoList();
  }

  gotoList() {
    this.router.navigate(['/tasks'])
  }
  list() {
    this.router.navigate(['/success'])
  }


}
