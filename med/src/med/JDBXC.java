package med;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBXC{
   public static void main(String[] args) throws ClassNotFoundException, SQLException {
	   try{
	      Class.forName("com.mysql.cj.jdbc.Driver");
	    
	      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db","root","delena1706!");  

	      Statement stmt=con.createStatement();
	    
	      ResultSet rs=stmt.executeQuery("select * from user"); 

	     while(rs.next()) { 
	      System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
	     
	     con.close();  
	   
	     }}catch(Exception e){
			    System.out.println(e);
		 } 
 }
}
