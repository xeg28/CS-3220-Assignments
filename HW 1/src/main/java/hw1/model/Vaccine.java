package hw1.model;

public class Vaccine {

	static int idSeed = 1;
	private int id;
    private String name;	
    private int dosesRequired;
    private int daysBetweenDoses;
    private int totalDosesReceived;
    private int totalDosesLeft;
    
    public Vaccine(String name, int dosesRequired, int daysBetweenDoses) {
    	this.id = idSeed++;
    	this.name = name;
    	this.dosesRequired = dosesRequired;
    	this.daysBetweenDoses = daysBetweenDoses;
    }
    
    public Vaccine(String name, int dosesRequired) {
    	this.id = idSeed++;
    	this.name = name;
    	this.dosesRequired = dosesRequired;
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

	public int getDosesRequired() {
		return dosesRequired;
	}

	public void setDosesRequired(int dosesRequired) {
		this.dosesRequired = dosesRequired;
	}
	
	public void setDaysBetweenDoses(int daysBetweenDoses) {
		this.daysBetweenDoses = daysBetweenDoses;
	}
	
	public int getDaysBetweenDoses() {
		return this.daysBetweenDoses;
	}
	
	public int getTotalDosesReceived() {
		return totalDosesReceived;
	}

	public void setTotalDosesReceived(int totalDosesReceived) {
		this.totalDosesReceived = totalDosesReceived;
	}

	public int getTotalDosesLeft() {
		return totalDosesLeft;
	}

	public void setTotalDosesLeft(int totalDosesLeft) {
		this.totalDosesLeft = totalDosesLeft;
	}
    
	public void addNewDoses(int doses) {
		this.totalDosesReceived += doses;
		this.totalDosesLeft += doses;	
	}
    
	
}
