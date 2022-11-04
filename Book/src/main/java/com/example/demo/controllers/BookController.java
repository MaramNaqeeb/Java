//package com.example.demo.controllers;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.example.demo.models.Book;
//
//
//
//@Controller
//
//public class BookController {
//	private Object bookService;
//
//	@GetMapping({"books"})
//	public String form() {
//		return "form.jsp";
//	}
//
//	@PostMapping("/register")
//	public String register(@RequestParam(value = "title") String title, @RequestParam(value = "description") String description,
//			@RequestParam(value = "language") String language, @RequestParam(value = "pages") Integer pages,
//			
//			HttpSession session) {
//		session.setAttribute("title", title);
//		session.setAttribute("description", description);
//		session.setAttribute("language", language);
//		session.setAttribute("pages", pages);
//
//		return "redirect:/show";
//
//	}
//
//	@GetMapping("/books/{bookId}")
//	public String findOwner(@PathVariable String bookId, Model model) {
//		 Book book = bookService.findBook(bookId);  
//		  model.addAttribute("book", book);  
//		  return "displayOwner"; 
//		
//	}
