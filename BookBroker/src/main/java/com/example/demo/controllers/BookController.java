package com.example.demo.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Book;
import com.example.demo.models.User;
import com.example.demo.service.BookService;
import com.example.demo.service.UserService;

@Controller
public class BookController {

	@Autowired
	private BookService bookServ;
	@Autowired
	private UserService userServ;

	@GetMapping("/book/new")
	public String newBook(@ModelAttribute("book") Book book, HttpSession session, Model model) {

		Long userId = (Long) session.getAttribute("userId");
		User myUser = userServ.findUserById(userId);
		model.addAttribute("myUser", myUser);

		return "newbook.jsp";
	}

	@PostMapping("/create/book")
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session,
			Model model) {
		if (result.hasErrors()) {
			return "newbook.jsp";
		} else {
			bookServ.createBook(book);
			Long userId = (Long) session.getAttribute("userId");
			User myUser = userServ.findUserById(userId);
			model.addAttribute("myUser", myUser);

			return "redirect:/books";
		}
	}

	@GetMapping("/books")
	public String showbook(Model model, HttpSession session) {

		if (session.getAttribute("userId") != null) {
			List<Book> allBooks = bookServ.allBooks();
			model.addAttribute("allbooks", allBooks);
			Long userId = (Long) session.getAttribute("userId");
			User myUser = userServ.findUserById(userId);
			model.addAttribute("myUser", myUser);
			return "dashboard.jsp";
		}
		return "redirect:/";

	}

	@GetMapping("/book/{bookId}")
	public String show(@ModelAttribute("book") Book book, @PathVariable("bookId") Long id, HttpSession session,
			Model model) {
		Book book1 = bookServ.findBookById(id);
		model.addAttribute("book", book1);
		Long userId = (Long) session.getAttribute("userId");
		User myUser = userServ.findUserById(userId);
		model.addAttribute("myUser", myUser);

		return "show.jsp";
	}

	@DeleteMapping("/books/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		bookServ.delete(id);

		return "redirect:/books";
	}

	@GetMapping("/books/{bookId}/edit")
	public String editBook(@PathVariable("bookId") Long id, HttpSession session, Model model) {
		Book book = bookServ.findBookById(id);
		model.addAttribute("book", book);
		Long userId = (Long) session.getAttribute("userId");
		User myUser = userServ.findUserById(userId);
		model.addAttribute("myUser", myUser);
		return "edit.jsp";
	}

	@PutMapping("/update")
	public String editBook(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session,
			Model model) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			if (session.getAttribute("userId") != null)
				bookServ.editBook(book);
			Long userId = (Long) session.getAttribute("userId");
			User myUser = userServ.findUserById(userId);
			model.addAttribute("myUser", myUser);
			return "redirect:/books";
		}
	}

	@GetMapping("/books/{bookId}")
	public String borrow(@PathVariable("bookId") Long id, Model model, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			Book book1 = bookServ.findBookById(id);
			model.addAttribute("book", book1);
			Long userId = (Long) session.getAttribute("userId");
			User myUser = userServ.findUserById(userId);
			model.addAttribute("myUser", myUser);
			return "dashboard.jsp";
		} else {
			return "redirect:/books";
		}
	}

	@GetMapping("/bookmarket")
	public String bookmarket(Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}
		User myUser = userServ.findUserById(userId);
		model.addAttribute("myUser", myUser);

//		
//		List<Book> books = bookServ.allBooks();
//		model.addAttribute("books", books);

		List<Book> mybooks = myUser.getBooks();

		List<Book> mybooks2 = bookServ.findByBorrowerNull();
		model.addAttribute("mybooks2", mybooks2);
		List<Book> allBooksBorrower = bookServ.findAllBorrowerBooks(userId);

		model.addAttribute("borrower", allBooksBorrower);

		model.addAttribute("mybooks", mybooks);

		return "bookmarket.jsp";
	}

	@RequestMapping("/bookmarket/{bookID}")
	public String borrowBook(@PathVariable("bookID") Long bookID, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}
		bookServ.addBorrower(bookServ.findBookById(bookID), userServ.findUserById(userId));
		System.out.println("hi");
		return "redirect:/bookmarket";

	}

	@RequestMapping("/bookmarket/remove/{bookID}")
	public String unborrow(@PathVariable("bookID") Long bookID, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");

		User myUser = userServ.findUserById(userId);

		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
//		myUser.getBorrowedBooks().remove(myUser.getId());
		bookServ.deleteBorrower(bookServ.findBookById(bookID));
		return "redirect:/bookmarket";

	}
}
