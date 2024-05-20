package dao;

import java.sql.SQLException;


import com.Dossier_medical;

public interface DossierMedicaleDAO extends DAO<Dossier_medical> {
	
	Dossier_medical get(int Num_dossier) throws SQLException;
	
	
	

}
