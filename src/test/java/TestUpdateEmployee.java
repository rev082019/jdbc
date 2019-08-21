

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.ConnectionUtil;
import jdbc.EmployeeDAO;

public class TestUpdateEmployee {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		EmployeeDAO.update(102,"Siva G");
	}

	

}
