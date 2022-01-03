import { Component, OnInit } from '@angular/core';
import { Task } from '../Task';
import { ActivatedRoute, Router } from '@angular/router';
import { TaskServices } from '../task.service';

@Component({
  selector: 'app-task-details',
  templateUrl: './task-details.component.html',
  styleUrls: ['./task-details.component.css']
})
export class TaskDetailsComponent implements OnInit {

  tasdata!: Task;
  task_Id!: number;
  constructor(private route: ActivatedRoute,private router: Router,private taskServices: TaskServices) { }

  ngOnInit() {

    this.tasdata=new Task();
    this.task_Id = this.route.snapshot.params['task_Id'];
    this.taskServices.gettask(this.task_Id)
    .subscribe(data=>{
      console.log(data);
      this.tasdata=data;      
    })

  }
  list() {
    this.router.navigate(['/tasks'])
  }
}




