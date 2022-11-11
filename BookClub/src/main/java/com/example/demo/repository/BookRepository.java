package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Book;
import com.example.demo.models.User;

@Repository
public interface BookRepository extends CrudRepository <Book,Long> {
	List<Book> findAll();

	Optional<Book> findById(Long id);


	
}
