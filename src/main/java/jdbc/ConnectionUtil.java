package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionUtil {

	public static Connection getConnection() {
		String driverClassName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/training_db";
		String username = "root";
		String password = "root";

		Connection con = null;
		try {
			Class.forName(driverClassName);
			con = DriverManager.getConnection(url, username, password);
			System.out.println(con);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String driverClassName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/training_db";
		String username = "root";
		String password = "root";

		Class.forName(driverClassName);
		Connection con = DriverManager.getConnection(url, username, password);
		System.out.println(con);
		
		//String sql = "insert into employees_test(id,name) values ( 101,'Naresh')";
		String sql = "insert into employees_test(id,name) values ( ?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, 101);
		pst.setString(2, "Naresh");

		//int rows = pst.executeUpdate();
		//System.out.println("No of rows inserted:"+ rows);
		
		String sql1 = "update employees_test set name = ? where id = ?";
		PreparedStatement pst1 = con.prepareStatement(sql1);		
		pst1.setString(1, "Naresh K");
		pst1.setInt(2, 101);

		//int rows1 = pst1.executeUpdate();
		//System.out.println("No of rows updated:"+ rows1);
		
		String sql2 = "delete from employees_test where id = ?";
		PreparedStatement pst2 = con.prepareStatement(sql2);		
		pst2.setInt(1, 101);

		int rows2 = pst2.executeUpdate();
		System.out.println("No of rows deleted:"+ rows2);
	}
}
