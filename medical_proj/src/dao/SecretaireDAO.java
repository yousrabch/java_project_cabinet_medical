package dao;

import java.sql.SQLException;

import com.Secretaire;

public interface SecretaireDAO extends DAO<Secretaire>{

	Secretaire getSecritaire(String nom) throws SQLException;

}