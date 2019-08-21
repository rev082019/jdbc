

import java.sql.SQLException;

import jdbc.EmployeeDAO;

public class TestAddEmployee {
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		EmployeeDAO.insert(102, "Siva");
		EmployeeDAO.insert(103,"Prabhu");

	}

}
