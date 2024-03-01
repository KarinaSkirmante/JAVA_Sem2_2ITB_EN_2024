package model;

public class Professor {
	//1. variables
	private long pID;
	private String name;
	private String surname;
	private Degree profDegree;
	
	private static long counter = 0;
	
	public long getpID() {
		return pID;
	}
	public void setpID() {
		this.pID = counter;
		counter++;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name != null  && name.matches("[A-Z]{1}[a-z]{1,20}"))
			this.name = name;
		else
			this.name = "Undefinied";
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		if(surname != null && surname.matches("[A-Z]{1}[a-z]{1,20}"))
			this.surname = surname;
		else
			this.surname = "Undefinied";
	}
	public Degree getProfDegree() {
		return profDegree;
	}
	public void setProfDegree(Degree profDegree) {
		if(profDegree != null)
			this.profDegree = profDegree;
		else
			this.profDegree = Degree.other;
	}
		
	//2. set and get
	
	
	
	
	
	//3. constructors
	//4. toString
	//5. other functions

}
