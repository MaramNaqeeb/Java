package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.demo.models.LoginUser;
import com.example.demo.models.Project;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public User findUserById(Long id) {
		Optional<User> optionalUser = userRepo.findById(id);
		if (optionalUser.isPresent()) {
			return optionalUser.get();
		} else {
			return null;
		}
	}

	public User findUserByEmail(String email) {
		Optional<User> optionalUser = userRepo.findByEmail(email);
		if (optionalUser.isPresent()) {
			return optionalUser.get();
		} else {
			return null;
		}
	}

	public User register(User newUser, BindingResult result) {
		Optional<User> myUser = userRepo.findByEmail(newUser.getEmail());
		if (myUser.isPresent()) {
			result.rejectValue("email", "Unique", "Email already exists");

			if (!newUser.getPassword().equals(newUser.getConfirm())) {
				result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
			}
		}
		String alphabet = newUser.getUserName();
		if (!alphabet.matches("[a-zA-Z]+")) {
			result.rejectValue("userName", "Matches", "Must contain letters only");
		}

		if (result.hasErrors()) {

			return null;

		} else {
			String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			newUser.setPassword(hashed);
			return userRepo.save(newUser);
		}

	}

	public User login(LoginUser newLogin, BindingResult result) {

		Optional<User> myUser = userRepo.findByEmail(newLogin.getEmail());
		if (!myUser.isPresent()) {
			result.rejectValue("email", "Unique", "Unknown email");
			return null;

		}

		User user = myUser.get();
		if (!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Invalid password");
		}
		if (result.hasErrors()) {
			return null;
		}

		else {
			return user;

		}

	}

	public User updateUser(User user) {
		return userRepo.save(user);
	}

	public List<User> getAssignedProjects(Project project) {
		return userRepo.findAllByProjects(project);
	}

	public List<User> getunAssignedProjects(Project project) {
		return userRepo.findByProjectsNotContains(project);
	}

}
