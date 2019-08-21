

import java.sql.SQLException;

import jdbc.Employee;
import jdbc.EmployeeDAO;

public class TestUpdateEmployee {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Employee a=new Employee();
		a.setId(104);
		a.setName("suresh");
		a.setSalary(30000);
		a.setCity("chennai");
		a.setDepartment("ECE");
		EmployeeDAO.update(a);
	}

	

}
