package med;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Jbdc { 
	
	static final String url = "jdbc:mysql://localhost:3306/";
	static final String user = "root";
	static final String pass =  "yous31395713";

private Jbdc () {}

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

public static void main(String[] args) throws SQLException {	
		
	//	Connection conn = 
	//			Jbdc.getConnection();
	//	
	//	if(conn != null) {
			
	//		System.out.println("connection created");	}
	
		CertificatDAO certificatdao = new CertificatDAOImpl(); 
			Certificat certi =	new Certificat(10, 2024-12-11, "malade sucre", "je sertifier le malade");
		int result = certificatdao.insert(certi);
		
		System.out.println(result);
}	
	
}


