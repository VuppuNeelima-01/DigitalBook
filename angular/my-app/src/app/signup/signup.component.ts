import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms'
import { BookService } from 'src/app/book.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  user:any

  signUpForm = new FormGroup({
    userName:new FormControl(''),
    email: new FormControl(''),
    password: new FormControl(''),
  });
  constructor(user:BookService) { }

  ngOnInit(): void {
  }
  onSubmit(){
   console.log( this.signUpForm.value);
   this.user.signUpUser(this.signUpForm.value).subscribe((data:any)=>{
    console.log("signup data",data);
  });;
    }
}