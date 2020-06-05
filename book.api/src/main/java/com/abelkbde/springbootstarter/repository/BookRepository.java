package com.abelkbde.springbootstarter.repository;

import org.springframework.data.repository.CrudRepository;

import com.abelkbde.springbootstarter.model.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{

}
