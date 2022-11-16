package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.models.Project;
import com.example.demo.models.User;
import com.example.demo.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepo;

	public Project findprojectById(Long id) {
		Optional<Project> optionalproject = projectRepo.findById(id);
		if (optionalproject.isPresent()) {
			return optionalproject.get();
		} else {
			return null;
		}
	}

	public List<Project> allprojects() {
		return (List<Project>) projectRepo.findAll();
	}

	public Project createproject(Project b) {
		return projectRepo.save(b);

	}

	public Project editproject(Project project) {
		return projectRepo.save(project);

	}

	public void delete(Long id) {
		projectRepo.deleteById(id);
	}

	public Project updateProject(Project project) {
		return projectRepo.save(project);
	}
	
	public List<Project> getAssignedUsers(User user){
		return projectRepo.findAllByUsers(user);
	}
	
	public List<Project> getUnassignedUsers(User user){
		return projectRepo.findByUsersNotContains(user);
	}

	

}
