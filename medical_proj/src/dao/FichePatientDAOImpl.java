package dao;

import com.FichePatient;
import com.Jdbc;
import com.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class FichePatientDAOImpl implements FichePatientDAO {

	
	
	@Override
	public int insert(FichePatient fichepatient) throws SQLException {
        Connection con = Jdbc.getConnection();
		
	String sql = "INSERT INTO FichePatient (fiche_id, patient_id, groupesanguin, poids, tailles, etatCivil, maladies_chroniques, allergies, vaccinations, antecedents) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, fichepatient.getFiche_id());
		ps.setInt(2, fichepatient.getPatient().getId());
		ps.setString(3, fichepatient.getGroupesanguin());
		ps.setInt(4, fichepatient.getPoids());
		ps.setInt(5, fichepatient.getTailles());
		ps.setString(6, fichepatient.getEtatCivil());
		ps.setString(7, fichepatient.getMaladies_chroniques());
		ps.setString(8, fichepatient.getAllergies());
		ps.setString(9, fichepatient.getVaccinations());
		ps.setString(10, fichepatient.getAntecedents());
		
		
		int result = ps.executeUpdate();
		
		
		Jdbc.closePreparedStatement(ps);
		Jdbc.closeConnection(con);
		
		return result;
}

	
	

	@Override
	public int delete(FichePatient fichepatient) throws SQLException {
	        Connection con = Jdbc.getConnection();

	String sql = "DELETE from FichePatient where fiche_id =? ";

	PreparedStatement ps = con.prepareStatement(sql);

	ps.setInt(1, fichepatient.getFiche_id());

	int result = ps.executeUpdate();

	Jdbc.closePreparedStatement(ps);
	Jdbc.closeConnection(con);

	return result;
	}

	
	
	
	@Override
	public FichePatient getById(int id) throws SQLException {
		Connection con = Jdbc.getConnection();
		
	    FichePatient fichepatient = null;
		String sql = "SELECT F.fiche_id, P.patient_id, P.lastName, P.firstName, F.groupesanguin, F.poids, F.tailles, F.etatCivil, F.maladies_chroniques, F.allergies, F.vaccinations, F.antecedents FROM FichePatient F, Patient P WHERE fiche_id=? ";
		
		PreparedStatement ps = con.prepareStatement (sql);
		
		ps.setInt(1, id);
		
		
		ResultSet rs = ps.executeQuery();
		
		
		if (rs.next()) {
			int ficheid = rs.getInt("fiche_id");
			int patientid = rs.getInt("patient_id");
			String lastname = rs.getString("lastName");
			String firstName = rs.getString("firstName");
			String groupesanguin = rs.getString("groupesanguin");
			int poids = rs.getInt("poids");
			int tailles = rs.getInt("tailles");
			String etatCivil = rs.getString("etatCivil");
			String maladies_chroniques= rs.getString("maladies_chroniques");
			String allergies=rs.getString("allergies");
			String vaccinations=rs.getString("vaccinations");
			String antecedents = rs.getString("antecedents");
			
			Patient patient = new Patient(patientid, lastname, firstName);
			
			fichepatient = new FichePatient(ficheid, patient, groupesanguin, poids, tailles, etatCivil, maladies_chroniques, allergies, vaccinations, antecedents);
			
		}else {
			fichepatient = null;
		}
			
		return fichepatient;
	}

	
	
	
	@Override
    public int update(FichePatient fichepatient) throws SQLException {
        Connection con = Jdbc.getConnection();

        String sql = "UPDATE FichePatient set fiche_id = ?, patient_id = ?, groupesanguin = ?, poids = ?, tailles = ?, etatCivil = ?, maladies_chroniques = ?, allergies = ?, vaccinations = ?, antecedents = ? Where fiche_id = ?";


        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, fichepatient.getFiche_id());
		ps.setInt(2, fichepatient.getPatient().getId());
		ps.setString(3, fichepatient.getGroupesanguin());
		ps.setInt(4, fichepatient.getPoids());
		ps.setInt(5, fichepatient.getTailles());
		ps.setString(6, fichepatient.getEtatCivil());
		ps.setString(7, fichepatient.getMaladies_chroniques());
		ps.setString(8, fichepatient.getAllergies());
		ps.setString(9, fichepatient.getVaccinations());
		ps.setString(10, fichepatient.getAntecedents());
		
		 ps.setInt(11, fichepatient.getFiche_id());
        
        int result = ps.executeUpdate();

        Jdbc.closePreparedStatement(ps);
        Jdbc.closeConnection(con);

        return result;

    }
}