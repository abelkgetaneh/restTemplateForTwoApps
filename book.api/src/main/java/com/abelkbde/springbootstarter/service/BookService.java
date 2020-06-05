package com.abelkbde.springbootstarter.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abelkbde.springbootstarter.model.Book;
import com.abelkbde.springbootstarter.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;	
	
	public Iterable<Book> getAllBooks(){
		
		Iterable<Book> books = bookRepository.findAll();
		
		return books;
	}
	
	public Optional<Book> getBook(Integer id) {
		
		return bookRepository.findById(id);
	}

	public Book addBook(Book book) {
		
		bookRepository.save(book);
		
		return book;
	}

	public Book updateBook(Book book, Integer id) {
		
		bookRepository.save(book);
		
		return book;
		
	}

	public Boolean deleteBook(Integer id) {
		
		bookRepository.deleteById(id);
		
		return true;
	}
	
}
