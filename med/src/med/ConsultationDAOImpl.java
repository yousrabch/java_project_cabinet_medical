package med;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConsultationDAOImpl implements ConsultationDAO{

	@Override
	public int insert(Consultation consultation) throws SQLException {
		
        Connection con = Jdbc.getConnection();
		
		String sql = "INSERT INTO consultation (id_consultation,motif,consultationDate, num_ordonnance, num_certificat,num_patient) VALUES (?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, consultation.getId_consultation());
		ps.setString(2, consultation.getMotif());
		ps.setDate(3, consultation.getDateconsult());
		ps.setInt(4, consultation.getOrd().getId()); 
	    ps.setInt(5, consultation.getCertificat().getId()); 
	    ps.setInt(6, consultation.getPatient().getId()); 
		
		
		int result = ps.executeUpdate();
		
		
		Jdbc.closePreparedStatement(ps);
		Jdbc.closeConnection(con);
		
		return result;
	}

	@Override
	public int update(Consultation consultation) throws SQLException {
        Connection con = Jdbc.getConnection();
		
		String sql = "UPDATE consultation set id_consultation=?,motif=?,consultationDate=?, num_ordonnance=?, num_certificat=?,num_patient=?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, consultation.getId_consultation());
		ps.setString(2, consultation.getMotif());
		ps.setDate(3, consultation.getDateconsult());
		ps.setInt(4, consultation.getOrd().getId()); // Assuming getOrd() returns an Ordonnance object with an ID
	    ps.setInt(5, consultation.getCertificat().getId()); // Assuming getCertificat() returns a Certificat object with an ID
	    ps.setInt(6, consultation.getPatient().getId());
		
		int result = ps.executeUpdate();
		
		Jdbc.closePreparedStatement(ps);
		Jdbc.closeConnection(con);
		
		return result;
	}

	@Override
	public int delete(Consultation consultation) throws SQLException {
        Connection con = Jdbc.getConnection();
		
		String sql = "DELETE from consultation where id_consultation =? ";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, consultation.getId_consultation());
		
		int result = ps.executeUpdate();
		
		Jdbc.closePreparedStatement(ps);
		Jdbc.closeConnection(con);
		
		return result;
	}
	

	@Override
	public List<Consultation> getByDate(Date consultationDate) throws SQLException {
		Connection con = Jdbc.getConnection();
		String sql=  "SELECT * from consultation where consultationDate=?";
        List<Consultation> consultations = new ArrayList<>();
		
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
		  int id_consultation = rs.getInt("id_consultation");
          String motif = rs.getString("motif");
          Ordonnance ordonnance = new Ordonnance();
          Certificat certificat = new Certificat();
          Patient patient = new Patient();
          Consultation consultation = new Consultation(id_consultation, motif, consultationDate, ordonnance, certificat, patient);
          consultations.add(consultation);
	   }
		return consultations;
       
 }
	
}
	

