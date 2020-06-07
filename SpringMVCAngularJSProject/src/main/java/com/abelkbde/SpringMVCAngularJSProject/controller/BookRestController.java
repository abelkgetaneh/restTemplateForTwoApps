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
		
		ResponseEntity<List<Book>> books = bookService.findAllBooks();
		
		return books;		
		
	}
	
	//----------------------Fetch Single Book--------------------------------------------------------------------
	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
	public ResponseEntity<Book> findBook(@PathVariable("id") Integer id){
		
		LOGGER.info("Fetching book with id " + id);
		
		ResponseEntity<Book> book = bookService.findBookById(id);		
		
		return book;
	}
	
	//--------------------------Create a Book--------------------------------------------------
	@RequestMapping(value = "/book/", method = RequestMethod.POST)
	public ResponseEntity<Book> createBook(@RequestBody Book book){
		
		LOGGER.info("Creating book " + book.getId());
		
		return bookService.createBook(book);
		
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
	public ResponseEntity<Boolean> deleteBook(@PathVariable("id") Integer id){
		
		LOGGER.info("Fetching and deleting a book with title " + id);
		
		bookService.deleteBookById(id);
		
		return new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
	}
	
	
}
