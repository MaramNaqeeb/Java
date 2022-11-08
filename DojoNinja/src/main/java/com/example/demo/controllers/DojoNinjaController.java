package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.models.Dojo;
import com.example.demo.models.Ninja;
import com.example.demo.service.DojoService;
import com.example.demo.service.NinjaService;

@Controller
public class DojoNinjaController {

	private final DojoService dojoService;
	private final NinjaService ninjaService;

	public DojoNinjaController(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}

	@GetMapping("/dojo/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {

		return "dojo.jsp";
	}

	@PostMapping("/create/dojo")
	public String create(Model model, @Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "dojo.jsp";
		} else {
			dojoService.createDojo(dojo);
			List<Dojo> allDojos = dojoService.allDojos();
			model.addAttribute("allDojos", allDojos);
			return "redirect:/ninja/new";
		}
	}

	@GetMapping("/ninja/new")
	public String newNinja(Model model, @ModelAttribute("ninja") Ninja ninja) {
		List<Dojo> allDojos = dojoService.allDojos();
		model.addAttribute("allDojos", allDojos);
		return "ninja.jsp";
	}

	@PostMapping("/create/ninja")
	public String create(Model model, @Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if (result.hasErrors()) {
			return "ninja.jsp";
		} else {
			ninjaService.createNinja(ninja);
			
			return "redirect:/dojo/"+ ninja.getDojo().getId();
		}
		}
		@GetMapping("/dojo/{dojoId}")
		public String showDojo(Model model, @PathVariable( "dojoId") Long dojoid) {
		Dojo myDojo=dojoService.findDojo(dojoid);
		model.addAttribute("dojo", myDojo);
			return "dashboard.jsp";
		

	}
	
	



}
