package database.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MemberSelectTest {

	public static void main(String[] args) {
		
		Connection conn = null;
		Scanner scanner = new Scanner(System.in);
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/orcl", 
					"lee", 
					"1234"
				);
			
			String sql = "SELECT  SEQ"
					+ "        ,ID"
					+ "        ,PW"
					+ "        ,NAME"
					+ "        ,AGE"
					+ "        ,NVL(GENDER,'')AS GENDER"
					+ "        ,PHONE"
					+ "        ,CREATE_DATE"
					+ " FROM MEMBER";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			while ( rs.next() ) {
				System.out.print(rs.getString("SEQ") + " | ");
				System.out.print(rs.getString("ID") + " | ");
				System.out.print(rs.getString("PW") + " | ");
				System.out.print(rs.getString("NAME") + " | ");
				System.out.print(rs.getString("AGE") + " | ");
				System.out.print(rs.getString("GENDER") + " | ");
				System.out.print(rs.getString("PHONE") + " | ");
				System.out.print(rs.getString("CREATE_DATE"));
				System.out.println();
			}
			
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
			scanner.close();
		}

	}

}
