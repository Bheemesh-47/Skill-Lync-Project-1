package com.lt.crs.business;

import java.util.Scanner;
import com.lt.crs.dao.AdminDAOImpl;


// Professor Operations goes here
public class ProfessorOperations implements ProfessorInterface{
	public static AdminDAOImpl adao= new AdminDAOImpl();
	@Override
	public void professorReg() {
		Scanner sc= new Scanner(System.in);
		System.out.println("---------------------------------------------------------------");
		System.out.println("Professor Registration Process Initaited");
		System.out.println();
		System.out.println("Please enter your Name");
		String name=sc.next();
		//System.out.println("Please enter your ID");
		//int pid=0;
		System.out.println("Please enter the Course Name");
		String cname=sc.next();					
		System.out.println("Please enter the Course ID");
		int id= sc.nextInt();
		System.out.println("Please enter the Department");
		String dpt=sc.next();
		System.out.println("Please set the Password");
	    String pwd=sc.next();
	    boolean b=adao.approval(name,cname,id,dpt,pwd);
		//boolean b=po.registerProfessor(pid,name,cname,id,dpt,pwd); // changed from ao to po
		if(b==true) {
			System.out.println("************************************************************");
			System.out.println("User Registered successfully");
			System.out.println("************************************************************");
		 }else {System.out.println("************************************************************");
			System.out.println("User Registration Failed");
			System.out.println("************************************************************");
		}
		
	}

}
