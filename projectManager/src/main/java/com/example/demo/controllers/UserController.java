package com.example.demo.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.models.LoginUser;
import com.example.demo.models.User;
import com.example.demo.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userServ;

	@GetMapping("/")
	    public String index(Model model, HttpSession session) {
	    if(session.getAttribute("userId")!=null) {
	    	return "redirect:/show";
	    }
	        model.addAttribute("newUser", new User());
	        model.addAttribute("newLogin", new LoginUser());
	        return "logreg.jsp";
	    }
	
	    @PostMapping("/register")
	    public String register(@Valid @ModelAttribute("newUser") User newUser, 
	            BindingResult result, Model model, HttpSession session) {
	        
	    	User registeredUser = userServ.register(newUser, result);
	        
	        if(result.hasErrors()) {
	            model.addAttribute("newLogin", new LoginUser());
	            return "logreg.jsp";
	        }
	    session.setAttribute("userId", registeredUser.getId());
	        return "redirect:/projects";
	    }
	
	    @PostMapping("/login")
	    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	            BindingResult result, Model model, HttpSession session) {
	        
	    	User loggedUser = userServ.login(newLogin, result);
	    
	        if(result.hasErrors()) {
	            model.addAttribute("newUser", new User());
	            return "logreg.jsp";
	        }
	    
	    
	        session.setAttribute("userId", loggedUser.getId());
	    
	        return "redirect:/projects";
	}

	    

	
	    @GetMapping("/logout")
	    public String logout(HttpSession session) {
	    	session.invalidate();
	    	return "redirect:/";
	    }
	

}
