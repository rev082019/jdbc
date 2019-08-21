
import java.sql.SQLException;

import jdbc.EmployeeDAO;

public class TestDeleteEmployee {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		int id = 102;

		EmployeeDAO.delete(id);

	}

}
