package med;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class dossier_medDAOImpl implements DossierMedicaleDAO {

	@Override
	public int insert(Dossier_medical dossier) throws SQLException {
Connection con = Jbdc.getConnection();
		
		String sql = "INSERT INTO dossiermed (Num_dossier, patient_id, antecedents, examens, notes, traitement, compterendu) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		
PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, dossier.getNum_dossier());
		ps.setInt(2, dossier.getPatient());
		ps.setArray(3, dossier.getAntecedents());
		ps.setInt(4, dossier.getExamens());
		
		int result = ps.executeUpdate();
		
		Jbdc.closePreparedStatement(ps);
		Jbdc.closeConnection(con);
		
		return result;
	}

	@Override
	public int update(Dossier_medical t) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dossier_medical delete(Dossier_medical t) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dossier_medical get(int Num_dossier) throws SQLException {
		
		Connection con = Jbdc.getConnection();
		Dossier_medical dossier =null;
		
		String sql ="SELECT * FROM dossiermed WHERE Num_dossier = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, Num_dossier);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			
			int odos = rs.getInt("Num_dossier");
			List<String> antecedent ;
		}
		
		return dossier;
	}

	@Override
	public List<Dossier_medical> getAll() throws SQLException {
		Connection con = Jbdc.getConnection();
		String sql = "SELECT * FROM dossiermed";
		
		List<Dossier_medical> dossier = new ArrayList<>();
       Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			int odos = rs.getInt("Num_dossier");
			
			
		}
		
		return dossier;
	}

	@Override
	public Dossier_medical save(Dossier_medical t) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
