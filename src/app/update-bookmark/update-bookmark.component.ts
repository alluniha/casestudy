import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Task } from '../Task';
import { TaskServices } from '../task.service';

@Component({
  selector: 'app-update-bookmark',
  templateUrl: './update-bookmark.component.html',
  styleUrls: ['./update-bookmark.component.css']
})
export class UpdateBookmarkComponent implements OnInit {
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
  updateTask() {
  
    this.taskservices.updatebookmark( this.tasdata)
    .subscribe(data => console.log(data),error=>console.log(error));
    this.tasdata=new Task();
    this.gotoList();
  }
  onSubmit() {
    
    this.updateTask();
  }
  gotoList() {
    this.router.navigate(['/tasks'])
  }
  
  list() {
    this.router.navigate(['/success'])
  }

}
