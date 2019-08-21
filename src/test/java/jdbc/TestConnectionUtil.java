package jdbc;

import java.sql.Connection;

public class TestConnectionUtil {

	public static void main(String[] args) {

		Connection con = ConnectionUtil.getConnection();
		System.out.println(con);
	}

}
