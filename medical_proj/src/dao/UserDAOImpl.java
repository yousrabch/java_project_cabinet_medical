package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Jdbc;
import com.User;

public class UserDAOImpl implements UserDAO{

	@Override
	public User checkLogin(String email, String password) throws SQLException {
		Connection con = Jdbc.getConnection();
		
		String query = "SELECT * FROM user WHERE email = ? and password = ?";
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1,email);
		ps.setString(2,password);
		ResultSet result = ps.executeQuery();
		
		User user = null;
		
		if(result.next()) {
			String nom = result.getString("firstName");
			String prenom = result.getString("lastName");
			String phone = result.getString("phone");
			
			user = new User(nom,prenom,phone,email,password);
		}

		Jdbc.closePreparedStatement(ps);
		Jdbc.closeConnection(con);
		

		return user;
	}

	@Override
	public boolean isExist(String email) throws SQLException {
		
		boolean exist = true;
        Connection con = Jdbc.getConnection();
        String query = "SELECT id_user FROM user WHERE email =?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, email);
        ResultSet result = ps.executeQuery();

        exist = result.next() ? true : false;

        Jdbc.closePreparedStatement(ps);
        Jdbc.closeConnection(con);


        return exist ;
	}

}
