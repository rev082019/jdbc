package jdbc;

import java.sql.SQLException;

public class TestMaxSalary {
public static void main(String[] args) {
	try {
		int maxSalary = EmployeeDAO.findMaxSalary();
		System.out.println(maxSalary);
		
	} catch (SQLException e) {
		e.printStackTrace();
	}

}
}
