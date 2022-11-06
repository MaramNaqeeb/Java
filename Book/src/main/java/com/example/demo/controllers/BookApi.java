//package com.example.demo.controllers;
//
//import java.util.List;
//
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.demo.models.Book;
//import com.example.demo.services.BookService;
//
//
//
//
//@RestController
//public class BookApi {
//    private final BookService bookService;
//    public BookApi(BookService bookService){
//        this.bookService = bookService;
//    }
// @RequestMapping("/api/books")
// public List<Book> index() {
//     return bookService.allBooks();
// }
// 
// @RequestMapping(value="/api/books", method=RequestMethod.POST)
// public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String description, @RequestParam(value="language") String language, @RequestParam(value="numOfPages") Integer numOfPages) {
//     Book book = new Book(title, description, language, numOfPages);
//     return bookService.createBook(book);
// }
// 
// @RequestMapping("/api/books/{id}")
// public Book show(@PathVariable("id") Long id) {
//     Book book = bookService.findBook(id);
//     return book;
// }
// @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
// public void deleteBook(@PathVariable("id") Long id) {
//	 bookService.deleteBook(id);
// 
//}
// 
// @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
// public Book updateBook(@PathVariable("id") Long id,
//		 				@RequestParam(value="title") String title,
//		 				@RequestParam(value="description") String description,
//		 				@RequestParam(value="language") String language,
//		 				@RequestParam(value="numOfPages") Integer numOfPages) {
//	 					Book bookFromDb=bookService.findBook(id);
//	 					bookFromDb.setTitle(title);
//	 					bookFromDb.setDescription(description);
//	 					bookFromDb.setLanguage(language);
//	 					bookFromDb.setNumberOfPages(numOfPages);
//	 					return bookService.updateBook(id);
// }
//     					
// 
// 
//}
//
