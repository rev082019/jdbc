package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDAO {

	public static void insert(int id, String name) throws SQLException {

		Connection con = ConnectionUtil.getConnection();
		
		//String sql = "insert into employees_test(id,name) values ( 101,'Naresh')";
		String sql = "insert into employees_test(id,name) values ( ?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, id);
		pst.setString(2, name);

		int rows = pst.executeUpdate();
		System.out.println("No of rows inserted:"+ rows);
	}
	
	public static void update(int id, String name) throws SQLException {
		Connection con = ConnectionUtil.getConnection();
		
		String sql1 = "update employees_test set name = ? where id = ?";
		PreparedStatement pst1 = con.prepareStatement(sql1);		
		pst1.setString(1, name);
		pst1.setInt(2, id);

		int rows1 = pst1.executeUpdate();
		System.out.println("No of rows updated:"+ rows1);
	}
	
	public static void delete(int id) throws SQLException {
		Connection con = ConnectionUtil.getConnection();
		
		String sql2 = "delete from employees_test where id = ?";
		PreparedStatement pst2 = con.prepareStatement(sql2);		
		
		pst2.setInt(1, id);

		int rows2 = pst2.executeUpdate();
		System.out.println("No of rows deleted:"+ rows2);
	}

}
