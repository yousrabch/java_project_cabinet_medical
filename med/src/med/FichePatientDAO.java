package med;

import java.sql.SQLException;
import java.util.List;

public interface FichePatientDAO extends DAO<FichePatient> {

	List<FichePatient> getAll() throws SQLException;

	FichePatient getById(int id) throws SQLException;
}
