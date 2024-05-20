package tests;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;


import com.Jdbc;


public class Main {

	public static void main(String[] args) {
		
		
		try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish connection
            Connection connection = DriverManager.getConnection(Jdbc.url, Jdbc.user, Jdbc.pass);
            
            // If connection is successful, print success message
            System.out.println("Connected to the database!");
            
            // Remember to close the connection when done
            connection.close();
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database!");
            e.printStackTrace();
        }
		
		
		
	}

}
