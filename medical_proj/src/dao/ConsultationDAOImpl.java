package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;


import com.Consultation;
import com.Dossier_medical;
import com.FichePatient;
import com.Jdbc;
import com.Patient;


public class ConsultationDAOImpl implements ConsultationDAO{

	@Override
	public int insert(Consultation consultation) throws SQLException {
		
        Connection con = Jdbc.getConnection();
		
		String sql = "INSERT INTO consultation (consultationDate, Fiche_id, motif, Num_dossier) VALUES (?, ?, ?, ?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setDate(1, (Date) consultation.getDateconsult());
		ps.setInt(2, consultation.getPatient().getFiche_id()); 
		ps.setString(3, consultation.getMotif());
		ps.setInt(4, consultation.getNumdossier().getNum_dossier());
		
		int result = ps.executeUpdate();
		
		
		Jdbc.closePreparedStatement(ps);
		Jdbc.closeConnection(con);
		
		return result;
	}

	@Override
	public int update(Consultation consultation) throws SQLException {
        Connection con = Jdbc.getConnection();
		
		String sql = "UPDATE consultation set  consultationDate = ?, Fiche_id =?, motif = ?, Num_dossier = ? Where consultationDate = ? and fiche_id =?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setDate(1, (Date) consultation.getDateconsult());
		ps.setInt(2, consultation.getPatient().getFiche_id());
		ps.setString(3, consultation.getMotif());
		ps.setInt(4, consultation.getNumdossier().getNum_dossier());
		ps.setDate(5, (Date) consultation.getDateconsult());
		ps.setInt(6, consultation.getPatient().getFiche_id());
		
	   
		
		int result = ps.executeUpdate();
		
		Jdbc.closePreparedStatement(ps);
		Jdbc.closeConnection(con);
		
		return result;
	}

	@Override
	public int delete(Consultation consultation) throws SQLException {
        Connection con = Jdbc.getConnection();
		
		String sql = "DELETE from consultation where consultationDate = ? and fiche_id =? ";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setDate(1, (Date) consultation.getDateconsult());
		 ps.setInt(2, consultation.getPatient().getFiche_id());
		
		int result = ps.executeUpdate();
		
		Jdbc.closePreparedStatement(ps);
		Jdbc.closeConnection(con);
		
		return result;
	}
	

	@Override
	public List<Consultation> getByDate(Date consultationDate, int id1) throws SQLException {
		Connection con = Jdbc.getConnection();
		String sql=  "SELECT c.consultationDate, fp.fiche_id, p.patient_id, p.firstname, p.lastname, fp.poids, fp.tailles, c.motif, d.Num_dossier from consultation c , Fichepatient fp, patient p, dossier_medical d where c.consultationDate = ? and c.fiche_id =?;";
        List<Consultation> consultations = new ArrayList<>();
        
        PreparedStatement ps = con.prepareStatement(sql);
		
        ps.setDate(1, consultationDate);
		ps.setInt(2, id1);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
		 
		  Date consultdate = rs.getDate("consultationDate");
		  int idf = rs.getInt("fiche_id");
		  int id = rs.getInt("patient_id");
          String firstname = rs.getString("firstname");
          String lastname = rs.getString("lastname");
          int poids = rs.getInt("poids");
          int taille = rs.getInt("tailles"); 
          String motif = rs.getString("motif");
          int numdoss = rs.getInt("Num_dossier");
          
          
          
          Patient patient = new Patient(id, lastname, firstname);
          
          FichePatient fpatient = new FichePatient(idf, patient, poids, taille);
          
          Dossier_medical doss = new Dossier_medical(numdoss);
          
          Consultation consultation = new Consultation(  consultdate, fpatient, motif, doss);
          consultations.add(consultation);
	   }
		
		Jdbc.closePreparedStatement(ps);
		Jdbc.closeConnection(con);
		
		return consultations;
       
 }
	
}
