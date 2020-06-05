package com.abelkbde.SpringMVCAngularJSProject.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abelkbde.SpringMVCAngularJSProject.model.Book;
import com.abelkbde.SpringMVCAngularJSProject.service.BookService;

@RestController
public class BookRestController {

	private static final Logger LOGGER = Logger.getLogger(BookRestController.class);
	
	@Autowired
	private BookService bookService;
	
	//-------------------------Fetch All Users---------------------------
	@RequestMapping(value = "/book/", method = RequestMethod.GET)
	public ResponseEntity<List<Book>> listAllBooks(){
		
		LOGGER.info("Fetching all users");
		
		List<Book> books = bookService.findAllBooks();
		
		if(books.isEmpty()) {
			return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}
	
	//----------------------Fetch Single Book--------------------------------------------------------------------
	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
	public ResponseEntity<Book> findBook(@PathVariable("id") Integer id){
		
		LOGGER.info("Fetching book with id " + id);
		
		Book book = bookService.findBookById(id);		
		
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}
	
	//--------------------------Create a Book--------------------------------------------------
	@RequestMapping(value = "/book/", method = RequestMethod.POST)
	public ResponseEntity<Book> createBook(@RequestBody Book book){
		
		LOGGER.info("Creating book " + book.getId());
		
		bookService.createBook(book);
		
		return new ResponseEntity<Book>(book, HttpStatus.CREATED);
	}
	
	//----------------------Update a Book---------------------------------------------------------
	@RequestMapping(value = "/book/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Book> updateBook(@PathVariable("id") Integer id, @RequestBody Book book){
		
		LOGGER.info("Updating book " + id);	
		
		bookService.updateBook(book, id);
		
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}
	
	//---------------------Delete a Book------------------------------------------------------
	@RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Book> deleteBook(@PathVariable("id") Integer id){
		
		LOGGER.info("Fetching and deleting a book with title " + id);
		
		bookService.deleteBookById(id);
		
		return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
	}
	
	
}
