package model;

public class Student {
	
	//1. variables
	private long sID;
	private String name;
	private String surname;
	
	private static long counter = 1000;
	
	//2.set and get
	
	public long getsID() {
		return sID;
	}
	public void setsID() {
		this.sID = counter;
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
	//3. constructors
	public Student()
	{
		setsID();
		setName("Lara");
		setSurname("Bernardes");

	}
	
	public Student(String name, String surname)
	{
		setsID();
		setName(name);
		setSurname(surname);
	}
	
	//4. toString
	
	public String toString() {
		return sID + ": "+ name + " " + surname;
	}
	
	//5. other functions

}
