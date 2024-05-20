package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Jdbc;
import com.Secretaire;


public class SecretaireDAOImpl implements SecretaireDAO {
	
	
	@Override
	public int update(Secretaire secretaire) throws SQLException {
		Connection con = Jdbc.getConnection();
		String sql = "update secretaire set Lastname = ?, firstname = ?, phoneNum = ?, email = ? where Lastname = ? ";
		PreparedStatement ps = con.prepareStatement(sql);
		
		
		ps.setString (1, secretaire.getNom());
		ps.setString (2, secretaire.getPrenom());
		ps.setString (3, secretaire.getPhone());
		ps.setString (4, secretaire.getEmail());
		
		ps.setString (5, secretaire.getNom());
		
		
		int result = ps.executeUpdate();
		
		Jdbc.closePreparedStatement(ps);
		Jdbc.closeConnection(con);
		
		return result;
	}

	
	
	@Override
	public int delete(Secretaire secretaire) throws SQLException {
		Connection con = Jdbc.getConnection();
		String sql = "DELETE FROM secretaire WHERE Lastname = ?";
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
		String sql = "INSERT INTO secretaire (Lastname, firstname, phoneNum, email) VALUES (?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString (1, secretaire.getNom());
		ps.setString (2, secretaire.getPrenom());
		ps.setString (3, secretaire.getPhone());
		ps.setString (4, secretaire.getEmail());
		
	
		
		int result = ps.executeUpdate();
		
		Jdbc.closePreparedStatement(ps);
		Jdbc.closeConnection(con);
		
		return result;
		
	}



	@Override
	public Secretaire getSecritaire(String nom) throws SQLException {
		Connection con = Jdbc.getConnection();
		Secretaire secretaire = null;
		
		String sql = "SELECT Lastname, firstname, phoneNum, email from secretaire where Lastname = ? ";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, sql);
		ResultSet rs =ps.executeQuery();
		
		if(rs.next()){
			String onom = rs.getString("nom");
			String oprenom = rs.getString("prenom");
			String oemail = rs.getString("email");
			String ophone = rs.getString("phone");
			//String opassword = rs.getString("password");
			
			secretaire = new Secretaire(onom, oprenom, oemail, ophone);
		}
			
		return secretaire;
	}





}
