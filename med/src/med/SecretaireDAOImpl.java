package med;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SecretaireDAOImpl implements SecretaireDAO {
	
	
	@Override
	public int update(Secretaire secretaire) throws SQLException {
		Connection con = Jdbc.getConnection();
		String sql = "update secretaire set nom = ?, prenom = ?, email = ?, phone =?, password =? where nom = ? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, secretaire.getNom());
		ps.setString(2, secretaire.getPrenom());
		ps.setString(3, secretaire.getEmail());
		ps.setString(4, secretaire.getPhone());
		ps.setString(5, secretaire.getPassword());
		
		int result = ps.executeUpdate();
		
		Jdbc.closePreparedStatement(ps);
		Jdbc.closeConnection(con);
		
		return result;
	}

	
	
	@Override
	public int delete(Secretaire secretaire) throws SQLException {
		Connection con = Jdbc.getConnection();
		String sql = "DELETE FROM secretaire WHERE nom = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, secretaire.getNom());
		
		int result = ps.executeUpdate();
		
		Jdbc.closePreparedStatement(ps);
		Jdbc.closeConnection(con);
		
		
		return result;
	}

	




	@Override
	public int insert(Secretaire secretaire) throws SQLException {
		Connection con = Jdbc.getConnection();
		String sql = "INSERT INTO sectretaire (nom, prenom, phone, email, password) VALUES (?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString (1, secretaire.getNom());
		ps.setString (2, secretaire.getPrenom());
		ps.setString (3, secretaire.getEmail());
		ps.setString (4, secretaire.getPhone());
		ps.setString (4, secretaire.getPassword());
		
		int result = ps.executeUpdate();
		
		Jdbc.closePreparedStatement(ps);
		Jdbc.closeConnection(con);
		
		return result;
		
	}



	@Override
	public Secretaire getSecritaire(String nom) throws SQLException {
		Connection con = Jdbc.getConnection();
		Secretaire secretaire = null;
		
		String sql = "SELECT nom, prenom, email, phone, password from secretaire where nom = ? ";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, sql);
		ResultSet rs =ps.executeQuery();
		
		if(rs.next()){
			String onom = rs.getString("nom");
			String oprenom = rs.getString("prenom");
			String oemail = rs.getString("email");
			String ophone = rs.getString("phone");
			String opassword = rs.getString("password");
			
			secretaire = new Secretaire(onom, oprenom, oemail, ophone, opassword);
		}
			
		return secretaire;
	}





}
