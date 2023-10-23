
import java.util.Scanner; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBase {
	public static void main(String[] args) {
		String a;
		String b;
		String c;
		int d;
		String f;
		String g,h;
		
		Connection conn = null;
		try {
			//JDBC Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			
			//연결하기
			conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521/orcl", 
				"lee", 
				"1234"
			);	
			Scanner s = new Scanner(System.in);
			System.out.println("유저아이디 입력");
			a = s.nextLine();
			System.out.println("유저이름 입력");
			b = s.nextLine();
			System.out.println("유저비밀번호 입력");
			c = s.nextLine();
			System.out.println("유저나이 입력");
			d = s.nextInt();
			System.out.println("전화번호 입력");
			f = s.nextLine();
			System.out.println("생성일시 입력");
			g = s.nextLine();
			System.out.println("성별 입력");
			g = s.nextLine();
			//매개변수화된 SQL 문 작성
			String sql = "" +
				"INSERT INTO users(userid, username, userpassword, userage, userphone,userdate,gender)" + "VALUES(?,?,?,?,?,?,?)";
			
			//PreparedStatement 얻기 및 값 지정
			PreparedStatement pt = conn.prepareStatement(sql);
			pt.setString(1, a);
			pt.setString(2, b);
			pt.setString(3, c);
			pt.setInt(4, d);
			pt.setString(5, f);
			pt.setString(6, g);
			pt.setString(7, h);
			
			
			//SQL 문 실행
			int rows = pt.executeUpdate();
			System.out.println("저장된 행 수: " + rows);
			
			//PreparedStatement 닫기
			
			pt.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try { 
					//연결 끊기
					conn.close(); 
				} catch (SQLException e) {}
			}
		}
	}
}