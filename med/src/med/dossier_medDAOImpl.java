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
Connection con = Jdbc.getConnection();
		
		String sql = "INSERT INTO dossiermed (Num_dossier, patient_id, antecedents, examens, notes, traitement, compterendu, consult_id) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		
PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, dossier.getNum_dossier());
		ps.setInt(2, dossier.getPatient().getId());
		ps.setString(3, dossier.getAntecedents());
		ps.setString(4, dossier.getExamens());
		ps.setString(5, dossier.getTraitement());
		ps.setString(6, dossier.getNotes());
		ps.setString(7, dossier.getCompterendu());
		ps.setInt(8, dossier.getConsult().getId_consultation());
		
		int result = ps.executeUpdate();
		
		Jdbc.closePreparedStatement(ps);
		Jdbc.closeConnection(con);
		
		return result;
	}

	@Override
	public int update(Dossier_medical dossier) throws SQLException {
		Connection connection = Jdbc.getConnection();

		String sql = "UPDATE dossier_med SET patient_id = ?, antecedents = ?, examens = ?, notes = ?, traitement = ?, compterendu = ? WHERE num_dossier = ?";
	
		PreparedStatement ps = connection.prepareStatement(sql);
	
		ps.setInt(1, dossier.getPatient().getId());
		ps.setString(2, dossier.getAntecedents());
		ps.setString(3, dossier.getExamens());
		ps.setString(4, dossier.getNotes());
		ps.setString(5, dossier.getTraitement());
		ps.setString(6, dossier.getCompterendu());
		ps.setInt(7, dossier.getNum_dossier());
		ps.setInt(8, dossier.getConsult().getId_consultation());
	
		int result = ps.executeUpdate();
	
		Jdbc.closePreparedStatement(ps);
		Jdbc.closeConnection(connection);
	
		return result;
	}

	@Override
	public int delete(Dossier_medical dossier) throws SQLException {
		Connection connection = Jdbc.getConnection();

		String sql = "DELETE FROM dossier_med WHERE num_dossier = ?";
	
		PreparedStatement ps = connection.prepareStatement(sql);
	
		ps.setInt(1, dossier.getNum_dossier());
	
		int result = ps.executeUpdate();
	
		Jdbc.closePreparedStatement(ps);
		Jdbc.closeConnection(connection);
	
		return result;
	}

	@Override
	public Dossier_medical get(int Num_dossier) throws SQLException {
		
		Connection con = Jdbc.getConnection();
        Dossier_medical dossier = null;

        String sql = "SELECT * FROM dossier_med WHERE num_dossier = ?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, Num_dossier);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            FichePatient patient = new FichePatient();
            String antecedents = rs.getString("antecedents");
            String examens = rs.getString("examens");
            String notes = rs.getString("notes");
            String traitement = rs.getString("traitement");
            String compterendu = rs.getString("compterendu");
			Consultation consult = new Consultation();

            

            dossier = new Dossier_medical(Num_dossier, patient, antecedents, examens, notes, traitement, compterendu, consult) ;
		}

		Jdbc.closeResultSet(rs);
		Jdbc.closePreparedStatement(ps);
		Jdbc.closeConnection(con);

		return dossier;
	}

	@Override
	public List<Dossier_medical> getAll() throws SQLException {
		Connection con = Jdbc.getConnection();
        String sql = "SELECT num_dossier, patient_id, antecedents, examens, notes, traitement, compterendu FROM dossiers_medicaux";

        List<Dossier_medical> dossiers = new ArrayList<>();

        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            int numDossier = rs.getInt("num_dossier");
            FichePatient patient = new FichePatient();
            String antecedents = rs.getString("antecedents");
            String examens = rs.getString("examens");
            String notes = rs.getString("notes");
            String traitement = rs.getString("traitement");
            String compterendu = rs.getString("compterendu");
			Consultation consult = new Consultation();

            Dossier_medical dossier = new Dossier_medical(numDossier, patient, antecedents, examens, notes, traitement, compterendu, consult);

            dossiers.add(dossier);
        }

        return dossiers;
	}

}
