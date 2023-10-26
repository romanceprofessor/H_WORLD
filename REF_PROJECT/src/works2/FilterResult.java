package works2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// 번호순 정렬, 잘못 입력 시 다시 입력 받는 기능 추가해야함 
public class FilterResult { // 검색결과 및 프로필 조회
	
	static Run run=new Run();
	static LogIn li = new LogIn();
	static Filter fi=new Filter();
	
	static void result(PreparedStatement pstmt) {
		try {
			Scanner sc = new Scanner(System.in);
			
			pstmt = run.co.prepareStatement(Filter.getSql());
			String search = sc.nextLine();
			pstmt.setString(1, search);
			ResultSet rs = pstmt.executeQuery();

			if (rs != null && rs.isBeforeFirst()) {
				// 필터링된 검색 결과
				System.out.println(search+"에 대한 검색 결과 입니다.");
								
				while (rs.next()) {
					String name = rs.getString("PRO_NAME");
					String team = rs.getString("PRO_TEAM");
					String grade = rs.getString("PRO_GRADE");
					String number = rs.getString("PRO_NUMBER");
					String email = rs.getString("PRO_EMAIL");
					System.out.println("[이름]"+name+"\n[소속]"+team+"\n[직급]"+grade+"\n[연락처]"+number+"\n[이메일]"+email+"\n==============================");
				}

				// 뒤로가기 또는 돌아가기 선택지
				System.out.println("[1]뒤로 가기[2]메인으로 돌아가기");
				int back = sc.nextInt();
				sc.nextLine();
				if (1 == back) { // SearchFilter 로 돌아가기
					fi.main();
				}
				else if (2 == back) { // Main 으로 돌아가기
					li.main();
				}
			} else { // 잘못된 입력시
				System.out.println("");
				System.out.println("검색 결과가 존재하지 않습니다.");
				System.out.println("다시 입력하려면 Enter를 눌러주세요.");
				sc.nextLine();
				Filter.main();
			}
		} catch (SQLException e) {
			System.out.println("올바른 값을 입력해주세요.");
			Filter.main();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
