

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
	
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
 selector: 'app-signup',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit{
  title = 'reactiveformproject';
  signInForm!: FormGroup;
  submitted = false;

  constructor(private formBuilder: FormBuilder,private router:Router) {}

  ngOnInit() {
    this.signInForm = this.formBuilder.group({
      //firstName: ['', Validators.required],
      //lastName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
    });
  }

  onSubmit() {
    this.submitted = true;

    // stop the process here if form is invalid
    if (this.signInForm.invalid) {
      return;
    }

    alert('Registered Successfully!!');
    this.router.navigateByUrl('/addbook');
  }
}

