package dao;

import java.sql.SQLException;

import com.User;

public interface UserDAO {
	public User checkLogin(String email, String password) throws SQLException;
	public boolean isExist(String email) throws SQLException;
	

}
