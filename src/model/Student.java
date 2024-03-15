package model;
//TODO just checking
public class Student extends Person {
	
	//1. variables
	private long sID;

	
	private static long counter = 1000;
	
	//2.set and get
	
	public long getsID() {
		return sID;
	}
	public void setsID() {
		this.sID = counter;
		counter++;
	}
	
	//3. constructors
	public Student()
	{
		super();// Person() constructor will be called
		setsID();

	}
	
	public Student(String name, String surname, String personCode)
	{
		super(name, surname, personCode);//Person(String name, String surname, String personCode) will be called
		setsID();

	}
	
	//4. toString
	@Override
	public String toString() {
		return sID + ": "+ super.toString();
	}
	
	//5. other functions

}
