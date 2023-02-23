package com.lt.crs.utils;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

// Data Base Utils Implementation
public class DBUtilsImpl implements DBUtilsInterface{
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/test";
	//  Database credentials
	static final String USER = "root";
	static final String PASS = "root";
	public static Connection conn;
	public static String pname;// added by Deepika

	@Override
	public void getConnection() {
		// TODO Auto-generated method stub

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
