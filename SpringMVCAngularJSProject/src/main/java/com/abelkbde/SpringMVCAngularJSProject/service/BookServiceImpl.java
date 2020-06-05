package com.abelkbde.SpringMVCAngularJSProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.abelkbde.SpringMVCAngularJSProject.model.Book;

@Service("bookService")
public class BookServiceImpl implements BookService {

	public static final String REST_SERVICE_URI = "http://localhost:3000/books";

	public static final String REST_SERVICE_URI_ID = "http://localhost:3000/books/{id}";
	
	@Autowired
	private RestTemplate restTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findAllBooks() {

		List<Book> books = restTemplate.getForObject(REST_SERVICE_URI, List.class);

		return books;
	}

	@Override
	public Book findBookById(Integer id) {
		
		Book book = restTemplate.getForObject(REST_SERVICE_URI_ID, Book.class, id);

		return book;
	}

	@Override
	public Book createBook(Book book) {
		
		restTemplate.postForLocation(REST_SERVICE_URI, book, Book.class);

		return book;

	}

	@Override
	public Book updateBook(Book book, Integer id) {
		
		restTemplate.put(REST_SERVICE_URI_ID, book, id);

		return book;

	}

	@Override
	public Boolean deleteBookById(Integer id) {
		
		restTemplate.delete(REST_SERVICE_URI_ID, id);

		return true;
	}

}
