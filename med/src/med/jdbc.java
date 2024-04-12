package med;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
 
      try {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","Bateaucasse3");
		System.out.println(con);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
	}
}
