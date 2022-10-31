package com.example.demo;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")

public class Daikichi2App {


	
	@RequestMapping("/travel/{place}")
		public String congrate(@PathVariable("place")String p){
		return "Congratulations! You will soon travel to" + " "+p;
		
	}
	
	@RequestMapping("/lotto/{number}")
	public String journey(@PathVariable("number") int n) {
		if ( n%2== 0){
		return "You will take a grand journey in the near future, but be weary of tempting offers";
		}
		
		return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends";
	}


}