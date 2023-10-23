package works2;

import java.util.Scanner;

public class LogIn {

	Scanner sc = new Scanner(System.in);
	static LogInMethod lim = new LogInMethod();

	void main() {
		System.out.println("[1]게시판[2]쪽지[3]프로필 조회[4]회원정보 변경[5]로그아웃");
		String input = sc.nextLine();

		switch (input) {

		case "1":
			lim.board();
			break;
		case "2":

			break;
		case "3":
			lim.viewProfile();
			break;
		case "4":
			lim.updateProfile();
			break;
		case "5":
			lim.logout();
			break;
		default:
			System.out.println("올바른 값을 입력해주세요.");
			break;
		}
	}
}
