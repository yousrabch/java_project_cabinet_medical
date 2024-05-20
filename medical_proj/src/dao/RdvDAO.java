package dao;


import java.sql.SQLException;
import java.util.List;

import com.RDV;

public interface RdvDAO extends DAO<RDV>{
	List<RDV> getrdvByDate() throws SQLException;

}
