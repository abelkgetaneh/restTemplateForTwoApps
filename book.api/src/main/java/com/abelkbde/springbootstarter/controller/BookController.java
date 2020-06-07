package com.abelkbde.springbootstarter.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abelkbde.springbootstarter.model.Book;
import com.abelkbde.springbootstarter.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping("/books")
	public Iterable<Book> getAllBooks() {
		
		return bookService.getAllBooks();
	}
	
	@RequestMapping("/books/{id}")
	public Optional<Book> getBook(@PathVariable Integer id) {
		
		return bookService.getBook(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/books")
	public Book addBook(@RequestBody Book book) {
		
		return bookService.addBook(book); 
		
		//return book;
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/books/{id}")
	public Book updateBook(@RequestBody Book book, @PathVariable Integer id) {
		
		return bookService.updateBook(book, id); 
		
		//return book;
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/books/{id}")
	public Boolean deleteBook(@PathVariable Integer id) {
		
		bookService.deleteBook(id);
		
		return true;
	}
}
