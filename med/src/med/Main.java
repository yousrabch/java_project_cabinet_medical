package med;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import Jdbc;

public class Main {

	public static void main(String[] args) throws SQLException {	
		
			Connection conn = 
				Jdbc.getConnection();
			
			if(conn != null) {
				
				System.out.println("connection created");	}
		
			
			
			
	}
	

	}


