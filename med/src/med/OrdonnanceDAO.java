package med;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface OrdonnanceDAO extends DAO<Ordonnance> {
	
	Ordonnance get(Date date) throws SQLException;
	List<Ordonnance> getAll() throws SQLException;

}
