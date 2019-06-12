import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.ravi.database.config.DatabaseConnection;

public class TestDatabaseConnection {
//	@Test
//	public void testGetConnection() {
//		DatabaseConnection.getConnection();
//	}

	@Test
	public void testGetResultSet() throws SQLException {
		ResultSet rs = DatabaseConnection.getResultSet("select * from table");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
		}
		DatabaseConnection.closeConnection();
	}

}
