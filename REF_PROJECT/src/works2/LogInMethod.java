package works2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LogInMethod {

	Scanner sc = new Scanner(System.in);
	static Run run = new Run();
	static Board board = new Board();
	static LogIn li = new LogIn();
	static Note note = new Note();
	PreparedStatement ps;
	PreparedStatement ps2;

	void logout() {
		String sql = "UPDATE CONNECTION SET STATUS=0 WHERE PRO_NAME='" + run.name + "'";
		try {
			ps = run.co.prepareStatement(sql);
			ps.executeQuery();
			run.connect();
			System.out.println("정상적으로 로그아웃되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void updateProfile() {
		String name = null;
		String team = null;
		String grade = null;
		String number = null;
		String email = null;
		String password = null;

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
		System.out.println("[이름]" + name + "\n[소속]" + team + "\n[직급]" + grade + "\n[연락처]" + number + "\n[이메일]" + email);
		String input = sc.nextLine();
		String input2;
		int x = 0;
		String[] subject = { "소속", "직급", "연락처", "이메일" };
		String[] subject2 = { "team", "grade", "number", "email" };

		if (input.equals("이름")) {
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
			for (int i = 0; i < subject.length; i++) {
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
					if(check==false)
					{
						System.out.println("올바른 값을 입력해주세요.");
						return;
					}
					else if(check==true)
					{
						String sql2 = "UPDATE WORKS SET PRO_" + subject2[i] + "='" + input2 + "' WHERE PRO_NAME='" + name
								+ "'";
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

	void board() {
		System.out.println("[1]게시글 작성[2]게시글 조회[3]게시글 수정[4]게시글 삭제[5]뒤로 가기");
		String input = sc.nextLine();
		switch (input) {

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

	void viewProfile() {
		List<Profile> list = new ArrayList<Profile>();
		String[] team1 = { "인사", "경영", "기획", "개발", "감사" };
		String[] grade1 = { "사원", "주임", "대리", "과장", "차장", "부장" };

		System.out.println("[1]인사\n[2]경영\n[3]기획\n[4]개발\n[5]감사\n[6]뒤로가기");
		int input = sc.nextInt();
		sc.nextLine();
		if (input == 6) {
			li.main();
		} else if (input != 6) {
			String sql = "SELECT * FROM WORKS WHERE PRO_TEAM='" + team1[input - 1] + "'";

			try {
				ps = run.co.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					Profile pf = new Profile();
					pf.setName(rs.getString(1));
					pf.setTeam(rs.getString(2));
					pf.setGrade(rs.getString(3));
					pf.setNumber(rs.getString(4));
					pf.setEmail(rs.getString(5));
					list.add(pf);
				}
				for (int i = 0; i < list.size(); i++) {
					Profile profile = list.get(i);
					System.out.println("[이름]" + profile.getName());
					System.out.println("[소속]" + profile.getTeam());
					System.out.println("[직급]" + profile.getGrade());
					System.out.println("[연락처]" + profile.getNumber());
					System.out.println("[이메일]" + profile.getEmail());
					System.out.println("============================");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	void note() {
		System.out.println("[1]쪽지 발송[2]쪽지 확인[3]쪽지 삭제[4]뒤로 가기");
		String input = sc.nextLine();
		switch (input) {

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
