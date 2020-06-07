package com.abelkbde.SpringMVCAngularJSProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.abelkbde.SpringMVCAngularJSProject.model.Book;

@Service("bookService")
public class BookServiceImpl implements BookService {

	public static final String REST_SERVICE_URI = "http://localhost:3000/books";
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public ResponseEntity<List<Book>> findAllBooks() {

		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_JSON);		
		
		HttpEntity<List<Book>> requestEntity = new HttpEntity<>(headers);
		
		ResponseEntity<List<Book>> responseEntity = restTemplate.exchange(REST_SERVICE_URI, HttpMethod.GET, requestEntity, 
				new ParameterizedTypeReference<List<Book>>() {
		});

		return responseEntity;
	}

	@Override
	public ResponseEntity<Book> findBookById(Integer id) {
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_JSON);		
		
		HttpEntity<Book> requestEntity = new HttpEntity<>(headers);		
		
		ResponseEntity<Book> responseEntity = restTemplate.exchange(REST_SERVICE_URI + "/{id}", HttpMethod.GET, requestEntity, Book.class, id);
		
		return responseEntity;		
	}

	@Override
	public ResponseEntity<Book> createBook(Book book) {		
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_JSON);		
		
		HttpEntity<Book> requestEntity = new HttpEntity<>(book, headers);
		
		ResponseEntity<Book> responseEntity = restTemplate.exchange(REST_SERVICE_URI, HttpMethod.POST, requestEntity, Book.class);
		
		return responseEntity;	

	}

	@Override
	public ResponseEntity<Book> updateBook(Book book, Integer id) {
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_JSON);		
		
		HttpEntity<Book> requestEntity = new HttpEntity<>(book, headers);		
		
		ResponseEntity<Book> responseEntity = restTemplate.exchange(REST_SERVICE_URI + "/{id}", HttpMethod.PUT, requestEntity, Book.class, id);
		
		return responseEntity;

	}

	@Override
	public ResponseEntity<Void> deleteBookById(Integer id) {
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_JSON);		
		
		HttpEntity<?> requestEntity = new HttpEntity<>(headers);		
		
		ResponseEntity<Void> responseEntity = restTemplate.exchange(REST_SERVICE_URI + "/{id}", HttpMethod.DELETE, requestEntity, Void.class, id);
		
		return responseEntity;		
	}

}
