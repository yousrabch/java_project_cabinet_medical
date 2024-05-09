package med;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {	
		
			Connection conn = 
				Jdbc.getConnection();
			
			if(conn != null) {
				
				System.out.println("connection created");	}
		
			//CertificatDAO certificatdao = new CertificatDAOImpl(); 
			//	Certificat certi =	new Certificat(10, 2024-12-11, "malade sucre", "je sertifier le malade");
			//int result = certificatdao.insert(certi);
			
			//System.out.println(result);
	}
	

	}


