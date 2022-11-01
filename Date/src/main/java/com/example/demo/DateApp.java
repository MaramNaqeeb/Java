package com.example.demo;





import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class DateApp {
	// class definition and imports here...
	@RequestMapping("/")
	public String index() {
		return "dashboard.jsp";
	}
    @RequestMapping("/date")
    public String date(Model model) {
        Date date =new Date(0);
        SimpleDateFormat newdate= new SimpleDateFormat("EEEE,'the 'dd' of' MMMM ,YYYY");
        String formatdate=newdate.format(date);
        model.addAttribute("formatdate",formatdate);
        return "date.jsp";
    }
     @RequestMapping("/time")
    	    public String time(Model model) {
    	         Time time =new Time(0);
    	         SimpleDateFormat newtime= new SimpleDateFormat("h:mm a");
    	         String formattime=newtime.format(time);
    	         model.addAttribute("formattime",formattime);
    	        return "time.jsp";
    }
    
    


}
