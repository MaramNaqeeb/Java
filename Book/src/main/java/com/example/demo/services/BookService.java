package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event.ID;

import com.example.demo.models.Book;
import com.example.demo.repositories.BookRepository;

@Service
public class BookService {

	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public List<Book> allBooks() {
		return (List<Book>) bookRepository.findAll();
	}

	public Book createBook(Book b) {
		return bookRepository.save(b);
	}

	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}

	public void deleteBook(long id) {
		bookRepository.deleteById(id);
	}

	public Book updateBook(long id) {
		return bookRepository.save(this.findBook(id));
	}
}

// public Book deleteById(long id) {
//	bookRepository.deleteById(id);
//	return null;
// }
