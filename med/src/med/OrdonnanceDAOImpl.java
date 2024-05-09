package med;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrdonnanceDAOImpl implements OrdonnanceDAO  {

	@Override
	public int insert(Ordonnance ordonnance) throws SQLException {
		Connection con = Jdbc.getConnection();

        String sql = "INSERT INTO ordonnances (ord_id, medicaments, date, prescription, patient_id) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, ordonnance.getMedicaments());
        ps.setDate(2, (Date) ordonnance.getDate());
        ps.setString(3, ordonnance.getPrescription());
		ps.setInt(4, ordonnance.getFichePatient().getId());
		ps.setInt(5, ordonnance.getOrd_id());

        int result = ps.executeUpdate();

        Jdbc.closePreparedStatement(ps);
        Jdbc.closeConnection(con);

        return result;
	}

	@Override
	public int update(Ordonnance ordonnance) throws SQLException {
		Connection connection = Jdbc.getConnection();

    String sql = "UPDATE ordonnances SET medicaments = ?, date = ?, prescription = ? WHERE id = ?";

    PreparedStatement ps = connection.prepareStatement(sql);

    ps.setString(1, ordonnance.getMedicaments());
    ps.setDate(2, (Date) ordonnance.getDate());
    ps.setString(3, ordonnance.getPrescription());
    ps.setInt(4, ordonnance.getFichePatient().getId());
		ps.setInt(5, ordonnance.getOrd_id());

    int result = ps.executeUpdate();

    Jdbc.closePreparedStatement(ps);
    Jdbc.closeConnection(connection);

    return result;
	}

	@Override
	public int delete(Ordonnance ordonnance) throws SQLException {
		Connection connection = Jdbc.getConnection();

		String sql = "DELETE FROM ordonnance WHERE date = ?";
	
		PreparedStatement ps = connection.prepareStatement(sql);
	
		
		ps.setDate(1, (Date) ordonnance.getDate());
	
		int result = ps.executeUpdate();
	
		Jdbc.closePreparedStatement(ps);
		Jdbc.closeConnection(connection);
	
		return result;
	}


	@Override
	public Ordonnance get(Date date) throws SQLException {
		Connection con = Jdbc.getConnection();
		Ordonnance ord = null;

		String sql = "SELECT * FROM Ordonnace WHERE date = ?";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setDate(1,(Date) date);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			String medicaments = rs.getString("medicaments");
            Date odate = rs.getDate("date");
            String prescription = rs.getString("prescription");
            int ord_id = rs.getInt("ord_id");
			FichePatient patient = new FichePatient();
			ord = new Ordonnance(medicaments, patient, odate, prescription, ord_id);
		}

		Jdbc.closeResultSet(rs);
	    Jdbc.closePreparedStatement(ps);
	    Jdbc.closeConnection(con);

		return ord;
	}

	@Override
	public List<Ordonnance> getAll() throws SQLException {
		Connection con = Jdbc.getConnection();
        String sql = "SELECT * FROM ordonnance";

        List<Ordonnance> ordonnances = new ArrayList<>();

        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            String medicaments = rs.getString("medicaments");
            Date date = rs.getDate("date");
            String prescription = rs.getString("prescription");
			int ord_id = rs.getInt("ord_id");
			FichePatient patient = new FichePatient();

            Ordonnance ordonnance = new Ordonnance(medicaments, patient, date, prescription, ord_id);

            ordonnances.add(ordonnance);
        }

        return ordonnances;
	}

}
