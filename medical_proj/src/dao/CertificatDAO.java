package dao;

import java.sql.SQLException;
import java.util.Date;


import com.Certificat;


public interface CertificatDAO extends DAO<Certificat> {

	Certificat get(Date date,int id) throws SQLException;
	
	
	
	
}