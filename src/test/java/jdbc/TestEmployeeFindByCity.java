package jdbc;

import java.sql.SQLException;
import java.util.List;

public class TestEmployeeFindByCity {

	public static void main(String[] args) {

		try {
			List<Employee> employee = EmployeeDAO.findByCity("Bangalore");
			System.out.println(employee);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
