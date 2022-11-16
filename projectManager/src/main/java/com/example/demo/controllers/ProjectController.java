package com.example.demo.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Project;
import com.example.demo.models.User;
import com.example.demo.service.ProjectService;
import com.example.demo.service.UserService;

@Controller
public class ProjectController {

	@Autowired
	private ProjectService projectServ;
	@Autowired
	private UserService userServ;

	@GetMapping("/project/new")
	public String newproject(@ModelAttribute("project") Project project, HttpSession session, Model model) {

		Long userId = (Long) session.getAttribute("userId");
		User myUser = userServ.findUserById(userId);
		model.addAttribute("myUser", myUser);

		return "newproject.jsp";
	}

	@PostMapping("/create/project")
	public String create(@Valid @ModelAttribute("project") Project project, BindingResult result, HttpSession session,
			Model model) {
		if (result.hasErrors()) {
			return "newproject.jsp";
		} else {
			projectServ.createproject(project);
			Long userId = (Long) session.getAttribute("userId");
			User myUser = userServ.findUserById(userId);
			model.addAttribute("myUser", myUser);
			myUser.getProjects1().add(project);
			projectServ.updateProject(project);
			return "redirect:/projects";
		}
	}

	@GetMapping("/projects")
	public String showproject(Model model, HttpSession session) {

		if (session.getAttribute("userId") != null) {
			List<Project> allprojects = projectServ.allprojects();
			model.addAttribute("allprojects", allprojects);
			Long userId = (Long) session.getAttribute("userId");
			User myUser = userServ.findUserById(userId);
			model.addAttribute("myUser", myUser);
			model.addAttribute("projects",projectServ.getUnassignedUsers(myUser));	
			model.addAttribute("projects2",projectServ.getAssignedUsers(myUser));	// not used 

			
			return "dashboard.jsp";
		}
		return "redirect:/";

	}

	@GetMapping("/project/{projectId}")
	public String show(@ModelAttribute("project") Project project, @PathVariable("projectId") Long id,
			HttpSession session, Model model) {
		Project project1 = projectServ.findprojectById(id);
		model.addAttribute("project", project1);
		Long userId = (Long) session.getAttribute("userId");
		User myUser = userServ.findUserById(userId);
		model.addAttribute("myUser", myUser);

		return "show.jsp";
	}

	@DeleteMapping("/projects/{id}")
	public String deleteproject(@PathVariable("id") Long id) {
		projectServ.delete(id);

		return "redirect:/projects";
	}

	@GetMapping("/projects/{projectId}/edit")
	public String editproject(@PathVariable("projectId") Long id, HttpSession session, Model model) {
		Project project = projectServ.findprojectById(id);
		model.addAttribute("project", project);
		Long userId = (Long) session.getAttribute("userId");
		User myUser = userServ.findUserById(userId);
		model.addAttribute("myUser", myUser);
		return "edit.jsp";
	}

	@PutMapping("/update")
	public String editproject(@Valid @ModelAttribute("project") Project project, BindingResult result,
			HttpSession session, Model model) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			if (session.getAttribute("userId") != null)
				projectServ.editproject(project);
			Long userId = (Long) session.getAttribute("userId");
			User myUser = userServ.findUserById(userId);
			model.addAttribute("myUser", myUser);
			return "redirect:/projects";
		}

	}

	@RequestMapping("/join/{id}")
	public String join(@PathVariable("id") Long id, HttpSession session, Model model) {
		
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		Long userId = (Long) session.getAttribute("userId");
		User myUser = userServ.findUserById(userId);
		model.addAttribute("myUser", myUser);
		Project project = projectServ.findprojectById(id);
		myUser.getProjects1().add(project);
		projectServ.updateProject(project);
	

		return "redirect:/projects";
	}

	@RequestMapping("/leave/{id}")
	public String leave(@PathVariable("id") Long id, HttpSession session, Model model) {
		
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		Long userId = (Long) session.getAttribute("userId");
		User myUser = userServ.findUserById(userId);
		model.addAttribute("myUser", myUser);
		Project project = projectServ.findprojectById(id);
		myUser.getProjects1().remove(project);
		projectServ.updateProject(project);
		return "redirect:/projects";
	}



}
