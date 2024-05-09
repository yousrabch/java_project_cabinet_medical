package med;

import java.sql.SQLException;


public interface FichePatientDAO extends DAO<FichePatient> {


	FichePatient getById(int id) throws SQLException;
}
