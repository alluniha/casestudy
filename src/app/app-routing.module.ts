import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TaskDetailsComponent } from './task-details/task-details.component';
import { CreateTaskComponent } from './create-task/create-task.component';
import { TaskListComponent } from './task-list/task-list.component';
import { UpdateTaskComponent } from './update-task/update-task.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { SuccessLoginComponent } from './success-login/success-login.component';
import { LogoutPageComponent } from './logout-page/logout-page.component';
import { SearchPageComponent } from './search-page/search-page.component';
import { AssignTaskComponent } from './assign-task/assign-task.component';
import { PrioritizeTaskComponent } from './prioritize-task/prioritize-task.component';
import { UpdateNotesComponent } from './update-notes/update-notes.component';
import { UpdateBookmarkComponent } from './update-bookmark/update-bookmark.component';

const routes: Routes = [
  {path:'',redirectTo:'/',pathMatch:'full' },
  {path:'save',component:CreateTaskComponent},
  {path:'login',component:LoginPageComponent},
  {path: 'details/:task_Id', component:TaskDetailsComponent },
  {path:'tasks' , component:TaskListComponent},
  {path:'success',component:SuccessLoginComponent},
  {path:'update/:task_Id',component:UpdateTaskComponent},
  {path:'assigntask',component:AssignTaskComponent},
  {path:'ptask',component:PrioritizeTaskComponent},
  {path:'unotes',component:UpdateNotesComponent},
  {path:'ubookmark',component:UpdateBookmarkComponent},
  {path:'search',component:SearchPageComponent},
  {path:'logout',component:LogoutPageComponent},
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
