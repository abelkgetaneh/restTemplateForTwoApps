package com.abelkbde.SpringMVCAngularJSProject.service;

import java.util.List;

import com.abelkbde.SpringMVCAngularJSProject.model.Book;

public interface BookService {

	Book findBookById(Integer id);    
     
    Book createBook(Book book);
     
    Book updateBook(Book book, Integer id);
     
    Boolean deleteBookById(Integer id);
 
    List<Book> findAllBooks();      
    
}
