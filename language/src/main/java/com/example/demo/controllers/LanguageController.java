package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.models.Language;
import com.example.demo.service.LanuageService;

@Controller
public class LanguageController {

	private final LanuageService languageService;

	public LanguageController(LanuageService languageService) {
		this.languageService = languageService;
	}

	@GetMapping("/languages")
	public String allLanguages(Model model, @ModelAttribute("language") Language language) {
		List<Language> allLanguages=languageService.findAll();
		model.addAttribute("allLanguages", allLanguages);
		
		return "root.jsp";

	}

	@PostMapping("/create")
	public String post(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Language> allLanguages=languageService.findAll();
			model.addAttribute("allLanguages", allLanguages);
			return "root.jsp";
		} else {
			languageService.createLanguage(language);
			return "redirect:/languages";
		}
	}

	@GetMapping("/languages/edit/{languageId}")
		public String editLang(@PathVariable("languageId") Long id,Model model) {
			Language language=languageService.findLanguage(id);
			model.addAttribute("language", language);
			return"edit.jsp";
	}

	@PutMapping("/edit")
		public String edit(@Valid @ModelAttribute("language") Language language, BindingResult result){
			if(result.hasErrors()) {
				return"edit.jsp";
			}else {
				languageService.update(language);
				return "redirect:/languages";
			}
		}
	@DeleteMapping("/languages/{id}")
	public String delete(@PathVariable("id") Long id) {
		languageService.destroy(id);
		return"redirect:/languages";
	}
	
	@GetMapping("/languages/{languageId}")
	public String show(@PathVariable("languageId")Long id, Model model) {
		Language language=languageService.findLanguage(id);
		model.addAttribute("language", language);
		return"show.jsp";
		
	}
}
