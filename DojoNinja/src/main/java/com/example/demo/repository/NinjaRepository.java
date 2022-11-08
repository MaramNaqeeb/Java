package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long> {
	 
	 List<Ninja> findAll();
		 
}
