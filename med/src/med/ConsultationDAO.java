package med;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface ConsultationDAO extends DAO<Consultation> {
	List<Consultation> getByDate(Date consultationDate) throws SQLException;	
}
