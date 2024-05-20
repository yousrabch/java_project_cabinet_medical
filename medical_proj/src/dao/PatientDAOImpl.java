package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Jdbc;
import com.Patient;

public class PatientDAOImpl implements PatientDAO{


	@Override
	public int insert(Patient patient) throws SQLException {
        Connection con = Jdbc.getConnection();
		
	String sql = "INSERT INTO patient (patient_id, Lastname, firstname, date_n, Gender, phone, Email, adress) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	
	
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, patient.getId());
		ps.setString(2, patient.getNom());
		ps.setString(3, patient.getPrenom());
		ps.setDate(4, (Date) patient.getDateNaiss());
		ps.setString(5, patient.getGender());
		ps.setString(6, patient.getPhone());
		ps.setString(7, patient.getEmail());
		ps.setString(8, patient.getAdresse());
		
		int result = ps.executeUpdate();
		
		
		Jdbc.closePreparedStatement(ps);
		Jdbc.closeConnection(con);
		
		return result;
}

	@Override
	public int update(Patient patient) throws SQLException {
        Connection con = Jdbc.getConnection();
		
		String sql = "UPDATE patient set patient_id =?, Lastname=? , firstname = ?, date_n = ? ,Gender=?, phone=?, email=?, Adress=? where patient_id =?";
		
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, patient.getId());
		ps.setString(2, patient.getNom());
		ps.setString(3, patient.getPrenom());
		ps.setDate(4, (java.sql.Date) patient.getDateNaiss());
		ps.setString(5, patient.getGender());
		ps.setString(6, patient.getPhone());
		ps.setString(7, patient.getEmail());
		ps.setString(8, patient.getAdresse());
		
		ps.setInt(9, patient.getId());
		
		
		int result = ps.executeUpdate();
		
		Jdbc.closePreparedStatement(ps);
		Jdbc.closeConnection(con);
		
		return result;
			
	}

	@Override
	public int delete(Patient patient) throws SQLException {
        Connection con = Jdbc.getConnection();
		
		String sql = "DELETE from patient where patient_id =? ";
		
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
		String sql = "SELECT * FROM patient WHERE patient_id=?";
		
		PreparedStatement ps = con.prepareStatement (sql);
		
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			int idp = rs.getInt("patient_id");
			String nom = rs.getString("Lastname");
			String prenom = rs.getString("firstname");
			Date dateNaiss=rs.getDate("date_n");
			String gender=rs.getString("Gender");
			String phone= rs.getString("phone");
			String email=rs.getString("email");
			String adresse=rs.getString("adress");
			
			
			
			patient = new Patient(idp, nom,prenom,  dateNaiss, gender,  phone, email, adresse);
			
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
			int idp = rs.getInt("patient_id");
			String nom = rs.getString("Lastname");
			String prenom = rs.getString("firstname");
			Date dateNaiss=rs.getDate("date_n");
			String gender=rs.getString("Gender");
			String phone= rs.getString("phone");
			String email=rs.getString("email");
			String adresse=rs.getString("adress");
			
			
			
			Patient patient = new Patient(idp, nom,prenom,  dateNaiss, gender,  phone, email, adresse);
	        patients.add(patient);

		}
		return patients;
		
		
	}   
	
	
	
}