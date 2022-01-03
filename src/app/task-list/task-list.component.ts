import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Task } from '../Task';
import { TaskServices } from '../task.service';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {
  tasdata!: Observable<Task[]>
  p: number = 1;
  searchText!: any;
  constructor(private taskService: TaskServices,
    private router: Router) { }

  ngOnInit() {
    this.loadData();
  }
  loadData() {

    this.tasdata = this.taskService.gettaskList();

  }
  deleteTask(id: number) {
    this.taskService.deletetask(id).subscribe(data => {
      console.log(data);
      alert(" Task deleted sucessfull"); 
      this.loadData();
    })

  }
  taskDetails(id: number) {
    this.router.navigate(['details', id]);
  }
  updateTask(id: number) {
    this.router.navigate(['update', id]);
  }
  list() {
    this.router.navigate(['/success'])
  }
  
  
  

}
