package med;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public interface OrdonnanceDAO extends DAO<Ordonnance> {
	
	Ordonnance get(LocalDateTime date) throws SQLException;
	List<Ordonnance> getAll() throws SQLException;

}
