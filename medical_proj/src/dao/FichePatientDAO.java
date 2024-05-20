package dao;

import java.sql.SQLException;

import com.FichePatient;


public interface FichePatientDAO extends DAO<FichePatient> {


	FichePatient getById(int id) throws SQLException;
}
