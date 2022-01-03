import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Task } from '../Task';
import { TaskServices } from '../task.service';

@Component({
  selector: 'app-assign-task',
  templateUrl: './assign-task.component.html',
  styleUrls: ['./assign-task.component.css']
})
export class AssignTaskComponent implements OnInit {
  task_Id!: number;
  tasdata!: Task;
  constructor(private route: ActivatedRoute, private router: Router,
    private taskservices: TaskServices) { }

  ngOnInit(): void {
    
    this.tasdata = new Task();
    this.task_Id = this.route.snapshot.params['task_Id'];
    this.taskservices.gettask(this.task_Id).subscribe(data => {
      console.log(data);
      this.tasdata = data;
    },error=>console.log(error))
  }
  Assigntask() {
  
    this.taskservices.assigntask( this.tasdata)
    .subscribe(data => console.log(data),error=>console.log(error));
    this.tasdata=new Task();
    this.gotoSuccess();
  }
  
  onSubmit() {
    
    this.Assigntask();
  }
  gotoSuccess() {
    this.router.navigate(['/tasks'])
  }
  
  list() {
    this.router.navigate(['/success'])
  }
  
}
