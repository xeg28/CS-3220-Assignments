package midterm.model;

import java.util.Date;
public class Request {
	static int idSeed = 1;
	
	private int id;
	private Date requestTime;
	private String scheduledFor;
	private String department;
	private String status;
	private String assignedTo;
	private String reason;
	
	public Request(Date requestTime, String scheduledFor, String department, String status ,String reason) {
		this.id = idSeed++;
		this.requestTime = requestTime;
		this.scheduledFor = scheduledFor;
		this.department = department;
		this.status = status;
		this.reason = reason;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}

	public String getScheduledFor() {
		return scheduledFor;
	}

	public void setScheduledFor(String scheduledFor) {
		this.scheduledFor = scheduledFor;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
}
