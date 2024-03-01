package service;

import model.Degree;
import model.Professor;

public class MainService {

	public static void main(String[] args) {
		Professor pr1 = new Professor();//John Big - default Professor
		System.out.println(pr1);
		Professor pr2 = new Professor("Karina", "Skirmante", Degree.mg);
		System.out.println(pr2);
		Professor pr3 = new Professor("Estere", "Vitola", Degree.mg);
		System.out.println(pr3);
		

	}

}
