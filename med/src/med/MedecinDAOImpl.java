package med;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MedecinDAOImpl implements MedecinDAO {

	@Override
	public int insert(Medecin doc) throws SQLException {
		Connection con = Jdbc.getConnection();

		String sql = "INSERT INTO Doctor (last_name, first_name, phone, specialite, email) VALUES (?, ?, ?, ?, ?)";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, doc.getNom());
		ps.setString(2, doc.getPrenom());
		ps.setString(3, doc.getPhone());
		ps.setString(4, doc.getEmail());
		ps.setString(5, doc.getPassword());
		ps.setString(6, doc.getSpecialite());

		int result = ps.executeUpdate();

		Jdbc.closePreparedStatement(ps);
		Jdbc.closeConnection(con);

		return result;
	}

	@Override
	public int update(Medecin doc) throws SQLException {
		Connection con = Jdbc.getConnection();

		String sql = "UPDATE Doctor Set last_name=?, first_name= ?, phone=?, specialite=?, email=? WHERE last_name=? ";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, doc.getNom());
		ps.setString(2, doc.getPrenom());
		ps.setString(3, doc.getPhone());
		ps.setString(4, doc.getEmail());
		ps.setString(5, doc.getPassword());
		ps.setString(6, doc.getSpecialite());

		int result = ps.executeUpdate();

		Jdbc.closePreparedStatement(ps);
		Jdbc.closeConnection(con);

		return result;
	}

	@Override
	public int delete(Medecin doc) throws SQLException {
		Connection connection = Jdbc.getConnection();
		
		String sql = "DELETE FROM Doctor WHERE nom = ?";
		
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1, doc.getNom());
		
		int result = ps.executeUpdate();
		
		Jdbc.closePreparedStatement(ps);
		Jdbc.closeConnection(connection);
		
		return result;
	}

}
