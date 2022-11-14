package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Book;
import com.example.demo.models.User;
import com.example.demo.repository.BookRepository;
@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;
	
	public Book findBookById(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
	public List<Book> allBooks() {
		return (List<Book>) bookRepo.findAll();
	}

	public Book createBook(Book b) {
		return bookRepo.save(b);
		
	}
	public Book editBook(Book book) {
		return bookRepo.save(book);
		
	}
	public void  delete(Long id) {
		bookRepo.deleteById(id);
	}
	public List<Book> userbook(User user) {
		return bookRepo.findByUserIdIs(user.getId());
	}

	public List <Book> borrow (User user) {
		return bookRepo.findByBorrowerIdIs(user.getId());
	}
	
	public List <Book> unborrow (User user) {
		return bookRepo.findByBorrowerIdIsOrUserIdIs(null, user.getId() );
	}
	public void addBorrower(Book book, User user) {
		book.setBorrower(user);
		bookRepo.save(book);
	}
	public void deleteBorrower(Book book) {
		book.setBorrower(null);
		bookRepo.save(book);
	}
	
	
	public  List<Book> findByBorrowerNull(){
		
		return bookRepo.findByBorrowerNull();
	}
	
	public  List<Book> findAllBorrowerBooks(Long id){
		
		return bookRepo.findByBorrowerIdIs(id);
	}

}

