import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

//import { ReaderComponent } from './/';
import { SignupComponent } from './/signup/signup.component';
import { SigninComponent } from './/signin/signin.component';
import { HomeComponent } from './/home/home.component';
import { ReactiveFormsModule } from '@angular/forms';
import { AddbookComponent } from './/addbook/addbook.component';
import { HttpClientModule } from '@angular/common/http';
const routes:Routes=[

  {
    path:'signin',component:SigninComponent
  },
  {
    path:'signup',component:SignupComponent
  },
  {
    path:'home',component:HomeComponent
  },
  {
    path:'addbook',component:AddbookComponent
  }
]
@NgModule({
  declarations: [
    AppComponent,
  
    //ReaderComponent,
       SignupComponent,
       SigninComponent,
       HomeComponent,
       AddbookComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule,RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }