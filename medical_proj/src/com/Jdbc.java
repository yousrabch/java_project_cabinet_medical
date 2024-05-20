package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Jdbc { 
	
	public static final String url = "jdbc:mysql://localhost:3306/cabinet_med";
	public static final String user = "root";
	public static final String pass =  "yous31395713";

private Jdbc () {}

public static Connection getConnection() throws SQLException {         
		
		Connection con= null;
			con =DriverManager.getConnection(url, user, pass);
			
			return con; }

public static void closeConnection(Connection con) throws SQLException {
	
	con.close();
}

public static void closeStatement(Statement statement) throws SQLException {
	
	statement.close();
}

public static void closePreparedStatement(PreparedStatement preparedStatement) throws SQLException {
	
	preparedStatement.close();
}

public static void closeResultSet(ResultSet resultSet)throws SQLException {
	
	resultSet.close();
}


	
	
}
