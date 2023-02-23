package com.lt.crs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lt.crs.constant.Constants;
import com.lt.crs.constant.SQLConstants;
import com.lt.crs.utils.DBUtilsImpl;

public class ProfessorDAOImpl implements ProfessorDAOInterface{


	private PreparedStatement pstmt;
	public Connection conn = DBUtilsImpl.conn;
	//private ResultSet res;
	//private String pname;
	@Override
	public boolean registerProfessor(String name, String cname, int cid, String dpt,String pwd) {

		try {

			pstmt = conn.prepareStatement(SQLConstants.SELECT_MAX_USER_ID); // max of user id
			  
			  ResultSet rs = pstmt.executeQuery();
			  int max=0;
			  while(rs.next()){
				  max=rs.getInt("ID");
			  }
			pstmt=conn.prepareStatement(SQLConstants.APPROVAL_STATUS);
			pstmt.setInt(1, Constants.professor);
			pstmt.setString(2,"Professor");
			pstmt.setInt(3,++max);
			pstmt.setString(4, name);
			pstmt.setString(5, Constants.status);
			if(Constants.status.equalsIgnoreCase("Approved"))
			{
				int y=pstmt.executeUpdate();
				if(y>0) {										  
					pstmt=conn.prepareStatement(SQLConstants.INSERT_USER);
					pstmt.setString(1,name);
					pstmt.setString(2, pwd);
					pstmt.setInt(3, max);  //
					pstmt.setInt(4,Constants.professor);
					int x= pstmt.executeUpdate();
					if(x>0) {

						pstmt=conn.prepareStatement(SQLConstants.INSERT_PROFESSOR);
						pstmt.setString(1,name);
						pstmt.setInt(2, max);//
						pstmt.setString(3,cname);
						pstmt.setInt(4, cid);
						pstmt.setString(5,dpt);						

						int x1= pstmt.executeUpdate();
						if(x1>0) {
							return true;
						}else {
							return false; } 
					}else {
						return false; } 
				}}else {return false;} 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


}
