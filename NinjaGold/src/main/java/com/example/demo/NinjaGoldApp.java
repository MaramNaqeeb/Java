package com.example.demo;

import java.awt.Window;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class NinjaGoldApp {
	 int myGold = 0;
	ArrayList<String> activities = new ArrayList<>();

	 @RequestMapping("/gold")
	    
		  public String index(Model model ,HttpSession session){
				if (session.getAttribute("myGold")==null) {
					session.setAttribute("myGold", 0);
				}
				model.addAttribute("gold",myGold);
				session.setAttribute("activities",activities);
				return "gold.jsp";
		
	        
	      
	    }

	@RequestMapping(value="/golds")
    public String process(@RequestParam(value="action")String action, HttpSession session) {
   
        if(action.equals("farm")) {
        	int earnedMoney = 10+(int)(Math.random()*10);
        	 myGold += earnedMoney;
        	 ArrayList<String> myarray =(ArrayList<String>)session.getAttribute("activities");
 			myarray.add("you entered a farm and earned "+ myGold);
 			session.setAttribute("activities", activities);
        
        }
        if(action.equals("cave")) {
            int earnedMoney1=  10+(int)(Math.random()*10);
           myGold += earnedMoney1;
           ArrayList<String> myarray =(ArrayList<String>)session.getAttribute("activities");
			myarray.add("you entered a cave and earned "+ myGold);
			session.setAttribute("activities", activities);
          
        }
         if(action.equals("house")) {
            int earnedMoney2 =  10+(int)(Math.random()*10);
                myGold += earnedMoney2;
                ArrayList<String> myarray =(ArrayList<String>)session.getAttribute("activities");
     			myarray.add("you entered a house and earned "+ myGold);
     			session.setAttribute("activities", activities);
               
         }
         if(action.equals("quest")) {
            int earnedMoney3 =  10+(int)(Math.random()*40);
               myGold += earnedMoney3;
               ArrayList<String> myarray =(ArrayList<String>)session.getAttribute("activities");
               myarray.add("you earned a quest and earned "+ myGold);
          int lossMoney =  10+(int)(Math.random()*40);
              myGold -= lossMoney;
             ArrayList<String> myarray1 =(ArrayList<String>)session.getAttribute("activities");
             myarray1.add("you lost a quest and lost "+ myGold);
            
   			session.setAttribute("activities", activities);
             
        
         
     
         }
         return "redirect:/gold";
	}
}

	




