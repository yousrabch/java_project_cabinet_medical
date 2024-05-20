package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Dossier_medical;
import com.FichePatient;
import com.Jdbc;
import com.Patient;

public class Dossier_medDAOImpl implements DossierMedicaleDAO {

	@Override
	public int insert(Dossier_medical dossier) throws SQLException {
Connection con = Jdbc.getConnection();
		
		String sql = "INSERT INTO Dossier_medical (Num_dossier, Fiche_id, examens, notes, traitement, compterendu) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		
PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, dossier.getNum_dossier());
		ps.setInt(2, dossier.getPatient().getFiche_id());
		ps.setString(3, dossier.getExamens());
		ps.setString(4, dossier.getNotes());
		ps.setString(5, dossier.getTraitement());
		ps.setString(6, dossier.getCompterendu());
		
		
		
		int result = ps.executeUpdate();
		
		Jdbc.closePreparedStatement(ps);
		Jdbc.closeConnection(con);
		
		
		return result;
		}

	@Override
	public int update(Dossier_medical dossier) throws SQLException {
		Connection connection = Jdbc.getConnection();

		String sql = "UPDATE Dossier_medical SET num_dossier = ?, fiche_id = ?, examens = ?, notes = ?, traitement = ?, compterendu = ? WHERE num_dossier = ?";
	
		PreparedStatement ps = connection.prepareStatement(sql);
	
		ps.setInt(1, dossier.getNum_dossier());
		ps.setInt(2, dossier.getPatient().getFiche_id());
		ps.setString(3, dossier.getExamens());
		ps.setString(4, dossier.getNotes());
		ps.setString(5, dossier.getTraitement());
		ps.setString(6, dossier.getCompterendu());
		
		
		ps.setInt(7, dossier.getNum_dossier());
	
		
	
		int result = ps.executeUpdate();
	
		Jdbc.closePreparedStatement(ps);
		Jdbc.closeConnection(connection);
	
		return result;
	}

	@Override
	public int delete(Dossier_medical dossier) throws SQLException {
		Connection connection = Jdbc.getConnection();

		String sql = "DELETE FROM Dossier_medical WHERE num_dossier = ? and patient_id = ? ";
	
		PreparedStatement ps = connection.prepareStatement(sql);
	
		ps.setInt(1, dossier.getNum_dossier());
		ps.setInt(2, dossier.getPatient().getFiche_id());
	
		int result = ps.executeUpdate();
	
		Jdbc.closePreparedStatement(ps);
		Jdbc.closeConnection(connection);
	
		return result;
	}

	@Override
	public Dossier_medical get(int Num_dossier) throws SQLException {
		
		Connection con = Jdbc.getConnection();
        Dossier_medical dossier = null;

        String sql = "SELECT  F.fiche_id,P.*, F.groupesanguin, F.poids, F.tailles, F.etatCivil, F.maladies_chroniques, F.allergies, F.vaccinations, F.antecedents,"
        		+ "D.* "
        		+ " FROM Dossier_medical D, FichePatient F, Patient P WHERE D.num_dossier = ?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, Num_dossier);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
        	
        	
        	int id = rs.getInt("Fiche_id");
        	int idp = rs.getInt("patient_id");
        	String lastname = rs.getString("lastname");
        	String firstname = rs.getString("firstname");           
            Date dateNaiss=rs.getDate("date_n");
			String gender=rs.getString("Gender");
			String phone= rs.getString("phone");
			String email=rs.getString("email");
			String adresse=rs.getString("adress");
			String groupesanguin = rs.getString("groupesanguin");
			int poids = rs.getInt("poids");
			int tailles = rs.getInt("tailles");
			String etatCivil = rs.getString("etatCivil");
			String maladies_chroniques= rs.getString("maladies_chroniques");
			String allergies=rs.getString("allergies");
			String vaccinations=rs.getString("vaccinations");
			String antecedents = rs.getString("antecedents");
            
            
            Patient patient = new Patient(idp, lastname,firstname,  dateNaiss, gender,  phone, email, adresse);
            
            FichePatient fpatient = new FichePatient(id,patient, groupesanguin, poids, tailles, etatCivil, maladies_chroniques, allergies, vaccinations, antecedents);
            int num = rs.getInt("Num_dossier");
            String examens = rs.getString("examens");
            String notes = rs.getString("notes");
            String traitement = rs.getString("traitement");
            String compterendu = rs.getString("compterendu");
			

            

            dossier = new Dossier_medical(num, fpatient, examens, notes, traitement, compterendu) ;
		}else {
            throw new SQLException("Dossier médical non trouvé pour le numéro : " + Num_dossier);
        }

		Jdbc.closeResultSet(rs);
		Jdbc.closePreparedStatement(ps);
		Jdbc.closeConnection(con);

		return dossier;
	}

	

}

