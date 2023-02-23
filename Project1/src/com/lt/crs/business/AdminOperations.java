package com.lt.crs.business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.Scanner;

import com.lt.crs.bean.Course;
import com.lt.crs.bean.Student;
import com.lt.crs.constant.SQLConstants;
import com.lt.crs.utils.DBUtilsImpl;
import com.lt.crs.utils.DummyJDBCOperations;
//Admin Operations goes here

public class AdminOperations implements AdminInterface {
	private static PreparedStatement pstmt;
	public static Connection conn = DBUtilsImpl.conn;

	static Student arr[];
	static Course cou[];
	static ArrayList<String> al= new ArrayList<String>();
	static ArrayList<String> al2= new ArrayList<String>();
	static DummyJDBCOperations db= new DummyJDBCOperations();
	static public Map m = new HashMap();
	private Statement stmt;
	private ResultSet res;
	public void enrolledStudents() {
		Student s1= new Student("Ramesh",1,"IT","Java",101);
		Student s2= new Student("Deepika",2,"IT","Java",101);
		Student s3= new Student("Bharati",3,"IT","Java",101);
		Student s4= new Student("Bharati",3,"IT","SQL",102);
		Student s5= new Student("Shiva",4,"IT","Java",101);
		Student s6= new Student("Shiva",4,"IT","SQL",102);
		arr= new Student[6];  
		arr[0]=s1;
		arr[1]=s2;
		arr[2]=s3;
		arr[3]=s4;
		arr[4]=s5;
		arr[5]=s6;
		//System.out.println(arr.length);
	}
	public void viewAllStudents() {
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("Student-Name"+"	"+ "Student-ID"+"	  "+ "Email ID"+"\t\t\t "+"DOB(DD-MM-YYYY)"+"	");
		System.out.println("---------------------------------------------------------------------------------");
	/*	for(int i=0;i<arr.length;i++) { // null pointer exception
			//System.out.println(arr.length);
			Student s= arr[i];
			System.out.println(s.getStudentName()+"		 "+ s.getStudentId()+"		"+ s.getCourseId()+"		"+s.getCoursseName()+"		"+ s.getDepartment());					
		} */
		try {
			stmt=conn.createStatement();
			res=stmt.executeQuery(SQLConstants.View_Students);
			while(res.next()==true) {
			System.out.println(res.getString("Name")+"		 "+ res.getInt("ID")+"		"+ res.getString("EmailID")+"		"+res.getString("DOB"));					

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void addGrades() {
		int score=0;
		for(int i=0;i<arr.length;i++) {
			Student s= arr[i];
			System.out.println("Enter the score of "+ s.getStudentName());
			Scanner sc= new Scanner(System.in);
			score=sc.nextInt();
			if(score>90)
			{
				s.setGrade('A');
			}else if(score>80 && score<90) {
				s.setGrade('B');
			}else if(score>70 && score<80) {
				s.setGrade('C');
			}else {
				s.setGrade('D');
			}

		} 

	}
	/*	static public void showGrades() {
		for(int i=0;i<arr.length;i++) {
			Student s= arr[i];
			System.out.println(s.getStudentName()+" "+ s.getGrade());

		}
	} */
	public void showGrades() {
		System.out.println("-------------------------------");
		System.out.println("Student-Name"+"	"+"Grade");
		System.out.println("-------------------------------");
		for(int i=0;i<arr.length;i++) {
			Student s= arr[i];
			System.out.println(s.getStudentName()+"		"+ s.getGrade());

		}
	}
	public void availableCourses() {

		Course c1 = new Course("Java", 101,5000);
		Course c2 = new Course("SQL", 102,3000);
		Course c3 = new Course("Oracle", 103,5000);
		Course c4 = new Course("DBMS", 104,4000);
		m.put(1, c1);
		m.put(2, c2);
		m.put(3, c3);
		m.put(4, c4);
		/*
		 * cou[0]=c1; cou[1]=c2; cou[2]=c3;
		 */

	}


	/* public Professor enrollProfessors() {
		Professor p1= new Professor("Deepika","Java","IT",101,"abcd1");
		Professor p2= new Professor("Awez","SQL","IT",102,"abcd2");
		Professor p3= new Professor("Shiva","Oracle","IT",103,"abcd3");
		Professor p4= new Professor("Pallavi","DBMS","IT",104,"abcd4");
		al2.add(p1.getCredential());
		al2.add(p2.getCredential());
		al2.add(p3.getCredential());
		al2.add(p4.getCredential());

		al.add(p1.getProfessorName());
		al.add(p2.getProfessorName());
		al.add(p3.getProfessorName());
		al.add(p4.getProfessorName());      
		return p1; 

	}  */
/*
	public boolean validation(int pid, String pwd) {
		/*	if(al.contains(name)==true && al2.contains(pwd)) {	
			return true;
		}
		else {
			return false;
		} 

		boolean b=db.validation(pid,pwd);
		if(b==true) {
			return true;
		}else return false; 

	} */
/*	public boolean registerProfessor(int pid, String name, String cname, int id, String dpt, String pwd) {
		// registering new professor
			Professor p= new Professor(name, cname, dpt, id, pwd);
		al.add(p.getProfessorName());
		al2.add(p.getCredential()); 
		boolean b=db.registerProfessor(pid, name, cname, id, dpt, pwd);
		if(b==true) {
			return true;
		}else return false;
	}  */
/*	public boolean updatePwdValidation(String pname, String ppwd, String npwd) {
		if(al.contains(pname)==true && al2.contains(ppwd)) {	
			int x = al.indexOf(pname);
			int y = al2.indexOf(ppwd);
			if(x==y) {
				al2.set(y, npwd);
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
*/

}
