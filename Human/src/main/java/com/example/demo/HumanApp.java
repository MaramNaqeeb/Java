package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HumanApp {
	
	@RequestMapping("/")
	public String index(@RequestParam(value="name",required=false,defaultValue= " "+"Human") String search) {
		return " hello"+ " "+search;
		
		
		}
	
	
}
	

