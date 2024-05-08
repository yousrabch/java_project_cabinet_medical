package med;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class FichePatientDAOImpl implements FichePatientDAO {

	
	
	@Override
	public int insert(FichePatient fichepatient) throws SQLException {
        Connection con = Jdbc.getConnection();
		
	String sql = "INSERT INTO patient (id, nom, prenom, datenaiss, gender, Phone, email, adresse) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	
	
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, fichepatient.getId());
		ps.setString(2, fichepatient.getNom());
		ps.setString(3, fichepatient.getPrenom());
		ps.setDate(4, fichepatient.getDateNaiss());
		ps.setString(5, fichepatient.getGender());
		ps.setString(6, fichepatient.getPhone());
		ps.setString(7, fichepatient.getEmail());
		ps.setString(8, fichepatient.getAdressep());
		
		
		int result = ps.executeUpdate();
		
		
		Jdbc.closePreparedStatement(ps);
		Jdbc.closeConnection(con);
		
		return result;
}

	
	

	@Override
	public int delete(FichePatient fichepatient) throws SQLException {
	        Connection con = Jdbc.getConnection();

	String sql = "DELETE from patient where id =? ";

	PreparedStatement ps = con.prepareStatement(sql);

	ps.setInt(1, fichepatient.getId());

	int result = ps.executeUpdate();

	Jdbc.closePreparedStatement(ps);
	Jdbc.closeConnection(con);

	return result;
	}

	
	
	
	@Override
	public FichePatient getById(int id) throws SQLException {
		Connection con = Jdbc.getConnection();
		
	    FichePatient fichepatient = null;
		String sql = "SELECT * FROM patient WHERE id=?";
		PreparedStatement ps = con.prepareStatement (sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			int idp = rs.getInt("id");
			String nom = rs.getString("nom");
			String prenom = rs.getString("prenom");
			Date datenaiss=rs.getDate("birthDate");
			String gender=rs.getString("sex");
			String email=rs.getString("email");
			String adresse=rs.getString("adress");
			String password=rs.getString("password");
			String phone= rs.getString("phone");
			
			fichepatient = new FichePatient(id, nom, prenom, datenaiss, gender, phone, email, adresse);
			
		}else {
			fichepatient = null;
		}
			
		return fichepatient;
	}

	
	
	
	@Override
    public int update(FichePatient fichepatient) throws SQLException {
        Connection con = Jdbc.getConnection();

        String sql = "UPDATE patient set id =?, nom=? , prenom=?, datenaiss=? ,gender=?, Phone=?, email=?, adresse=?";


        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, fichepatient.getId());
        ps.setString(2, fichepatient.getNom());
        ps.setString(3, fichepatient.getPrenom());
        ps.setDate(4, (java.sql.Date) fichepatient.getDateNaiss());
        ps.setString(5, fichepatient.getGender());
        ps.setString(6, fichepatient.getPhone());
        ps.setString(7, fichepatient.getEmail());
        ps.setInt(8, fichepatient.getId());
        ps.setString(8, fichepatient.getAdressep());
        
        int result = ps.executeUpdate();

        Jdbc.closePreparedStatement(ps);
        Jdbc.closeConnection(con);

        return result;

    }

	@Override
	public List<FichePatient> getAll() throws SQLException {

		Connection con = Jdbc.getConnection();
		
		String sql = "SELECT * FROM patient";
		List<FichePatient> fichepatients = new ArrayList<>();
		
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String nom = rs.getString("nom");
			String prenom = rs.getString("prenom");
			Date dateNaiss = rs.getDate("date de naissance");
			String gender = rs.getString("sexe");
			String adresse = rs.getString("adresse");
			String phone = rs.getString("numero de telephone");
			String email = rs.getString("email");
			
			FichePatient fichepatient = new FichePatient(id, nom, prenom, dateNaiss, gender, adresse, phone, email);
	        fichepatients.add(fichepatient);

		}
		return fichepatients;
		
		
	}   
	
		


}
