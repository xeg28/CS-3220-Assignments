package hw3.model;

import java.util.Date;
import java.util.Calendar;

public class Patient {
	private int id;
	private String name;
	private Vaccine vaccine;
	private Date firstDose;
	private Date secondDose;
	
	public Patient() {}
	
	public Patient(String name, Vaccine vaccine, Date firstDose) {
		this.name = name;
		this.vaccine = vaccine;
		this.firstDose = firstDose;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Vaccine getVaccine() {
		return vaccine;
	}
	
	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}
	
	public Date getFirstDose() {
		return firstDose;
	}
	
	public void setFirstDose(Date firstDose) {
		this.firstDose = firstDose;
	}
	
	public Date getSecondDose() {
		return secondDose;
	}
	
	public void setSecondDose(Date secondDose) {
		this.secondDose = secondDose;
	}
	
}
