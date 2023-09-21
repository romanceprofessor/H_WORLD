package bingo;

import java.util.Scanner;

public class Bingo {
	int number;
	int choice;
	String a = "";
	String b = "";
	public Bingo() {
		number = (int) (Math.random() * 10);

	}

	void setnumber() {
		Scanner sc = new Scanner(System.in);
		System.out.println("홀수:1,짝수:2");
		choice = sc.nextInt();

	}

	void bingogame() {
		
		if (number == 0) {
			System.out.println("0입니다 재경기");
		} else if (number % 2 == 0) {
			a = "짝수";

		} else if (number % 2 == 1) {
			a = "홀수";
		}
		if (choice == 1) {
			b = "홀수";
		} else if (choice == 2) {
			b = "짝수";

		} else {
			System.out.println("잘못입력하셨습니다");
		}
		System.out.println("랜덤숫자="+number+" "+a+"입니다.");
		System.out.println("유저의 선택:"+b );
	}
	void winAndLose(){
		if (a==b) {
			System.out.println("정답입니다");
		}
		else {
			System.out.println("틀렸습니다");
		}
	}
}
