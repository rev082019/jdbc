package jdbc;

import java.sql.SQLException;
import java.util.List;

public class TestEmployeeFindById {

	public static void main(String[] args) {

		try {
			Employee employee = EmployeeDAO.findById(10);
			System.out.println(employee);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
