package com.revature.util;

public class QueryConstants {
	public static final String INSERT_USER = "INSERT INTO QuestionManagement VALUES(?,?,?)";
	public static final String UPDATE_USER = "UPDATE QuestionManagement SET question_id=?,question_section=?,question_text=? WHERE  question_id=?";
	public static final String DELETE_USER= "DELETE FROM QuestionManagement WHERE question_id=?";
	public static final String SELECT_USER = "SELECT * FROM GD_LOGIN WHERE LOGIN_ID=? AND PASSWORD=?";
	public static final String SELECT_USER2 = "SELECT * FROM QuestionManagement WHERE question_id=?";
	public static final String SELECT_USER_BY_ID = "SELECT * FROM GD_LOGIN WHERE LOGIN_ID=?";
	public static final String SELECT_ALL_USER = "SELECT * FROM QuestionManagement ORDER BY question_id";
	public static final String SELECT_USERS_BY_ID_PATTERN = "SELECT * FROM GD_LOGIN WHERE LOGIN_ID LIKE ?";

}