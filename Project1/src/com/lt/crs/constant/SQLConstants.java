package com.lt.crs.constant;

public class SQLConstants {
	public static final String ADD_STUDENT = "insert into student values(?,?,?,?)";
	public static final String ADD_USER_BY_STUDENT = "insert into user values(?,?,?,?)";
	public static final String VIEW_USERS = "select * from user where username=?";
	//public static final String SELECT_MAX_STUD_ID = "SELECT MAX(ID) as ID from user";
	public static final String SELECT_MAX_USER_ID = "SELECT MAX(ID) as ID from user";
	public static final String UPDATE_PASSWORD = "update user set password=? where name=?";
	public static final String View_Students = "Select * From Student";
	public static final String STUDENT_COUNT="Select count(*) From Student";
	public static final String APPROVAL_STATUS="Insert into ApprovalStatus values(?,?,?,?,?)";
	public static final String INSERT_USER="Insert into User values(?,?,?,?)";
	public static final String INSERT_PROFESSOR="Insert into Professor values(?,?,?,?,?)";
	//public static final String SELECT_MAX_PROF_ID="SELECT MAX(ID) as ID from User";

}
