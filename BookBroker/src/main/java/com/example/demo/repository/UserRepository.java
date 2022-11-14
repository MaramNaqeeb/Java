package com.example.demo.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Book;
import com.example.demo.models.User;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findAll();

	Optional<User> findById(Long id);

	Optional<User> findByEmail(String email);

	
}



