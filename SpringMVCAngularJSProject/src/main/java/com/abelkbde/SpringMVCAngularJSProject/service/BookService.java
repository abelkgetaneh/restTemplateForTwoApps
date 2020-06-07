package com.abelkbde.SpringMVCAngularJSProject.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.abelkbde.SpringMVCAngularJSProject.model.Book;

public interface BookService {

	ResponseEntity<Book> findBookById(Integer id);    
     
	ResponseEntity<Book> createBook(Book book);
     
	ResponseEntity<Book> updateBook(Book book, Integer id);
     
    ResponseEntity<Void> deleteBookById(Integer id);
 
    ResponseEntity<List<Book>> findAllBooks();      
    
}
