package com.example.demo;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class FormApp {
	@GetMapping({ "/", "/omikuji" })
	public String form() {
		return "form.jsp";
	}

	@PostMapping("/register")
	public String register(@RequestParam(value = "number") String number, @RequestParam(value = "city") String city,
			@RequestParam(value = "person") String person, @RequestParam(value = "hobby") String hobby,
			@RequestParam(value = "livingthing") String livingthing, @RequestParam(value = "nice") String nice,
			HttpSession session) {
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("livingthing", livingthing);
		session.setAttribute("nice", nice);
		return "redirect:/show";

	}

	@GetMapping("/show")
	public String show() {
		return "show.jsp";
	}

}
