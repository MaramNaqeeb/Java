package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Language;
import com.example.demo.repository.LanguageRepository;

@Service	
public class LanuageService {

	private final LanguageRepository languageRepository;
	

	public LanuageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}


	public List<Language> findAll() {
		return  languageRepository.findAll();
	}

	public Language createLanguage(Language l) {
		return languageRepository.save(l);
	}
	
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if (optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		} else {
			return null;
		}
	}
	public void destroy(Long id) {
		languageRepository.deleteById(id);
	}
	
	public Language update(Language lang) {
		return languageRepository.save(lang);
	}
}

