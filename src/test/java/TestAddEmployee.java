
import jdbc.Employee;
import jdbc.EmployeeDAO;

public class TestAddEmployee {

	public static void main(String[] args)  {
		

		try {
			
			Employee e = new Employee();
			e.setId(11);
			e.setName("Naresh");
			e.setCity("Bangalore");
			e.setDepartment("CSE");
			e.setSalary(30000);
			
			EmployeeDAO.insert(e);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
