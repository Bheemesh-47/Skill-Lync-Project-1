package com.lt.crs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.lt.crs.constant.Constants;
import com.lt.crs.constant.SQLConstants;
import com.lt.crs.utils.DBUtilsImpl;

public class StudentDaoImpl implements StudentDAOInterface{
	private static PreparedStatement pstmt;
	public static Connection conn = DBUtilsImpl.conn;

	public void studentRegistration(List studInp) {
		try {
		  pstmt = conn.prepareStatement(SQLConstants.SELECT_MAX_USER_ID); //SELECT_MAX_STUD_ID
		  
		  ResultSet rs = pstmt.executeQuery();
		  int max=0;
		  while(rs.next()){
			  max=rs.getInt("ID");
		  }
	      
		  pstmt = conn.prepareStatement(SQLConstants.ADD_STUDENT);
		  pstmt.setInt(1, ++max);  //id
		  pstmt.setString(2, (String)studInp.get(0)); //name
		  pstmt.setString(3, (String)studInp.get(1)); //email
		  pstmt.setString(4, (String)studInp.get(2)); //dob
		  pstmt.executeUpdate();
	      addUserByStudent(studInp);
	      System.out.println("******Student Added to CRS DB******");
	      pstmt.close();
	  }catch(Exception e){
		  e.printStackTrace();		  
	  }
		}

	public static void addUserByStudent(List studInp) throws SQLException{
	   pstmt = conn.prepareStatement(SQLConstants.SELECT_MAX_USER_ID);
	  ResultSet rs = pstmt.executeQuery();
	  int max=0;
	  
	  while(rs.next()){
		  max=rs.getInt("ID");
	  }
      
      pstmt = conn.prepareStatement(SQLConstants.ADD_USER_BY_STUDENT);
      pstmt.setInt(3, ++max);
      pstmt.setString(1, (String)studInp.get(3)); //username
      pstmt.setString(2, (String)studInp.get(4)); //password
      pstmt.setInt(4,Constants.student );
      pstmt.executeUpdate();
  }
  
}
