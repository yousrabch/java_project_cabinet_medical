package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.Ordonnance;

public interface OrdonnanceDAO extends DAO<Ordonnance> {
	
	Ordonnance get(Date date, int id1) throws SQLException;
	List<Ordonnance> getAll(int id) throws SQLException;

}
