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
import com.RDV;

public class RdvDAOImpl implements RdvDAO  {

	@Override
	public int insert(RDV rdv) throws SQLException {
       Connection con = Jdbc.getConnection();
		
		String sql = "INSERT INTO rdv (rdvDate, patient_id, motif) VALUES (?, ?, ?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setDate(1, (Date) rdv.getDate());
		ps.setInt(2, rdv.getPatient().getId()); 
		ps.setString(3, rdv.getMotif());
		
	    
		
		int result = ps.executeUpdate();
		
		Jdbc.closePreparedStatement(ps);
		Jdbc.closeConnection(con);
		
		return result;
	}

	@Override
	public int update(RDV rdv) throws SQLException {
        Connection con = Jdbc.getConnection();
		
		String sql = "UPDATE rdv set rdvDate = ?, patient_id = ?, motif = ? where rdvDate = ? and patient_id = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setDate(1, (Date) rdv.getDate());
		 ps.setInt(2, rdv.getPatient().getId());
		ps.setString(3, rdv.getMotif());
		ps.setDate(4, (Date) rdv.getDate());
	    ps.setInt(5, rdv.getPatient().getId());
		
		int result = ps.executeUpdate();
		
		Jdbc.closePreparedStatement(ps);
		Jdbc.closeConnection(con);
		
		return result;
	}

	@Override
	public int delete(RDV rdv) throws SQLException {
        Connection con = Jdbc.getConnection();
		
		String sql = "DELETE from rdv where rdvDate =? and patient_id = ? ";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setDate(1, (Date) rdv.getDate());
		 ps.setInt(2, rdv.getPatient().getId());
		
		int result = ps.executeUpdate();
		
		Jdbc.closePreparedStatement(ps);
		Jdbc.closeConnection(con);
		
		return result;
	}

	
	@Override
	public List<RDV> getrdvByDate() throws SQLException {
			Connection con = Jdbc.getConnection();
			String sql=  "SELECT (SELECT COUNT(*) FROM rdv r) AS total_count, r.rdvDate,  p.*, r.motif  \r\n"
					+ "FROM rdv r, patient p where r.patient_id = p.patient_id\r\n"
					+ "ORDER BY r.rdvDate ASC; ";
			
	        List<RDV> rdvs = new ArrayList<>();
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
			
	         
	          Date date = rs.getDate("rdvDate");
	          int id = rs.getInt("patient_id");
	          String firstname = rs.getString("firstname");
	          String lastname = rs.getString("lastname");
	          String motif = rs.getString("motif");
	            
	            Patient patient = new Patient(id, lastname, firstname);
	            
	            
	          RDV rdv = new RDV( date , patient, motif);
	          rdvs.add(rdv);
		   }
			return rdvs;     
	 }
	
}
