package database.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MemberInsertTest {

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
			String id = scanner.nextLine();
			pstmt.setString(1, id);
			
			System.out.println("비밀번호를 입력하시오.");
			String pw = scanner.nextLine();
			pstmt.setString(2, pw);
			
			System.out.println("이름을 입력하시오.");
			String name = scanner.nextLine();
			pstmt.setString(3, name);
			
			System.out.println("나이를 입력하시오.");
			String age = scanner.nextLine();
			pstmt.setInt(4, Integer.parseInt(age));
			
			System.out.println("성별을 입력하시오.");
			String gender = scanner.nextLine();
			pstmt.setString(5, gender);
			
			System.out.println("전화번호를 입력하시오.");
			String phone = scanner.nextLine();
			pstmt.setString(6, phone);
			
			System.out.println(pstmt.toString());
			
			int count = pstmt.executeUpdate();
			if ( 0 == count ) {
				System.out.println("회원정보 입력 실패");
			} else {
				System.out.println("회원정보 입력 성공:" + count);
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
