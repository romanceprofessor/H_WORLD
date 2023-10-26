package works2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Run {

	static Connection co;

	static boolean LogStatus; /** 현재 로그인 상태 **/
	static LogOut lo = new LogOut();
	static LogIn li = new LogIn();
	static String name; /**접속자의 이름**/

	public static void main(String[] args) {

		basic();
		LogStatus = false; /** 처음 접속시 로그아웃 상태 **/
		while (true) {
			if (LogStatus == true) {
				li.main(); /** 로그인 상태가 true일 경우 로그인 클래스 **/
			} else if (LogStatus == false) {
				lo.main(); /** 로그인 상태가 false일 경우 로그아웃 클래스 **/
			}
		}
	}
	/***** DB 접속 *****/
	static Connection basic() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			co = DriverManager.getConnection("jdbc:oracle:thin:@192.168.200.128:1521/orcl", "byte1", "tiger");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return co;
	}
	/***** 로그인 상태에서 메소드 호출시 로그아웃, 로그아웃 상태에서 메소드 호출시 로그인 *****/
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
