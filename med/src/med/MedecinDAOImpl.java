package med;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MedecinDAOImpl implements MedecinDAO {

	@Override
	public Medecin insert(Medecin doc) throws SQLException {
		Connection con = Jbdc.getConnection();

		String sql = "INSERT INTO Doctor (last_name, first_name, phone, specialite, email) VALUES (?, ?, ?, ?, ?)";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, doc.getNom);
		ps.setString(2, doc.getPrenom());
		ps.setString(3, doc.getPhone());
		ps.setString(4, doc.getEmail());
		ps.setString(4, doc.getSpecialite());

		int result = ps.executeUpdate();

		Database.closePreparedStatement(ps);
		Database.closeConnection(con);

		return result;
	}

	@Override
	public Medecin update(Medecin doc) throws SQLException {
		Connection con = Jbdc.getConnection();

		String sql = "UPDATE Doctor Set last_name=?, first_name= ?, phone=?, specialite=?, email=? WHERE last_name=? ";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, doc.getNom);
		ps.setString(2, doc.getPrenom());
		ps.setString(3, doc.getPhone());
		ps.setString(4, doc.getEmail());
		ps.setString(4, doc.getSpecialite());

		int result = ps.executeUpdate();

		Database.closePreparedStatement(ps);
		Database.closeConnection(con);

		return result;
	}

	@Override
	public Medecin delete(Medecin doc) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Medecin save(Medecin doc) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
