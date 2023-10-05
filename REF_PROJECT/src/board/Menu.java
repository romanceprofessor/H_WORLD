package board;
import java.util.Scanner;
public class Menu {
	void display() {
		Scanner scanner = new Scanner(System.in);
		DataBase db = new DataBase();
		while ( true ) {
			System.out.println("1.게시글 보기");
			System.out.println("2.게시글 작성");
			System.out.println("3.프로그램 종료");
			System.out.println("메뉴를 선택하시오>");
			int choice = scanner.nextInt();
			if ( 1 == choice ) {	
				db.showList();
				
				
			}
			if ( 2 == choice ) {
				db.writeBoard();
				
				
			}
			if ( 3 == choice ) {
				break;
			}
		}
		System.out.println("종료했습니다.");
	}

}
