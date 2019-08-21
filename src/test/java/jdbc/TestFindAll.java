package jdbc;

import java.sql.SQLException;
import java.util.List;

public class TestFindAll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			List<Employee> list = EmployeeDAO.findAll();
			for (Employee employee : list) {
				
				System.out.println(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
