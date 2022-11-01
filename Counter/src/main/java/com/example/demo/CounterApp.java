package com.example.demo;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/your_server")
public class CounterApp {

	@RequestMapping(" ")
		public String index(HttpSession session,Model model) {
			{
	    	// If the count is not already in session
			if (session.getAttribute("count") == null) {
			// Use setAttribute to initialize the count in session
				session.setAttribute("count", 0);
			}
			else {
			// increment the count by 1 using getAttribute and setAttribute
				// ...
					Integer currentCount = (Integer) session.getAttribute("count");
					currentCount++;
					session.setAttribute ("count", currentCount);
					model.addAttribute("count", session.getAttribute("count"));
					
				}
			
			return "server.jsp";
		}
	// ...

	
	}
	@RequestMapping("/counter")
	public String counter() {
		return "counter.jsp";
		
	}

}
