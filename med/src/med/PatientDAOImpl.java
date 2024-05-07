package med;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PatientDAOImpl implements PatientDAO{

	@Override
	public int insert(Patient patient) throws SQLException {
        Connection con = Jdbc.getConnection();
		
	String sql = "INSERT INTO patient (idp, nomp, prenomp, birth_date, gender, PhonNum, email, adress ,num_doss) VALUES (?, ?, ?, ?, ?, ?, ?)";
	
	
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, patient.getId());
		ps.setString(2, patient.getNom());
		ps.setString(3, patient.getPrenom());
		ps.setDate(4, patient.getDateNaiss());
		ps.setString(5, patient.getGender());
		ps.setString(6, patient.getPhone());
		ps.setString(7, patient.getEmail());
		ps.setString(8, patient.getAdresse());
		ps.setInt(9, patient.getDoss().getId());
		
		int result = ps.executeUpdate();
		
		
		Jdbc.closePreparedStatement(ps);
		Jdbc.closeConnection(con);
		
		return result;
}

	@Override
	public int update(Patient patient) throws SQLException {
        Connection con = Jdbc.getConnection();
		
		String sql = "UPDATE patient set idp =?, nomp=? , prenomp=?, birth_date=? ,gender=?, PhonNum=?, email=?, num_doss=?";
		
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, patient.getId());
		ps.setString(2, patient.getNom());
		ps.setString(3, patient.getPrenom());
		ps.setDate(4, patient.getDateNaiss());
		ps.setString(5, patient.getGender());
		ps.setString(6, patient.getPhone());
		ps.setString(7, patient.getEmail());
		ps.setString(8, patient.getAdresse());
		ps.setInt(9, patient.getDoss().getId());
		
		int result = ps.executeUpdate();
		
		Jdbc.closePreparedStatement(ps);
		Jdbc.closeConnection(con);
		
		return result;
			
	}

	@Override
	public int delete(Patient patient) throws SQLException {
        Connection con = Jdbc.getConnection();
		
		String sql = "DELETE from patient where idp =? ";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, patient.getId());
		
		int result = ps.executeUpdate();
		
		Jdbc.closePreparedStatement(ps);
		Jdbc.closeConnection(con);
		
		return result;
	}


	@Override
	public Patient getById(int id) throws SQLException {
		Connection con = Jdbc.getConnection();
		
	    Patient patient = null;
		String sql = "SELECT * FROM patient WHERE idp=?";
		PreparedStatement ps = con.prepareStatement (sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			int idp = rs.getInt("id");
			String nom = rs.getString("nom");
			String prenom = rs.getString("prenom");
			Date dateNaiss=rs.getDate("birthDate");
			String gender=rs.getString("sex");
			String email=rs.getString("email");
			String adresse=rs.getString("adress");
			String password=rs.getString("password");
			String phone= rs.getString("phone");
			
			
			patient = new Patient(nom,prenom, phone, email, password, idp, dateNaiss, adresse, gender);
			
		}else {
			patient = null;
		}
			
		return patient;
	}

	
	@Override
	public List<Patient> getAll() throws SQLException {

		Connection con = Jdbc.getConnection();
		
		String sql = "SELECT * FROM patient";
		List<Patient> patients = new ArrayList<>();
		
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String nom = rs.getString("nom");
			String prenom = rs.getString("prenom");
			Date dateNaiss = rs.getDate("date de naissance");
			String gender = rs.getString("sexe");
			Dossier_Medical doss= new Dossier_medical();
			String adresse = rs.getString("adresse");
			String phone = rs.getString("numero de telephone");
			String email = rs.getString("email");
			String password = rs.getString("password");
			Patient patient = new Patient(id, nom, prenom, dateNaiss, gender,doss, adresse, phone, email, password);
	        patients.add(patient);

		}
		return patients;
		
		
	}   
	
	
	
}
