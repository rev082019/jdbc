package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

	public static void insert(Employee employee)

			throws SQLException {

		Connection con = ConnectionUtil.getConnection();

		String sql = "insert into employees_test(id,name,city,department,salary) values ( ?,?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, employee.getId());
		pst.setString(2, employee.getName());
		pst.setString(3, employee.getCity());
		pst.setString(4, employee.getDepartment());
		pst.setInt(5, employee.getSalary());

		int rows = pst.executeUpdate();
		System.out.println("No of rows inserted:" + rows);
	}

	public static void update(Employee employee) throws SQLException {
		Connection con = ConnectionUtil.getConnection();

		String sql1 = "update employees_test set name = ?, city=?,department= ? where id = ?";
		PreparedStatement pst1 = con.prepareStatement(sql1);

		pst1.setString(1, employee.getName());

		pst1.setString(2, employee.getCity());
		pst1.setString(3, employee.getDepartment());
		pst1.setInt(4, employee.getId());

		int rows1 = pst1.executeUpdate();
		System.out.println("No of rows updated:" + rows1);

	}

	public static void delete(int id) throws SQLException {
		Connection con = ConnectionUtil.getConnection();

		String sql2 = "delete from employees_test where id = ?";
		PreparedStatement pst2 = con.prepareStatement(sql2);

		pst2.setInt(1, id);

		int rows2 = pst2.executeUpdate();
		System.out.println("No of rows deleted:" + rows2);
	}

	public static List<Employee> findAll() throws SQLException {
		Connection con = ConnectionUtil.getConnection();
		String sql = "select id,name,department,city,salary from employees_test";
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		List<Employee> list = new ArrayList<Employee>();
		while (rs.next()) {
			
			Employee employee = toRow(rs);
			list.add(employee);
		}
		return list;
	}

	public static Employee findById(int employeeId) throws SQLException {
		Connection con = ConnectionUtil.getConnection();
		String sql = "select id,name,department,city,salary from employees_test where id = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, employeeId);
		ResultSet rs = pst.executeQuery();
		Employee employee = null;

		if (rs.next()) {
			employee = toRow(rs);
		}
		return employee;
	}

	public static List<Employee> findByCity(String employeeCity) throws SQLException {
		Connection con = ConnectionUtil.getConnection();
		String sql = "select id,name,department,city,salary from employees_test where city = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, employeeCity);
		ResultSet rs = pst.executeQuery();
		List<Employee> list = new ArrayList<Employee>();
		if (rs.next()) {
			Employee employee = toRow(rs);
			list.add(employee);
		}
		return list;
	}

	private static Employee toRow(ResultSet rs) throws SQLException {
		Integer id = rs.getInt("id");
		String name = rs.getString("name");
		String city = rs.getString("city");
		String department = rs.getString("department");
		Integer salary = rs.getInt("salary");
		Employee employee = new Employee();
		employee.setId(id);
		employee.setName(name);
		employee.setCity(city);
		employee.setDepartment(department);
		employee.setSalary(salary);
		return employee;
	}

	public static int findMaxSalary() throws SQLException {
		Connection con = ConnectionUtil.getConnection();
		int maxSalary = 0;
		String sql = "select max(salary) as salary from employees_test";
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			maxSalary = rs.getInt("salary");
		}
		return maxSalary;
	}
	
	public static int findCount() throws SQLException {
		Connection con = ConnectionUtil.getConnection();
		int maxSalary = 0;
		String sql = "select count(*) as cnt from employees_test";
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			maxSalary = rs.getInt("cnt");
		}
		return maxSalary;
	}
}
