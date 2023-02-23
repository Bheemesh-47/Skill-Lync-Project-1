package com.lt.crs.dao;

import java.util.Scanner;

import com.lt.crs.validation.LoginValidation;

public class AdminDAOImpl implements AdminDAOInterface{

	ProfessorDAOImpl pdao= new ProfessorDAOImpl();
	Scanner sc = new Scanner(System.in);
	LoginValidation lv= new LoginValidation();
	
	public boolean approval(String name, String cname, int id, String dpt,String pwd) {
		// TODO Auto-generated method stub
		Boolean b=pdao.registerProfessor(name,cname,id,dpt,pwd);
		if(b==true) {
			return true;
		}
		return false;
	}
 
	public void passwordUpdation() {
		// TODO Auto-generated method stub
		System.out.println("---------------------------------------------------------------");
		System.out.println("Password Updation Process Initiated:");
		//	System.out.println("Please enter your Name");
		//	String pname=sc.next();
		System.out.println("Please enter your ID"); // Added by Deepika
		int pid=sc.nextInt();
		System.out.println("Please enter your Current Password");
		String ppwd=sc.next();
		System.out.println("Please enter New Password");
		String npwd=sc.next();
		boolean b = lv.updatePassword(pid,ppwd,npwd); // changed pname to pid by Deepika
		if(b==true) {
			String pname = lv.pname;// Line added by Deepika
			System.out.println("************************************************************");
			System.out.println("Password Updation successful");
			System.out.println("************************************************************");
		}else{
			System.out.println();
			System.out.println("************************************************************");
			System.out.println(" Updation failed");
			System.out.println("************************************************************");

		}

	}

	}
