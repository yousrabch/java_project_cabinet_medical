package med;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface CertificatDAO extends DAO<Certificat> {

	Certificat get(Date date) throws SQLException;
	List<Certificat> getAll() throws SQLException;
	
	
	
}
