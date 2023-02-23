package com.lt.crs.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lt.crs.dao.StudentDAOInterface;
import com.lt.crs.dao.StudentDaoImpl;
// Student Operations goes here
public class StudentOperations implements StudentInterface{
	static Scanner s= new Scanner(System.in);
	StudentDaoImpl sdao= new StudentDaoImpl();

	public void viewCourses() {
		
	}
	public void updateStudentPwd() {
		
	}
	public void enrollToCourse() {
		
	}
	public void payFee() {
		
	}
	public void slotsAvailable() {
		
	}
	public void registerStudent() {
		System.out.println("*************** STUDENT REGISTRATION PAGE******************");
		List<String> l = new ArrayList<String>();
		System.out.println();
		System.out.println("Enter your Name: ");
		l.add(s.next());
		System.out.println("Enter your Email: ");
		l.add(s.next());
		System.out.println("Enter your DateOfBirth(DD-MM-YYYY): ");
		l.add(s.next());
		System.out.println("Create username: ");
		l.add(s.next());
		System.out.println("Create password: ");
		String pass1 = s.next();
		System.out.println("Confirm password: ");
		String pass2 = s.next();
		if(pass1.equals(pass2)){
			l.add(pass2);
			System.out.println("--------Successfully registered!--------- ");
			sdao.studentRegistration(l);
		}
		else
			System.out.println("Password does not match. Please verify.");
		System.out.println(l);
		System.out.println("-------------------------------------------");

		
	}
}
