package med;

import java.sql.SQLException;

public interface SecretaireDAO extends DAO<Secretaire>{

	Secretaire getSecritaire(String nom) throws SQLException;

}
