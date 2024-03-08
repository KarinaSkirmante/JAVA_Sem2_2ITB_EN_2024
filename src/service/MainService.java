package service;

import java.util.ArrayList;
import java.util.Arrays;

import model.Course;
import model.Degree;
import model.Grade;
import model.Professor;
import model.Student;

public class MainService {

	
	private static ArrayList<Professor> allProfessors = new ArrayList<Professor>();
	private static ArrayList<Student> allStudents = new ArrayList<Student>();
	private static ArrayList<Course> allCourses = new ArrayList<Course>();
	private static ArrayList<Grade> allGrades= new ArrayList<Grade>();
	
	public static void main(String[] args) {
		Professor pr1 = new Professor();//John Big - default Professor
		Professor pr2 = new Professor("Karina", "Skirmante", Degree.mg);
		Professor pr3 = new Professor("Estere", "Vitola", Degree.mg);
		Professor pr4 = new Professor("Marcis", "Naktins", Degree.mg);
		allProfessors.addAll(Arrays.asList(pr1, pr2, pr3, pr4));
		//TODO take a look to ArrayList class in JAVA documentations
		for(int i = 0; i < allProfessors.size(); i++) {
			System.out.println(allProfessors.get(i));
		}
		System.out.println("------------------------------");
		for(Professor tempPr : allProfessors) {
			System.out.println(tempPr);
		}
		System.out.println("------------------------------");
		
		
		
		Student st1 = new Student();//Lara Bernardes student
		Student st2 = new Student("Viktors", "Kokin");
		Student st3 = new Student("Davyd", "Akimov");
		allStudents.addAll(Arrays.asList(st1,st2,st3));
		
		for(Student tempSt: allStudents) {
			System.out.println(tempSt);
		}
		
		
		Course c1 = new Course();
		Course c2 = new Course("Data Structure", 2, pr3);
		Course c3 = new Course("Networking", 4, pr4);
		allCourses.addAll(Arrays.asList(c1, c2, c3));
		
		for(Course tempCr: allCourses) {
			System.out.println(tempCr);
		}
		
		Grade gr1 = new Grade();
		Grade gr2 = new Grade(4, st3, c3);// 4 for Davyd in Networking
		Grade gr3 = new Grade(10, st3, c2);// 10 for Davyd in Data Structure
		Grade gr4 = new Grade(7, st2, c2); //7 for Viktors in Data Structure
		Grade gr5 = new Grade(8, st2, c3);//8 for Viktors in Networking
		Grade gr6 = new Grade(10, st2, c1);//8 for Viktors in Networking
		
		allGrades.addAll(Arrays.asList(gr1,gr2, gr3, gr4, gr5, gr6));
		
		for(Grade tempGr: allGrades) {
			System.out.println(tempGr);
		}
		
		try
		{
			System.out.println(st2.getName() + " " + st2.getSurname() + " -> "
				+calculateAVGForStudent(st2));
			
			System.out.println(st2.getName() + " " + st2.getSurname() + " -> "
					+calculateWeightedAVGForStudent(st2));
		
			System.out.println(st3.getName() + " " + st3.getSurname() + " -> "
				+calculateAVGForStudent(st3));
			
			System.out.println(st3.getName() + " " + st3.getSurname() + " -> "
					+calculateWeightedAVGForStudent(st3));
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		
	}
	
	
	
	
	public static float calculateAVGForStudent(Student inputStudent) throws Exception {
		if(inputStudent == null) throw new Exception("Problems with input");
		
		
		float sum = 0;
		int howMany = 0;
		
		
		for(Grade tempGr : allGrades) {
			if(tempGr.getStudent().equals(inputStudent)) {
				sum = sum + tempGr.getValue();
				howMany++;
			}
		}
		
		
		return sum/howMany;
			
	}
	
	//JAVA 6 and DataStructure 8 AVG = (6+8)/2 = 7
	//JAVA 6 (4CP) DataStructure 8 (2CP) = ((6 * 4CP) + (8 * 2CP))/ (4CP +2CP) = (24 +16)/6= 40/6 = 6.666
		
	public static float calculateWeightedAVGForStudent(Student inputStudent) throws Exception {
		if(inputStudent == null) throw new Exception("Problems with input");
		
		float sum = 0;
		int howManyCP = 0;
		
		
		for(Grade tempGr : allGrades) {
			if(tempGr.getStudent().equals(inputStudent)) {
				sum = sum + tempGr.getValue() * tempGr.getCourse().getCreditPoints();
				howManyCP = howManyCP + tempGr.getCourse().getCreditPoints();
			}
		}
		
		return sum/howManyCP;
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
