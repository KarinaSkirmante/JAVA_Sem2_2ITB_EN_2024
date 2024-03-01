package model;

public class Course {

	//1.variables
	private long cID;
	private String title;
	private int creditPoints;
	private Professor professor;
	
	private static long counter = 100000;
	
	
	
	//2.get and set
	public long getcID() {
		return cID;
	}
	public void setcID() {
		this.cID = counter;
		counter++;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		if(title != null && title.matches("[A-Za-z 0-9]{4,40}"))
			this.title = title;
		else
			this.title = "Undefined";
	}
	public int getCreditPoints() {
		return creditPoints;
	}
	public void setCreditPoints(int creditPoints) {
		if(creditPoints > 0 && creditPoints <= 20)
			this.creditPoints = creditPoints;
		else
			this.creditPoints = 2;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		if(professor != null)
			this.professor = professor;
		else
			this.professor = new Professor();
	}

	//3.constructors
	public Course() {
		setcID();
		setTitle("JAVA");
		setCreditPoints(4);
		setProfessor(new Professor());
	}
	
	public Course(String title, int creditPoints, Professor professor) {
		setcID();
		setTitle(title);
		setCreditPoints(creditPoints);
		setProfessor(professor);
	}
		
	
	//4.toSTring
	@Override
	public String toString() {
		return cID + ": " + title + " (" + creditPoints + " CP), " 
	+ professor.getName().charAt(0) + ". " + professor.getSurname();
	}
	
	
	
	
	//5.other functions
}
