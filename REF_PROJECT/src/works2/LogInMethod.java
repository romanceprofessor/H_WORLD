package works2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/***** 현재 로그인 상태일시 사용하는 기능들 *****/
public class LogInMethod {

	Scanner sc = new Scanner(System.in);
	static Run run = new Run();
	static Board board = new Board();
	static LogIn li = new LogIn();
	static LogOut lo=new LogOut();
	static Note note = new Note();
	PreparedStatement ps;
	PreparedStatement ps2;
	/***** 로그인 상태 -> 로그아웃하는 메소드 *****/
	void logout() {
		String sql = "UPDATE CONNECTION SET STATUS=0 WHERE PRO_NAME='" + run.name + "'";
		try {
			ps = run.co.prepareStatement(sql);
			ps.executeQuery();
			run.connect(); /** Run클래스에 connect 함수 호출, 해당 함수는 로그인 상태에서 호출시 로그아웃으로 업데이트 **/
			System.out.println("정상적으로 로그아웃되었습니다.");
			System.out.println(run.LogStatus);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/***** 회원정보 변경 메소드 *****/
	void updateProfile() {
		String name = null;
		String team = null;
		String grade = null;
		String number = null;
		String email = null;
		String password = null;
		/***** 접속자의 이름에 맞는 데이터를 DB를 통해 조회 *****/
		String sql = "SELECT * FROM WORKS WHERE PRO_NAME='" + run.name + "'";

		try {
			ps = run.co.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				name = rs.getString("PRO_NAME");
				team = rs.getString("PRO_TEAM");
				grade = rs.getString("PRO_GRADE");
				number = rs.getString("PRO_NUMBER");
				email = rs.getString("PRO_EMAIL");
				password = rs.getString("PASSWORD");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("어떤 정보를 수정하시겠습니까?");
		System.out.println("[이름]" + name + "\n[소속]" + team + "\n[직급]" + grade + "\n[연락처]" + number + "\n[이메일]" + email); /** 접속자의 현재 정보 조회 및 어떤 정보 수정할지 선택 **/
		String input = sc.nextLine();
		String input2;
		int x = 0;
		String[] subject = { "소속", "직급", "연락처", "이메일" };
		String[] subject2 = { "team", "grade", "number", "email" };

		if (input.equals("이름")) { /** 이름을 수정할 경우/이름을 통해 DB에 접속하는 경우가 많기 때문에 따로 조치 **/
			System.out.println("바꿀 내용을 입력해주세요.");
			input2 = sc.nextLine();

			String sql2 = "UPDATE WORKS SET PRO_NAME='" + input2 + "' WHERE PRO_NAME='" + name + "'";
			String sql3 = "UPDATE CONNECTION SET PRO_NAME='" + input2 + "' WHERE PRO_NAME='" + name + "'";
			try {
				ps = run.co.prepareStatement(sql2);
				ps.executeQuery();
				ps2 = run.co.prepareStatement(sql3);
				ps2.executeQuery();
				run.name = input2;
				System.out.println(run.name);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			for (int i = 0; i < subject.length; i++) { /** 소속,직급,연락처,이메일중 선택 **/
				if (input.contains(subject[i])) {
					System.out.println("바꿀 내용을 입력해주세요.");
					input2 = sc.nextLine();
					boolean check = false;

					String[] subject3 = { "인사", "경영", "기획", "개발", "감사" };
					String[] subject4 = { "사원", "주임", "대리", "과장", "차장", "부장" };

					if (input.equals("소속")) {
						for (int j = 0; j < subject3.length; j++) {
							if (input2.equals(subject3[j])) {
								check = true;
							}
						}
					} else if (input.equals("직급")) {
						for (int j = 0; j < subject4.length; j++) {
							if (input2.equals(subject4[j])) {
								check = true;
							}
						}
					} else if (input.equals("연락처")) {
						if (input2.length() == 11) {
							input2 = input2.substring(0, 3) + "-" + input2.substring(3, 7) + "-"
									+ input2.substring(7, 11);
							check = true;
						}
					} else if (input.equals("이메일")) {
						if (input2.contains("@works.com") == true) {
							check = true;
						}
					}
					if (check == false) {
						System.out.println("올바른 값을 입력해주세요.");
						return;
					} else if (check == true) {
						String sql2 = "UPDATE WORKS SET PRO_" + subject2[i] + "='" + input2 + "' WHERE PRO_NAME='"
								+ name + "'";
						String sql3 = "UPDATE CONNECTION SET PRO_" + subject2[i] + "='" + input2 + "' WHERE PRO_NAME='"
								+ name + "'";
						try {
							ps = run.co.prepareStatement(sql2);
							ps.executeQuery();
							System.out.println(run.name);
							break;
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}

				}
			}

		}

	}
	/***** 게시판 메소드 *****/
	void board() {
		System.out.println("[1]게시글 작성[2]게시글 조회[3]게시글 수정[4]게시글 삭제[5]뒤로 가기");
		String input = sc.nextLine();
		switch (input) {
		/***** 게시판 클래스 별도 이용 *****/
		case "1":
			board.writeBoard();
			break;
		case "2":
			board.readBoard();
			break;
		case "3":
			board.fixBoard();
			break;
		case "4":
			board.deleteBoard();
			break;
		case "5":
			li.main();
			break;
		default:
			System.out.println("올바른 값을 입력해주세요.");
			break;
		}
	}
	/***** 프로필 조회 메소드 *****/
	void viewProfile() {
		try {
			Filter.main(); /** 프로필 조회 클래스 별도 이용 **/
		} catch (Exception e) {			
		}
	}
	/***** 쪽지 메소드 *****/
	void note() {
		System.out.println("[1]쪽지 발송[2]쪽지 확인[3]쪽지 삭제[4]뒤로 가기");
		String input = sc.nextLine();
		switch (input) {
		/** 쪽지 클래스 별도 이용 **/
		case "1":
			note.writeNote();
			break;
		case "2":
			note.readNote();
			break;
		case "3":
			note.deleteNote();
			break;
		case "4":
			li.main();
			break;
		default:
			System.out.println("올바른 값을 입력해주세요.");
			break;
		}
	}
}
