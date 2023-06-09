package cs3220final.model;


import java.sql.Date;
import java.sql.Timestamp;

public class Reading {
	private int id;
	private User user;
	private int systolic;
	private int diastolic;
	private Timestamp readingTime;
	
	public Reading() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUserId() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getSystolic() {
		return systolic;
	}
	public void setSystolic(int systolic) {
		this.systolic = systolic;
	}
	public int getDiastolic() {
		return diastolic;
	}
	public void setDiastolic(int diastolic) {
		this.diastolic = diastolic;
	}
	public Timestamp getReadingTime() {
		return readingTime;
	}
	public void setReadingTime(Timestamp readingTime) {
		this.readingTime = readingTime;
	}
	
}
