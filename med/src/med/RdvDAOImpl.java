package med;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RdvDAOImpl implements RdvDAO  {

	@Override
	public int insert(RDV rdv) throws SQLException {
       Connection con = Jdbc.getConnection();
		
		String sql = "INSERT INTO rdv (id_rdv,motifr,rdvDate,num_patient) VALUES (?, ?, ?, ?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, rdv.getId_rdv());
		ps.setString(2, rdv.getMotif());
		ps.setDate(3, (Date) rdv.getDate());
	    ps.setInt(4, rdv.getPatient().getId()); 
		
		int result = ps.executeUpdate();
		
		Jdbc.closePreparedStatement(ps);
		Jdbc.closeConnection(con);
		
		return result;
	}

	@Override
	public int update(RDV rdv) throws SQLException {
        Connection con = Jdbc.getConnection();
		
		String sql = "UPDATE rdv set id_rdv=?,motifr=?,rdvDate=?,num_patient=?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, rdv.getId_rdv());
		ps.setString(2, rdv.getMotif());
		ps.setDate(3, (Date) rdv.getDate());
	    ps.setInt(4, rdv.getPatient().getId());
		
		int result = ps.executeUpdate();
		
		Jdbc.closePreparedStatement(ps);
		Jdbc.closeConnection(con);
		
		return result;
	}

	@Override
	public int delete(RDV rdv) throws SQLException {
        Connection con = Jdbc.getConnection();
		
		String sql = "DELETE from rdv where id_rdv =? ";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, rdv.getId_rdv());
		
		int result = ps.executeUpdate();
		
		Jdbc.closePreparedStatement(ps);
		Jdbc.closeConnection(con);
		
		return result;
	}

	
	@Override
	public List<RDV> getrdvByDate(Date rdvdate) throws SQLException {
			Connection con = Jdbc.getConnection();
			String sql=  "SELECT * from rdv where rdvDate=?";
	        List<RDV> rdvs = new ArrayList<>();
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
			  int id_rdv = rs.getInt("id_rdv");
	          String motif = rs.getString("motif");
	          Date date = rs.getDate("Date rdv");
	          Patient patient = new Patient();
	          RDV rdv = new RDV(id_rdv, date , motif, patient);
	          rdvs.add(rdv);
		   }
			return rdvs;     
	 }
	
}


