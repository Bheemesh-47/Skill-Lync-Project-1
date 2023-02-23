package com.lt.crs.app;

import java.util.Scanner;

import com.lt.crs.business.AdminOperations;
import com.lt.crs.business.ProfessorOperations;
import com.lt.crs.business.StudentOperations;
import com.lt.crs.dao.AdminDAOImpl;
import com.lt.crs.utils.DBUtilsImpl;
import com.lt.crs.validation.LoginValidation;

public class CRSApplication {

	public static void main(String[] args) {
		//Professor p= new Professor();
		DBUtilsImpl db= new DBUtilsImpl(); // added by Deepika
		db.getConnection();
		LoginValidation lv= new LoginValidation();
		CRSAdminMenu am=new CRSAdminMenu();
		CRSStudentMenu sm= new CRSStudentMenu();
		CRSProfessorMenu pm = new CRSProfessorMenu();
		AdminOperations ao= new AdminOperations();
		ProfessorOperations po= new ProfessorOperations(); // Added by Deepika
		ao.enrolledStudents();
		ao.availableCourses();
		AdminDAOImpl adao= new AdminDAOImpl();
		
		StudentOperations so= new StudentOperations();
		System.out.println(" ********  Welcome to CRS Application ********* ");
		System.out.println("---------------------------------------------------------------");
		while(true) {
			System.out.println(" Please Select the required option  ");
			System.out.println("---------------------------------------------------------------");
			System.out.println("	1.Login");
			System.out.println("	2.Sign Up");
			System.out.println("	3.Update Password");
			System.out.println("	4.Exit");
			System.out.println("---------------------------------------------------------------");				
			System.out.println();

			Scanner sc = new Scanner(System.in);
			int option=sc.nextInt();
			if(option==1) {
				System.out.println("Login Process Initaited");
				System.out.println();
				System.out.println(" Please enter your ID");
				int id= sc.nextInt();
				System.out.println(" Please enter your Password");
				String pwd=sc.next();
				if(lv.userValidation(id, pwd)==true) {
					if(LoginValidation.role.equals("Admin")) {	 // not going inside 	LoginValidation.role				
						am.admin(); // Calling CRSAdmin Menu
						System.out.println("---------------------------------------------------------------");
					}else if(LoginValidation.role.equals("Student")) {
						sm.student(); // Calling CRSStudentMenu
						System.out.println("---------------------------------------------------------------");
					}else{
						pm.professor();
						System.out.println("---------------------------------------------------------------");
					}
				}else {
					System.out.println("************************************************************");
					System.out.println("Invalid User");
					System.out.println("************************************************************");
				}

			}else if(option==2) {
				System.out.println("************************************************************");
				System.out.println(" Please Select the required option  ");				
				System.out.println("1. Student Registration");
				System.out.println("2. Professor Registration");
				System.out.println("3. Exit");

				System.out.println("---------------------------------------------------------------");
				System.out.println(" Please enter your option");
				int op= sc.nextInt();
				if(op==1) {
					    so.registerStudent();
				}else if(op==2){
					po.professorReg();										
				}else {
					break;}								
				}else if(option==3) {
				adao.passwordUpdation();
				}else {
				break;				
			}
		}
		System.out.println("---------------------------------------------------------------");
		System.out.println("Thank you, Have a nice day!");
		db.closeConnection();

	} }
