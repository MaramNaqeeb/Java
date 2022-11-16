package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Project;
import com.example.demo.models.User;

@Repository
public interface ProjectRepository extends CrudRepository <Project,Long> {
	List<Project> findAll();

	Optional<Project> findById(Long id);
	Project findByIdIs(Long id);
	List<Project> findAllByUsers(User user);// all project join for this user
	List<Project> findByUsersNotContains(User user);// all project not joined for any users
	

	
}
