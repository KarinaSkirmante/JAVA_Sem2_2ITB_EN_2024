package service;

import model.Course;
import model.Degree;
import model.Grade;
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
		
		
		Grade gr1 = new Grade();
		System.out.println(gr1);
		Grade gr2 = new Grade(4, st3, c3);// 4 for Davyd in Networking
		System.out.println(gr2);
		Grade gr3 = new Grade(10, st3, c2);// 10 for Davyd in Data Structure
		System.out.println(gr3);
		Grade gr4 = new Grade(7, st2, c2); //7 for Viktors in Data Structure
		System.out.println(gr4);
		Grade gr5 = new Grade(8, st2, c3);//8 for Viktors in Networking
		System.out.println(gr5);
		
		
		
		
		
		
		
		

	}

}
