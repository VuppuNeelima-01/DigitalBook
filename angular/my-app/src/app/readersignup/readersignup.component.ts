import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { Reader } from "src/app/reader.model";
import { ReaderService } from "src/app/reader.service";

@Component({
  selector: 'app-readersignup',
  templateUrl: './readersignup.component.html',
  styleUrls: ['./readersignup.component.css']
})
export class ReadersignupComponent implements OnInit {


  flag:any;
  reader={
    username:'',
    email:'',
    password:'',
 
  };
 
  blankFields={
    username1:'',
    email1:'',
    password:'',
   
  };
  readersignupuserNameExists:any;
  readersignupEmailExists:any;
  validCreds:any;
  readersignupStatus:any;
  users:any[]=[];
  successMessage:any;
  failureMessage:any;
  readersignupContainerFlag:boolean=true;
  readersignupflag: boolean=true;
  emailExists: any;

  constructor( public readerService : ReaderService){ }

  registerReader(){
    console.log('Clicked!');
    const c =this.readerService.registerReader(this.reader);
    c.subscribe((response:any)=>{
    this.blankFields.username1=response.username;
    this.blankFields.email1=response.email;
    this.blankFields.password=response.password;

   
      console.log("ab"+response );
    },
    (error:any)=>{
      console.log(JSON.stringify(error.error));
      this.readersignupuserNameExists="";
      this.readersignupEmailExists="";
      
      console.log("X"+error.error);
      if(typeof error.error==='string'){
        if(error.error.includes("Invalid")){
          this.readersignupuserNameExists=error.error;
        }
        if(error.error.includes("Invalid") ){
          this.readersignupEmailExists=error.error;
        }
        
       
      }
      else{
        this.readersignupContainerFlag=false;
        this.successMessage=error.error.text;
      }
    });
  }
  ngOnInit(): void {
   
    
    
  }
 

}
