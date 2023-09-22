package forifgame;
import java.util.Scanner;
public class Game1 {
	int comNumber;
	int userNumber;
	boolean a = true;
	int i = 1;
	public Game1() {
			
		int i = 1;
		comNumber = (int)(Math.random()*100)+1;
	}
	void setComnum() {
		
		System.out.println("스무고개 게임에 오신걸 환영합니다.");
		
	}
	void game() {
		while(a==true) {
			System.out.println("숫자를 입력하세요(1~100)");
			Scanner sc = new Scanner(System.in);
			userNumber = sc.nextInt();
			if(userNumber!=comNumber) {
				if(userNumber<comNumber) {
					System.out.println(userNumber+"보다더큰수 입니다 다시시도하세요.");
					i++;
				
				}
				else if (userNumber>comNumber) {
					System.out.println(userNumber+"보다 더 작은수 입니다 다시시도하세요.");
					i++;
				
				}
		
			}
			else if (userNumber==comNumber) {
				System.out.println(i+"번째에서 성공하셨습니다.정답:"+userNumber);
				break;
			}	
	}
}}
