import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';


import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import {FormsModule} from "@angular/forms";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateTaskComponent } from './create-task/create-task.component';
import { TaskDetailsComponent } from './task-details/task-details.component';
import { TaskListComponent } from './task-list/task-list.component';
import { UpdateTaskComponent } from './update-task/update-task.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { SuccessLoginComponent } from './success-login/success-login.component';
import { LogoutPageComponent } from './logout-page/logout-page.component';

import { Ng2OrderModule } from 'ng2-order-pipe';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { NgxPaginationModule } from 'ngx-pagination';
import { SearchPageComponent } from './search-page/search-page.component';
import { AssignTaskComponent } from './assign-task/assign-task.component';
import { PrioritizeTaskComponent } from './prioritize-task/prioritize-task.component';
import { UpdateNotesComponent } from './update-notes/update-notes.component';
import { UpdateBookmarkComponent } from './update-bookmark/update-bookmark.component';



@NgModule({
  declarations: [
    AppComponent,
    CreateTaskComponent,
    TaskDetailsComponent,
    TaskListComponent,
    UpdateTaskComponent,
    LoginPageComponent,
    SuccessLoginComponent,
    LogoutPageComponent,
    SearchPageComponent,
    AssignTaskComponent,
    PrioritizeTaskComponent,
    UpdateNotesComponent,
    UpdateBookmarkComponent
  ],
  imports: [
    BrowserModule,HttpClientModule,Ng2OrderModule,Ng2SearchPipeModule,NgxPaginationModule,
    AppRoutingModule,ReactiveFormsModule,FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
