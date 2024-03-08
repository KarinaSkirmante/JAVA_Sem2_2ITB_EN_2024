package model;

public class Grade {
	
	//1. variables
	private long gID;
	private int value;
	private Student student;
	private Course course;
	
	private static long counter = 200000;
	
	
	//2. set and get functions
	public long getgID() {
		return gID;
	}

	public void setgID() {
		this.gID = counter;
		counter++;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		if(value > 0 && value <= 10)
			this.value = value;
		else
			this.value = 1;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		if(student != null)
			this.student = student;
		else
			this.student = new Student();
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		if(course != null)
			this.course = course;
		else
			this.course = new Course();
	}

	
	
	//3. constructors
	public Grade()
	{
		setgID();
		setValue(4);
		setStudent(new Student());
		setCourse(new Course());
	}
	

	public Grade(int value, Student student, Course course) {
		setgID();
		setValue(value);
		setStudent(student);
		setCourse(course);
	}
	
	//4. toString
	
	//20000: Viktors Kokin gets 8 in JAVA
	public String toString()
	{
		return gID + ": " + student.getName() + " " + student.getSurname() + " gets " + value +
				" in " + course.getTitle();
	}
	
	
	//5. other functions

}
