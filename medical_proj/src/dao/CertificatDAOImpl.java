package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Certificat;
import com.FichePatient;
import com.Jdbc;
import com.Patient;

public class CertificatDAOImpl implements CertificatDAO {

	@Override
	public int insert(Certificat certi) throws SQLException {
    Connection con = Jdbc.getConnection();
		
		String sql = "INSERT INTO Certificat (cert_date, fiche_id, motif, certi) VALUES (?, ?, ?, ?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setDate(1, (Date) certi.getDate());
		ps.setInt(2, certi.getPatient().getFiche_id());
		ps.setString(3, certi.getMotif());
		ps.setString(4, certi.getCert());
		
		int result = ps.executeUpdate();
		
		Jdbc.closePreparedStatement(ps);
		Jdbc.closeConnection(con);
		
		return result;
	}

	@Override
	public int update(Certificat certi) throws SQLException {
		Connection connection = Jdbc.getConnection();

		String sql = "UPDATE Certificat set cert_date = ?, fiche_id = ?, motif = ?, certi = ? where cert_date =? and  fiche_id = ?";
		
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setDate(1, (Date) certi.getDate());
		ps.setInt(2, certi.getPatient().getFiche_id());
		ps.setString(3, certi.getMotif());
		ps.setString(4, certi.getCert());
		
		ps.setDate(5, (Date) certi.getDate());
		ps.setInt(6, certi.getPatient().getFiche_id());
		
		int result = ps.executeUpdate();
		
		Jdbc.closePreparedStatement(ps);
		Jdbc.closeConnection(connection);
		
		return result;
	}

	@Override
	public int delete(Certificat certi) throws SQLException {
		Connection con = Jdbc.getConnection();
		String sql = "DELETE FROM Certificat WHERE cert_date =? and fiche_id = ? ";
		
		PreparedStatement ps= con.prepareStatement(sql);
		
		ps.setDate(1, (Date) certi.getDate());
		ps.setInt(2, certi.getPatient().getFiche_id());
		
		int result = ps.executeUpdate();
		
		Jdbc.closePreparedStatement(ps);
		Jdbc.closeConnection(con);
		
		return result;
	}


	@Override
	public Certificat get(java.util.Date date, int id) throws SQLException {
	
		Connection con = Jdbc.getConnection();
		Certificat certi = null;

		String sql = "SELECT C.cert_date, cn.fiche_id, p.patient_id, p.lastname, p.firstname, C.motif, C.certi FROM Certificat C, Consultation cn, FichePatient F, patient p WHERE C.cert_date = ? and C.fiche_id = ? and C.fiche_id = cn.fiche_id ";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setDate(1, (Date) date);
		ps.setInt(2, id);
		
		
		

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			java.util.Date odate = (Date) rs.getDate("cert_date");
			int idf = rs.getInt("fiche_id");
			int patientId = rs.getInt("Patient_id");
			String lastname = rs.getString("lastName");
			String firstname = rs.getString("firstName");
	        
	        String Motiff = rs.getString("motif");
			String certificats = rs.getString("certi");
			
			Patient patient = new Patient(patientId, lastname, firstname);
			FichePatient fpatient = new FichePatient(idf, patient);

			certi = new Certificat( odate, fpatient, Motiff, certificats);

}

		Jdbc.closeResultSet(rs);
		Jdbc.closePreparedStatement(ps);
		Jdbc.closeConnection(con);

		return certi;
		
	}


}
