package works2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LogOutMethod {

	Scanner sc = new Scanner(System.in);
	static Run run = new Run();
	PreparedStatement ps;

	void login() {
		System.out.println("이메일 아이디를 입력해주세요.");
		String id = sc.nextLine();
		System.out.println("비밀번호를 입력해주세요.");
		String pw = sc.nextLine();

		String sql = "" + "SELECT PASSWORD FROM WORKS WHERE PRO_EMAIL = " + "'" + id + "'";
		try {
			ps = run.co.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				if (rs.getString("PASSWORD").equals(pw)) {
					String sql2 = "" + "SELECT PRO_NAME FROM WORKS WHERE PRO_EMAIL = " + "'" + id + "'";
					ps = run.co.prepareStatement(sql2);
					ResultSet rs2 = ps.executeQuery();
					rs2.next();
					run.name = rs2.getString(1);
					System.out.println(run.name);
					System.out.println("로그인 성공");

					String sql3 = "UPDATE CONNECTION SET STATUS=1 WHERE PRO_NAME='" + run.name + "'";
					ps = run.co.prepareStatement(sql3);
					ps.executeQuery();
					run.connect();
				} else {
					System.out.println("로그인 정보가 일치하지 않습니다.");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void signin() {
		System.out.print("[이름]");
		String name = sc.nextLine();
		System.out.println("[소속]1.인사 2.경영 3.기획 4.개발 5.감사");
		String team = null;
		int int_input = sc.nextInt();
		switch (int_input) {
		case 1:
			team = "인사";
			break;
		case 2:
			team = "경영";
			break;
		case 3:
			team = "기획";
			break;
		case 4:
			team = "개발";
			break;
		case 5:
			team = "감사";
			break;
		default:
			System.out.println("올바른 값을 입력해주세요.");
			break;
		}
		System.out.println("[직급]1.사원 2.주임 3.대리 4.과장 5.차장 6.부장");
		int_input = sc.nextInt();
		sc.nextLine();
		String grade = null;
		switch (int_input) {
		case 1:
			grade = "사원";
			break;
		case 2:
			grade = "주임";
			break;
		case 3:
			grade = "대리";
			break;
		case 4:
			grade = "과장";
			break;
		case 5:
			grade = "차장";
			break;
		case 6:
			grade = "부장";
			break;
		default:
			System.out.println("올바른 값을 입력해주세요.");
			break;
		}
		String number = null;
		while (true) {
			System.out.println("[연락처]01012345678의 형식으로 작성해주세요.");
			String number_format = sc.nextLine();
			if (number_format.length() != 11) {
				System.out.println("올바르지 않은 형식의 전화번호입니다.");
				continue;
			}
			number = number_format.substring(0, 3) + "-" + number_format.substring(3, 7) + "-"
					+ number_format.substring(7, 11);
			break;
		}
		String email = null;
		while (true) {
			System.out.println("[이메일]사용하실 이메일 아이디를 '@works.com'의 형식으로 작성해주세요.");
			String email_format = sc.nextLine();
			if (email_format.contains("@works.com") == false) {
				System.out.println("올바르지 않은 형식의 이메일입니다.");
				continue;
			}
			email = email_format;
			break;
		}
		String password = null;
		while (true) {
			System.out.print("[비밀번호]");
			String password_temp = sc.nextLine();
			System.out.print("[비밀번호 체크]");
			String password_check = sc.nextLine();
			if (password_temp.equals(password_check) == false) {
				System.out.println("비밀번호가 일치하지 않습니다.");
				continue;
			}
			password = password_temp;
			break;
		}

		System.out.println("[이름]" + name + "\n[소속]" + team + "\n[직급]" + grade + "\n[연락처]" + number + "\n[이메일]" + email
				+ "\n위 정보가 맞습니까?\n[1]네[2]아니오");
		int input = sc.nextInt();
		if (input == 1) {
			String sql = "" + "INSERT INTO WORKS" + "(PRO_NAME,PRO_TEAM,PRO_GRADE,PRO_NUMBER,PRO_EMAIL,PASSWORD)"
					+ "VALUES(?,?,?,?,?,?)";

			try {
				ps = run.co.prepareStatement(sql);
				ps.setString(1, name);
				ps.setString(2, team);
				ps.setString(3, grade);
				ps.setString(4, number);
				ps.setString(5, email);
				ps.setString(6, password);

				ps.executeUpdate();

				String sql2 = "" + "INSERT INTO CONNECTION (PRO_NAME,STATUS)" + " VALUES('" + name + "',0)";

				ps = run.co.prepareStatement(sql2);
				ps.executeUpdate();

				System.out.println("계정 생성에 성공했습니다.\n새로 생성한 계정으로 로그인해주세요.");
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (input == 2) {
			return;
		}

	}

	void findPW() {
		System.out.println("이메일 아이디를 입력해주세요.");
		String email = sc.nextLine();
		System.out.println("이름을 입력해주세요.");
		String name = sc.nextLine();
		System.out.println("비밀번호를 찾는 중입니다");
		for (int i = 0; i < 15; i++) {
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(".");
		}

		String sql = "" + "SELECT PASSWORD " + "FROM WORKS " + "WHERE PRO_EMAIL=" + "'" + email + "'" + " AND PRO_NAME="
				+ "'" + name + "'";

		try {
			ps = run.co.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			String password = rs.getString("PASSWORD");
			if (password != null) {
				System.out.println();
				System.out.println("요청하신 비밀번호는 " + password + "입니다.");
			} else {
				System.out.println("해당하는 정보가 존재하지 않습니다. 다시 한번 확인해주세요.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
