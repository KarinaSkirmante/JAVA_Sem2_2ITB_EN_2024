package service;

import java.util.ArrayList;
import java.util.Arrays;

import model.Course;
import model.Degree;
import model.Grade;
import model.Person;
import model.Professor;
import model.Student;

public class MainService {

	private static ArrayList<Person> allPersons = new ArrayList<Person>();
	private static ArrayList<Course> allCourses = new ArrayList<Course>();
	private static ArrayList<Grade> allGrades = new ArrayList<Grade>();

	public static void main(String[] args) {
		Professor pr1 = new Professor();// John Big - default Professor
		Professor pr2 = new Professor("Karina", "Skirmante", "122334-34567", Degree.mg);
		Professor pr3 = new Professor("Estere", "Vitola", "213243-23456", Degree.mg);
		Professor pr4 = new Professor("Marcis", "Naktins", "234123-45632", Degree.mg);

		allPersons.addAll(Arrays.asList(pr1, pr2, pr3, pr4));

		Student st1 = new Student();// Lara Bernardes student
		Student st2 = new Student("Viktors", "Kokin", "123456-09876");
		Student st3 = new Student("Davyd", "Akimov", "121298-67894");
		allPersons.addAll(Arrays.asList(st1, st2, st3));

		for (Person tempP : allPersons) {
			System.out.println(tempP);
		}

		Course c1 = new Course();
		Course c2 = new Course("Data Structure", 2, pr3);
		Course c3 = new Course("Networking", 4, pr4);
		Course c4 = new Course("Object Oriented Programming I", 4, pr3);
		allCourses.addAll(Arrays.asList(c1, c2, c3, c4));

		for (Course tempCr : allCourses) {
			System.out.println(tempCr);
		}

		Grade gr1 = new Grade();
		Grade gr2 = new Grade(4, st3, c3);// 4 for Davyd in Networking
		Grade gr3 = new Grade(10, st3, c2);// 10 for Davyd in Data Structure
		Grade gr4 = new Grade(7, st2, c2); // 7 for Viktors in Data Structure
		Grade gr5 = new Grade(8, st2, c3);// 8 for Viktors in Networking
		Grade gr6 = new Grade(10, st2, c1);// 8 for Viktors in JAVA
		Grade gr7 = new Grade(5, st1, c1);// 5 for Lara in JAVA
		allGrades.addAll(Arrays.asList(gr1, gr2, gr3, gr4, gr5, gr6, gr7));

		for (Grade tempGr : allGrades) {
			System.out.println(tempGr);
		}

		try {
			System.out.println(st2.getName() + " " + st2.getSurname() + " -> " + calculateAVGForStudent(st2));

			System.out.println(st2.getName() + " " + st2.getSurname() + " -> " + calculateWeightedAVGForStudent(st2));

			System.out.println(st3.getName() + " " + st3.getSurname() + " -> " + calculateAVGForStudent(st3));

			System.out.println(st3.getName() + " " + st3.getSurname() + " -> " + calculateWeightedAVGForStudent(st3));

			System.out.println(c2.getTitle() + " -> " + calculateAVGInCourse(c2));
			System.out.println(c3.getTitle() + " -> " + calculateAVGInCourse(c3));

			System.out.println(pr4.getName() + " " + pr4.getSurname() + " leads "
					+ calculateHowManyCoursesbyProfessor(pr4) + " courses");

			System.out.println(pr3.getName() + " " + pr3.getSurname() + " leads "
					+ calculateHowManyCoursesbyProfessor(pr3) + " courses");

			System.out.println("------------------------");
			for (Person tempP : allPersons) {
				if (tempP instanceof Student) {
					Student tempSt = (Student) tempP;
					System.out.println(
							tempSt.getName() + " " + tempSt.getSurname() + " -> " + calculateAVGForStudent(tempSt));
				}
			}

			sortStudents();
			System.out.println("------------------------");
			for (Person tempP : allPersons) {
				if (tempP instanceof Student) {

					Student tempSt = (Student) tempP;
					System.out.println(
							tempSt.getName() + " " + tempSt.getSurname() + " -> " + calculateAVGForStudent(tempSt));
				}
			}

			System.out.println("---------------CRUD-----------------");

			Student temp = retreiveStudentByPersonCode("123456-09876");
			System.out.println("Retrieve student->" + temp);

			createStudent("Sarah", "Green", "456789-87654");

			System.out.println("Create student testing (Sarah) -> ");
			for (Person tempP : allPersons) {
				if (tempP instanceof Student) {
					System.out.println(tempP);
				}
			}

			updateStudentByPersonCode("Viktors", "Sorkin", "123456-09876");
			System.out.println("Update student testing (Viktors) -> ");
			for (Person tempP : allPersons) {
				if (tempP instanceof Student) {
					System.out.println(tempP);
				}
			}

			deleteStudentByPersonCode("121298-67894");

			System.out.println("Delete student testing (Davyd) -> ");
			for (Person tempP : allPersons) {
				if (tempP instanceof Student) {
					System.out.println(tempP);
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static float calculateAVGForStudent(Student inputStudent) throws Exception {
		if (inputStudent == null)
			throw new Exception("Problems with input");

		float sum = 0;
		int howMany = 0;

		for (Grade tempGr : allGrades) {
			if (tempGr.getStudent().equals(inputStudent)) {
				sum = sum + tempGr.getValue();
				howMany++;
			}
		}

		return sum / howMany;

	}

	// JAVA 6 and DataStructure 8 AVG = (6+8)/2 = 7
	// JAVA 6 (4CP) DataStructure 8 (2CP) = ((6 * 4CP) + (8 * 2CP))/ (4CP +2CP) =
	// (24 +16)/6= 40/6 = 6.666

	public static float calculateWeightedAVGForStudent(Student inputStudent) throws Exception {
		if (inputStudent == null)
			throw new Exception("Problems with input");

		float sum = 0;
		int howManyCP = 0;

		for (Grade tempGr : allGrades) {
			if (tempGr.getStudent().equals(inputStudent)) {
				sum = sum + tempGr.getValue() * tempGr.getCourse().getCreditPoints();
				howManyCP = howManyCP + tempGr.getCourse().getCreditPoints();
			}
		}

		return sum / howManyCP;

	}

	public static float calculateAVGInCourse(Course inputCourse) throws Exception {
		if (inputCourse == null)
			throw new Exception("Problems with input");

		float sum = 0;
		int howMany = 0;

		for (Grade tempGr : allGrades) {
			if (tempGr.getCourse().equals(inputCourse)) {
				sum = sum + tempGr.getValue();
				howMany++;
			}
		}

		return sum / howMany;

	}

	public static int calculateHowManyCoursesbyProfessor(Professor inputProfessor) throws Exception {
		if (inputProfessor == null)
			throw new Exception("Problems with input");

		int howMany = 0;

		for (Course tempCr : allCourses) {
			if (tempCr.getProfessor().equals(inputProfessor)) {
				howMany++;
			}
		}

		return howMany;
	}

	public static void sortStudents() throws Exception {

		for (int i = 0; i < allPersons.size(); i++) {
			for (int j = 0; j < allPersons.size(); j++) {

				if (allPersons.get(i) instanceof Student && allPersons.get(j) instanceof Student) {
					Student tempI = (Student) allPersons.get(i);
					Student tempJ = (Student) allPersons.get(j);
					if (calculateAVGForStudent(tempJ) < calculateAVGForStudent(tempI)) {
						Student temp = (Student)allPersons.get(i);
						allPersons.set(i, allPersons.get(j));
						allPersons.set(j, temp);
					}
				}
			}
		}
	}

	// TODO
	// calculates how many professors have phd as degree

	public static int howManyProfessorsHavePHD() {

		int howMany = 0;

		for (Person tempP : allPersons) {
			if (tempP instanceof Professor) {
				Professor tempPr = (Professor) tempP;
				if (tempPr.getProfDegree().equals(Degree.phd)) {
					howMany++;
				}
			}
		}

		return howMany;

	}
	// calculates how many grades are smaller than 4 in specific course
	// calculates how many CP professor need to lead

	// CRUD C - create; R - retrieve, U - update, D - delete

	public static Student retreiveStudentByPersonCode(String inputPersonCode) throws Exception {
		// TODO
		// 1. do validation
		if (inputPersonCode == null)
			throw new Exception("Problems with input args");
		// 2. need to go through allStuents list and need to check if this student is in
		// the list

		// an example of for loop
		/*
		 * for(int i = 0 ; i < allStudents.size();i++) {
		 * if(allStudents.get(i).getPersonCode().equals(inputPersonCode)) { return
		 * allStudents.get(i); } }
		 */

		for (Person tempP : allPersons) {
			if (tempP instanceof Student && tempP.getPersonCode().equals(inputPersonCode)) {
				// 3. if it is - need to return this student
				return (Student) tempP;
			}
		}
		// 4. after for loop it is necessary to throw an execption (There is not such
		// student)

		throw new Exception("Student is not found");

	}

	public static void createStudent(String inputName, String inputSurname, String inputPersonCode) throws Exception {
		// TODO
		// 1. do validation
		if (inputName == null || inputSurname == null || inputPersonCode == null)
			throw new Exception("Problems with input args");
		// 2. need to go through every student in the allStudents arraylist
		// 3. need to check if there is already student with the same personCode
		for (Person tempP : allPersons) {
			if (tempP instanceof Student && tempP.getPersonCode().equals(inputPersonCode)) {
				// 4. if it is - throw an exception
				throw new Exception("Student is already in the system");
			}
		}
		// 5. if it is not - create a new student
		Student student = new Student(inputName, inputSurname, inputPersonCode);
		// 6. store this student in allStudents arraylist
		allPersons.add(student);

	}

	public static void updateStudentByPersonCode(String inputName, String inputSurname, String inputPersonCode)
			throws Exception {
		// 1. do validation
		if (inputName == null || inputSurname == null || inputPersonCode == null)
			throw new Exception("Problems with input args");

		// 2. search the student by its personCode
		for (Person tempP : allPersons) {
			if (tempP instanceof Student && tempP.getPersonCode().equals(inputPersonCode)) {
				// 3. update name and surname
				tempP.setName(inputName);
				tempP.setSurname(inputSurname);
				return;
			}
		}
		// 4. throw an exceptions if there is not such student
		throw new Exception("Student is not found");

	}

	public static void deleteStudentByPersonCode(String inputPersonCode) throws Exception {
		if (inputPersonCode == null)
			throw new Exception("Problems with input args");

		for (Person tempP : allPersons) {
			if (tempP instanceof Student && tempP.getPersonCode().equals(inputPersonCode)) {
				allPersons.remove(tempP);
				return;
			}
		}

		throw new Exception("Student is not found");

	}

}
