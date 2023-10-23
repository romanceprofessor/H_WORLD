package database.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberInsertTest {

	public static void main(String[] args) {

		Connection conn = null;
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/orcl", 
					"scott", 
					"tiger"
				);
			
			String sql = "INSERT INTO member ("
					+ "    ID"
					+ "    ,PW"
					+ "    ,NAME"
					+ "    ,AGE"
					+ "    ,GENDER"
					+ "    ,PHONE"
					+ ") VALUES ("
					+ "    ?"
					+ "    ,?"
					+ "    ,?"
					+ "    ,?"
					+ "    ,?"
					+ "    ,?"
					+ ")";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			System.out.println("아이디를 입력하시오.");
			pstmt.setString(1, id);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(null != conn) {
				try { 
					conn.close(); 
				} catch (SQLException e) {}
			}
		}
		
		System.out.println("성공");
			
	}

}
