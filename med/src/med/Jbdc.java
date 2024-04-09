package med;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jbdc {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager
				.getConnection("jdbc:mysql://localhost:3306/mysql","root","yous31395713");
		
		System.out.println("connection created");
		
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
