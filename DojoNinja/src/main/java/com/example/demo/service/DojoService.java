package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Dojo;
import com.example.demo.repository.DojoRepository;
@Service
public class DojoService {

	private final DojoRepository dojoRepository;

	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	public List<Dojo> allDojos() {
		return (List<Dojo>) dojoRepository.findAll();
	}

	public Dojo createDojo(Dojo d) {
		return dojoRepository.save(d);
	}

	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if (optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}
	
}
