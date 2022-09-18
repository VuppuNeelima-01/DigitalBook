import { Component, OnInit } from '@angular/core';
import { BookService } from '../book.service';
import { FormGroup, FormControl } from '@angular/forms'
@Component({
  selector: 'app-addbook',
  templateUrl: './addbook.component.html',
  styleUrls: ['./addbook.component.css']
})
export class AddbookComponent implements OnInit {
  book:any
  createBook= new FormGroup({
    //authorId:new FormControl(''),
    bookTitle:new FormControl(''),
    bookCategory: new FormControl(''),
    bookPrice: new FormControl(''),
    bookAuthor: new FormControl(''),
    bookPublisher: new FormControl(''),
    publishDate: new FormControl(''),
    

  });
  constructor(private user:BookService) {
    this.book=this.user;
   }

  ngOnInit(): void {
  }
  onSubmit(){
    console.log("Book Created Successfully",this.  createBook.value);
    console.log( this.  createBook.value);
    this.user.save(this.createBook.value).subscribe((data:any)=>{
      console.log(data,"datavalidationfrom ApI");
  });;
     }

}