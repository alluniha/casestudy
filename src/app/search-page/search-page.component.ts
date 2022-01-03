import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { TaskServices } from '../task.service';

@Component({
  selector: 'app-search-page',
  templateUrl: './search-page.component.html',
  styleUrls: ['./search-page.component.css']
})
export class SearchPageComponent implements OnInit {
  tasdata!: Observable<Task[]>
  p: number = 1;
  searchText!: any;
  constructor(private taskService: TaskServices,
    private router: Router) { }

  ngOnInit(): void {
    this.loadData();
  }

  loadData() {

    this.tasdata = this.taskService.gettaskList();

  }
  list() {
    this.router.navigate(['/success'])
  }
}
