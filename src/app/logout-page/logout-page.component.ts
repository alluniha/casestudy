import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TaskServices } from '../task.service';

@Component({
  selector: 'app-logout-page',
  templateUrl: './logout-page.component.html',
  styleUrls: ['./logout-page.component.css']
})
export class LogoutPageComponent implements OnInit {

  constructor(private taskService: TaskServices,
    private router: Router) { }

  ngOnInit(): void {
  }

  list() {
    this.router.navigate(['/login'])
  }
  

}
