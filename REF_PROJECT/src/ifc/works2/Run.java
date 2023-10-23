package works2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Run {

	static Connection co;

	static boolean LogStatus;
	static LogOut lo = new LogOut();
	static LogIn li = new LogIn();
	static String name;

	public static void main(String[] args) {

		basic();
		LogStatus = false;
		while (true) {
			if (LogStatus == true) {
				li.main();
			} else if (LogStatus == false) {
				lo.main();
			}
		}

	}

	static void basic() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			co = DriverManager.getConnection("jdbc:oracle:thin:@192.168.200.128:1521/orcl", "byte1", "tiger");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	static void connect() {
		PreparedStatement ps;

		String sql = "" + "SELECT STATUS FROM CONNECTION WHERE PRO_NAME='" + name + "'";

		try {
			ps = co.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int connect = rs.getInt("STATUS");
			if (connect == 0) {
				LogStatus = false;
			} else if (connect == 1) {
				LogStatus = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
