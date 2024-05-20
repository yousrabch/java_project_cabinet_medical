package dao;

import java.sql.SQLException;

public interface DAO <T> {

	int insert(T t) throws SQLException;
	int update(T t) throws SQLException;
	int delete(T t) throws SQLException;
	
}
