package CGV;
import java.util.*;

public class Tester {

	public static void main(String[] args) {
		MovieTicket t1 = new MovieTicket();
		Scanner sc = new Scanner(System.in);
		int menu;
		boolean exit = true;
		String info;
		
		while(exit) {
			System.out.println("****************");
			System.out.println("메뉴를 선택해주세요.");
			System.out.println("0. 종료");
			System.out.println("1. 티켓정보 출력");
			System.out.println("2. 상영일 변경");
			System.out.println("3. 영화 변경");
			System.out.println("4. 상영관 변경");
			System.out.println("****************");
			
			menu = sc.nextInt();
			sc.nextLine();
			
			if(menu==0) {
				System.out.println("종료합니다.");
				exit = false;
			}else {
				if(menu==1) {
					t1.printInfo();
				}else {
					if(menu==2) {
						System.out.print("변경할 상영일을 입력하세요 : ");
					}else if(menu==3) {
						System.out.print("변경할 영화 제목을 입력하세요 : ");
					}else if(menu==4) {
						System.out.print("변경할 상영관을 입력하세요 : ");
					}else {
						System.out.println("잘못입력하셨습니다.");
						continue;
					}
					info = sc.nextLine();
					t1.fixTicket(menu,info);
				}
				
			}
			
		}
		
		sc.close();
	}
}
