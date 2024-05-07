package med;

import java.sql.SQLException;

public interface UserDAO {
	public User checkLogin(String email, String password) throws SQLException;
	public boolean isExist(String email,String cin) throws SQLException;
	public int register(Patient patient) throws SQLException;

}
