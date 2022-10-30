package com.caresoft.clinicapp;
import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
public Physician(Integer id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
//... imports class definition...
    
    // Inside class:    
	
  
    private String patienName;

	private ArrayList<String> patientNotes;

	private Date date;
	
    // TO DO: Constructor that takes an ID
  
    // TO DO: Implement HIPAACompliantUser!
	 public boolean assignPIN(int id) {
		 if(String.valueOf(id).length()==4) {
 			return true;
 		}
 		return false;
	 }
	 public boolean accessAuthorized(Integer id) {
			if (super.id==id) {
    			return true;
    		}
    		return false;
    	}
    
	 
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
	
    // TO DO: Setters & Getters
    public String getNotes() {
    	return getNotes();
    }
    public void setNotes( ArrayList<String> notes) {
    	this.patientNotes=notes;
    }
    public String getPatientName() {
    	return getPatientName();
    }
    public void setPatientName(String patientName) {
    	this.setPatienName(patientName);
    }
    
    public Date getDate() {
    	return date;
    }
    public void setDate(Date date) {
    	this.date=date;
    }

	public String getPatienName() {
		return patienName;
	}

	public void setPatienName(String patienName) {
		this.patienName = patienName;
	}
	@Override
	public boolean assignPin(int pin) {
		// TODO Auto-generated method stub
		return false;
	}

}
