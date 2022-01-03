import { Component, OnInit } from '@angular/core';
import { TaskServices } from '../task.service';
import { Task } from '../Task';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-success-login',
  templateUrl: './success-login.component.html',
  styleUrls: ['./success-login.component.css']
})
export class SuccessLoginComponent implements OnInit {
  tasdata!: Task;
  constructor(private route: ActivatedRoute,private router: Router,private taskServices: TaskServices) { }

  ngOnInit(): void {
  }


  list() {
    this.router.navigate(['/tasks'])
  }

  list1() {
    this.router.navigate(['/save'])
  }
  list2() {
    this.router.navigate(['/logout'])
  }
  list3() {
    this.router.navigate(['/assigntask'])
  }
  list4() {
    this.router.navigate(['/ptask'])
  }
  list5() {
    this.router.navigate(['/unotes'])
  }
  list6() {
    this.router.navigate(['/ubookmark'])
  }
  list7() {
    this.router.navigate(['/search'])
  }
  
  

}
