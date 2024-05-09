package med;

import java.sql.SQLException;

public interface UserDAO {
	public User checkLogin(String email, String password) throws SQLException;
	public boolean isExist(String email) throws SQLException;
	

}
