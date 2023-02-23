package com.lt.crs.business;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lt.crs.utils.DBUtilsImpl;

// Course Operations goes here
public class CourseOperations implements CourseInterface {
	
	private Statement stmt;
	public Connection conn = DBUtilsImpl.conn;
	private ResultSet res;
	private String cname;
	private String cid;
	//public static String pname; // changed to static

	@Override
	public void courseRegistrationData() {
		// TODO Auto-generated method stub

	}

	@Override
	public void courseAvailability() {
		// TODO Auto-generated method stub

	}

	@Override
	public void courseStatus() {
		// TODO Auto-generated method stub

	}
	public void viewCourses() {
		System.out.println("-------------------------------");
		System.out.println("Course-Name"+"	"+"Course-ID");
		System.out.println("-------------------------------");
		//db.viewCourses();
		try {
			String sql= "Select * from Course";
			stmt=conn.createStatement();
			res=stmt.executeQuery(sql);
			while(res.next()==true) {
				cname=res.getString("CourseName");
				cid=res.getString("CourseID");
				System.out.println(cname+"		"+cid);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*	 Iterator  it = m.keySet().iterator();
		 while(it.hasNext())  
		 {  
			 int key=(int)it.next();  
			 Course c = (Course) m.get(key);  
			 System.out.println(c.getCourseName()+"		"+c.getCourseId());
		 } } */
		/*
		 * for(int i=0;i<cou.length;i++) { Course c= cou[i];
		 * System.out.println(c.getCourseName()+" "+
		 * c.getCourseId()+" "+c.getCourseFee());
		 * 
		 * }
		 */
	}
	@Override
	public void courseMapingForProfessor() {
		// TODO Auto-generated method stub

	}	}
