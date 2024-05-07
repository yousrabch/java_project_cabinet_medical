package med;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface RdvDAO extends DAO<RDV>{
	List<RDV> getrdvByDate(Date date) throws SQLException;

}
