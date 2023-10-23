package works2;

import java.sql.SQLException;
import java.util.Scanner;

public class LogOut {

	Scanner sc = new Scanner(System.in);
	static LogOutMethod lom = new LogOutMethod();

	void main() {
		System.out.println("[1]로그인[2]회원가입[3]비밀번호 찾기[4]종료");
		String input = sc.nextLine();

		switch (input) {

		case "1":
			lom.login();
			break;
		case "2":
			lom.signin();
			break;
		case "3":
			lom.findPW();
			break;
		case "4":
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);
			break;
		default:
			System.out.println("올바른 값을 입력해주세요.");
			break;
		}
	}
}
