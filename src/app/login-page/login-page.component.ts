import { Component, OnInit } from '@angular/core';

import { FormGroup, FormControl, Validators } from "@angular/forms";
import { Router } from '@angular/router';
import { User } from '../User';
import { TaskServices } from '../task.service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {


  form1: any;

  userdata!: User;

  email!: string;
  password!: string;

  constructor(private taskService: TaskServices, private router: Router) { }

  ngOnInit(): void {
    this.form1 = new FormGroup({
      email: new FormControl("",
         Validators.compose([Validators.required,Validators.email])
      ),
      password: new FormControl("",
        Validators.compose([Validators.required,Validators.minLength(4)])
      )
    });
  }

  
  onSubmit(user: any) {


    this.userdata = user
    console.log(this.userdata)
    this.taskService.validateuser(this.userdata).subscribe(data => {console.log(data);
    if(data == true)
    {
      alert("login sucessfull"); 
    this.gotoSuccess();
  }
  
  else {
    alert("enter a valid userid and password");
  }
  })
}

  gotoSuccess() {
    this.router.navigate(['/success'])
  }


}
