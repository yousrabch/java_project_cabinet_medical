package med;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		 try {
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	            Connection conn= Jdbc.getConnection();

	            if(conn!=null)
	                System.out.println("connection gg!");
	            else
	                System.out.print("connection fail");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        catch (SQLException e){
	            e.printStackTrace();
	        }
	    }
	

	}


