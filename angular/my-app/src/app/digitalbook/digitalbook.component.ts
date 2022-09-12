import { Component, Injectable, OnInit } from '@angular/core';
import { BookService} from '../book.service';

@Component({
  selector: 'app-digitalbook',
  templateUrl: './digitalbook.component.html',
  styleUrls: ['./digitalbook.component.css']
})


export class DigitalbookComponent implements OnInit {
  book={
    title:'spring',
    category:'tech',
    price:500
  }

  constructor(public bookService : BookService) { }
  
  addBook(){
    const promise=this.bookService.addBook(this.book);
    promise.subscribe((responseBody:any)=>{
    console.log("Book Saved Sucessfully"+ responseBody);
    })
  }

  ngOnInit(): void {
  }

}
