package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.Consultation;


public interface ConsultationDAO extends DAO<Consultation> {
	List<Consultation> getByDate(Date consultationDate, int id) throws SQLException;	
}
