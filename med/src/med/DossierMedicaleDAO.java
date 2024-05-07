package med;

import java.sql.SQLException;
import java.util.List;

public interface DossierMedicaleDAO extends DAO<Dossier_medical> {
	
	Dossier_medical get(int Num_dossier) throws SQLException;
	List<Dossier_medical> getAll() throws SQLException;
	
	

}
