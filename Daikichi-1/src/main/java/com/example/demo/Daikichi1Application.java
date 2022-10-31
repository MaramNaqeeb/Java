package com.example.demo;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

@RestController
@RequestMapping("/daikichi")
public class Daikichi1Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Daikichi1Application.class, args);
	}
	

		@RequestMapping(" ")
		public String hello(){
			return " Welcome";
		}
		
		@RequestMapping("/today")
		public String today() {
			return " today you will find luck in all your endeavors";
		}
		
		@RequestMapping("/tomorrow")
		public String tomorrow(){
			return "Tomorrow, an opportunity will arise, so be sure to open to new ideas";
		}
	
}
