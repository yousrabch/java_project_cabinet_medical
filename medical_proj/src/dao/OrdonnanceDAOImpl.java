package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.FichePatient;
import com.Jdbc;
import com.Ordonnance;
import com.Patient;

public class OrdonnanceDAOImpl implements OrdonnanceDAO  {

	@Override
	public int insert(Ordonnance ordonnance) throws SQLException {
		Connection con = Jdbc.getConnection();

        String sql = "INSERT INTO Ordonnance (ord_date,  fiche_id, medicaments, Prescription) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);

 
        ps.setDate(1, (Date) ordonnance.getDate());
        ps.setInt(2, ordonnance.getFichePatient().getFiche_id());
        ps.setString(3, ordonnance.getMedicaments());
        ps.setString(4, ordonnance.getPrescription());
		
		

        int result = ps.executeUpdate();

        Jdbc.closePreparedStatement(ps);
        Jdbc.closeConnection(con);

        return result;
	}

	@Override
	public int update(Ordonnance ordonnance) throws SQLException {
		Connection connection = Jdbc.getConnection();

    String sql = "UPDATE Ordonnance SET ord_date = ?,  fiche_id = ?, medicaments = ?,  prescription = ? WHERE ord_date = ? and fiche_id = ?";

    PreparedStatement ps = connection.prepareStatement(sql);

   
    ps.setDate(1, (Date) ordonnance.getDate());
    ps.setInt(2, ordonnance.getFichePatient().getFiche_id());
    ps.setString(3, ordonnance.getMedicaments());
    ps.setString(4, ordonnance.getPrescription());
    
    ps.setDate(5, (Date) ordonnance.getDate());
    ps.setInt(6, ordonnance.getFichePatient().getFiche_id());
	

    int result = ps.executeUpdate();

    Jdbc.closePreparedStatement(ps);
    Jdbc.closeConnection(connection);

    return result;
	}

	@Override
	public int delete(Ordonnance ordonnance) throws SQLException {
		Connection connection = Jdbc.getConnection();

		String sql = "DELETE FROM Ordonnance WHERE ord_date = ? and fiche_id = ?";
	
		PreparedStatement ps = connection.prepareStatement(sql);
	
		
		ps.setDate(1, (Date) ordonnance.getDate());
		ps.setInt(2, ordonnance.getFichePatient().getFiche_id());
	
		int result = ps.executeUpdate();
	
		Jdbc.closePreparedStatement(ps);
		Jdbc.closeConnection(connection);
	
		return result;
	}


	@Override
	public Ordonnance get(Date date, int id1) throws SQLException {
		Connection con = Jdbc.getConnection();
		Ordonnance ord = null;

		String sql = "SELECT O.ord_date,  c.fiche_id, p.patient_id, p.lastname, p.firstname, F.poids, F.tailles,  O.medicaments, O.Prescription FROM Ordonnance O, Consultation c, FichePatient F, patient p "
				+ "WHERE O.ord_date = ? and O.fiche_id = ? and O.fiche_id = c.fiche_id ";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setDate(1,(Date) date);
		ps.setInt(2, id1);
		
		
		

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			
			 Date odate = rs.getDate("ord_date");
			 int id = rs.getInt("fiche_id");
			 int idp = rs.getInt("patient_id");
            String firstname = rs.getString("firstname");
            String lastname = rs.getString("lastname");
           int poids = rs.getInt("poids");
         int taille = rs.getInt("tailles"); 
         String medicaments = rs.getString("medicaments");         
         String prescription = rs.getString("prescription");
           
            
            Patient patient = new Patient(idp, lastname, firstname);
            
            FichePatient fpatient = new FichePatient(id, patient, poids, taille);
			ord = new Ordonnance(odate,  fpatient, medicaments,  prescription);
		}

		Jdbc.closeResultSet(rs);
	    Jdbc.closePreparedStatement(ps);
	    Jdbc.closeConnection(con);

		return ord;
	}

	@Override
	public List<Ordonnance> getAll(int id1) throws SQLException {
		Connection con = Jdbc.getConnection();
		List<Ordonnance> ordonnance = new ArrayList<>();
		
        String sql = "SELECT O.ord_date,  c.fiche_id, p.patient_id, p.lastname, p.firstname, F.poids, F.tailles,  O.medicaments, O.Prescription FROM Ordonnance O, Consultation c, FichePatient F, patient p  where O.fiche_id = ? ";

        
        
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setInt(1, id1);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
        	
        	Date odate = rs.getDate("ord_date");
			 int id = rs.getInt("fiche_id");
			 int idp = rs.getInt("patient_id");
           String firstname = rs.getString("firstname");
           String lastname = rs.getString("lastname");
          int poids = rs.getInt("poids");
        int taille = rs.getInt("tailles"); 
        String medicaments = rs.getString("medicaments");         
        String prescription = rs.getString("prescription");
          
           
           Patient patient = new Patient(idp, lastname, firstname);
           
           FichePatient fpatient = new FichePatient(id, patient, poids, taille);
		  Ordonnance	ord = new Ordonnance(odate,  fpatient, medicaments,  prescription);
		  
		  ordonnance.add(ord);
          
        }
        
        Jdbc.closeResultSet(rs);
	    Jdbc.closePreparedStatement(ps);
	    Jdbc.closeConnection(con);

        return ordonnance;
	}

}
