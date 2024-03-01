package service;

import model.Course;
import model.Degree;
import model.Professor;
import model.Student;

public class MainService {

	public static void main(String[] args) {
		Professor pr1 = new Professor();//John Big - default Professor
		System.out.println(pr1);
		Professor pr2 = new Professor("Karina", "Skirmante", Degree.mg);
		System.out.println(pr2);
		Professor pr3 = new Professor("Estere", "Vitola", Degree.mg);
		System.out.println(pr3);
		Professor pr4 = new Professor("Marcis", "Naktins", Degree.mg);
		System.out.println(pr4);
		
		Student st1 = new Student();//Lara Bernardes student
		System.out.println(st1);
		Student st2 = new Student("Viktors", "Kokin");
		System.out.println(st2);
		Student st3 = new Student("Davyd", "Akimov");
		System.out.println(st3);
		
		Course c1 = new Course();
		System.out.println(c1);
		Course c2 = new Course("Data Structure", 2, pr3);
		System.out.println(c2);
		Course c3 = new Course("Networking", 4, pr4);
		System.out.println(c3);
		
		
		
		
		
		
		
		
		
		

	}

}
