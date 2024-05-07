package med;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CertificatDAOImpl implements CertificatDAO {

	@Override
	public int insert(Certificat certi) throws SQLException {
    Connection con = Jbdc.getConnection();
		
		String sql = "INSERT INTO Certificat (date, Patient_id, motif, cert) VALUES (?, ?, ?, ?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setDate(1, (Date) certi.getDate());
		ps.setInt(2, certi.getPatient_id());
		ps.setString(3, certi.getMotif());
		ps.setString(4, certi.getCert());
		
		int result = ps.executeUpdate();
		
		Jbdc.closePreparedStatement(ps);
		Jbdc.closeConnection(con);
		
		return result;
	}

	@Override
	public int update(Certificat certi) throws SQLException {
		Connection connection = Jbdc.getConnection();

		String sql = "UPDATE Certificat set td_date = ?, motif = ?, cert = ? where td_date = ?";
		
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setDate(1, (Date) certi.getDate());
		ps.setInt(2, certi.getPatient_id());
		ps.setString(3, certi.getMotif());
		ps.setString(4, certi.getCert());
		
		int result = ps.executeUpdate();
		
		Jbdc.closePreparedStatement(ps);
		Jbdc.closeConnection(connection);
		
		return result;
	}

	@Override
	public int delete(Certificat certi) throws SQLException {
		Connection con = Jbdc.getConnection();
		String sql = "DELETE FROM Certificat WHERE td_date =?; ";
		
		PreparedStatement ps= con.prepareStatement(sql);
		
		ps.setDate(1, (Date) certi.getDate());
		int result = ps.executeUpdate();
		
		Jbdc.closePreparedStatement(ps);
		Jbdc.closeConnection(con);
		
		return result;
	}

	
	@Override
	public List<Certificat> getAll() throws SQLException {
		Connection con = Jbdc.getConnection();
		String sql = "SELECT * FROM Certificat";

		List<Certificat> certi = new ArrayList<>();

		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			Date odate = rs.getDate("td_date");
			int patientId = rs.getInt("patient_id");
			String Motiff = rs.getString("motif");
			String certificats = rs.getString("cert");

			Certificat certi1 =new Certificat(patientId, odate, Motiff, certificats);

		}

		return certi;
	}

	@Override
	public Certificat save(Certificat t) throws SQLException {
		Connection con = Jbdc.getConnection();
		String sql = "COMMIT;";
	}

	@Override
	public Certificat get(java.util.Date date) throws SQLException {
	
		Connection con = Jbdc.getConnection();
		Certificat certi = null;

		String sql = "SELECT * FROM Certificat WHERE td_date = ?";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setDate(1, date);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			java.util.Date odate = rs.getDate("td_date");
			int patientId = rs.getInt("Patient_id");
			String Motiff = rs.getString("motif");
			String certificats = rs.getString("cert");
			

			certi = new Certificat(patientId, odate, Motiff, certificats);

}

		Jbdc.closeResultSet(rs);
		Jbdc.closePreparedStatement(ps);
		Jbdc.closeConnection(con);

		return certi;
		
	}

}
