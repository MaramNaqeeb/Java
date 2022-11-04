package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.models.Book;
import com.example.demo.services.BookService;



@Controller

public class BookController {

	
	   private BookService bookService;
	    public BookController(BookService bookService){
	        this.bookService = bookService;
	    }

	@GetMapping("/books/{id}")
	
	public String index( Model model, @PathVariable ("id") Long id) {
		Book book = bookService.findBook(id); 
		  model.addAttribute("book", book);  
		 
		  return "index.jsp"; 
	
	}
}
