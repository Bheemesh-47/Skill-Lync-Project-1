package com.lt.crs.validation;

import java.sql.*;

import com.lt.crs.utils.DBUtilsImpl;
import com.lt.crs.constant.*;

// Login Validations goes here
public class LoginValidation implements LoginValidations{
	
	private PreparedStatement pstmt;
	public Connection conn = DBUtilsImpl.conn;
	private ResultSet res;
	private int roleid;
	
	public static String role;
	public static String pname; // changed to static

	public boolean validation(int pid, String pwd) {
		try {
			//System.out.println(pid +" "+ pwd);
			//System.out.println(conn);
			pstmt=conn.prepareStatement("Select * From professor WHERE ID=? AND Password=?"); // error
			pstmt.setInt(1, pid);
			pstmt.setString(2,pwd);
			
			res=pstmt.executeQuery();
			if(res.next()==true) {
				pname= res.getString("Name"); 
				return true;
			}else {return false;}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updatePwdValidation(int pid, String pwd, String npwd) {
	try {
		pstmt=conn.prepareStatement("Select * from Professor where password=?");
		pstmt.setString(1,pwd);
		res=pstmt.executeQuery();
		if(res.next()==true) {
			pstmt= conn.prepareStatement("Update Professor set Password=? where ID=?" );
			
			pstmt.setString(1, npwd);	
			pstmt.setInt(2,pid);
			int x= pstmt.executeUpdate();
			if(x>0) {
				return true;
			}else {return false;}
			
		}
		else {
			return false;
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		return false;
		
	
	}

	@Override
	public boolean userValidation(int id, String pwd) {
		try {
			//System.out.println(id +" "+ pwd);
			//System.out.println(conn);
			pstmt=conn.prepareStatement("Select * From User WHERE ID=? AND Password=?"); // error
			pstmt.setInt(1, id);
			pstmt.setString(2,pwd);
			
			res=pstmt.executeQuery();
			if(res.next()==true) {
				pname= res.getString("Name"); 
				//id=res.getInt("ID");
				roleid=res.getInt("RoleID");
				System.out.println(pname+" "+id);				
		pstmt=conn.prepareStatement("Select * From Role WHERE RoleID=?"); // error
				pstmt.setInt(1, roleid);
				res=pstmt.executeQuery();
				while(res.next()==true) {
					role=res.getString("Role");
					System.out.println("Role  "+role);
				} 
				return true;
			}else {return false;}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updatePassword(int id, String pwd, String npwd) {
		try {
			pstmt=conn.prepareStatement("Select * from User where password=?");
			pstmt.setString(1,pwd);
			res=pstmt.executeQuery();
			if(res.next()==true) {
				pstmt= conn.prepareStatement("Update User set Password=? where ID=?" );
				pstmt.setString(1, npwd);	
				pstmt.setInt(2,id);
				int x= pstmt.executeUpdate();
				if(x>0) {
					return true;
				}else {return false;}
				
			}
			else {
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
			return false;			
			}
	

}
