package dao;

import java.sql.SQLException;
import java.util.List;

import com.Patient;

public interface PatientDAO extends DAO<Patient>{
	Patient getById(int id) throws SQLException;
	List<Patient> getAll() throws SQLException;

}
