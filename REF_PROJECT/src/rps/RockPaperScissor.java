package rps;

import java.util.Scanner;

public class RockPaperScissor {
	int comNumber;
	int guestNumber;

	public RockPaperScissor() {
		comNumber = (int) (Math.random() * 3) + 1;

	}

	void setGuestNumber() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("숫자 하나 선택하시오.(1.가위,2.바위,3.보)");
		guestNumber = scanner.nextInt();
		
	}

	void printNumber() {
		String comNumKor = "";
		String guestNumKor = "";

		if (comNumber == 1) {
			comNumKor = "가위";
		} else if (comNumber == 2) {
			comNumKor = "바위";
		} else if (comNumber == 3) {
			comNumKor = "보";
		}

		if (guestNumber == 1) {
			guestNumKor = "가위";
		} else if (guestNumber == 2) {
			guestNumKor = "바위";
		} else if (guestNumber == 3) {
			guestNumKor = "보";
		}
		else {
			System.out.println("잘못입력하였습니다");
		
		}

		System.out.println("컴퓨터:" + comNumKor);
		System.out.println("유저:" + guestNumKor);
		
	}
	void winAndLose() {
		if ((comNumber ==1&&guestNumber==2)||(comNumber ==3&&guestNumber==1)||(comNumber ==2&&guestNumber==3)) {
			System.out.println("손님승!");
		}
		else if ((comNumber ==2&&guestNumber==1)||(comNumber ==1&&guestNumber==3)||(comNumber ==3&&guestNumber==2)) {
			System.out.println("컴퓨터승!");
		}
		else if(comNumber == guestNumber){
			System.out.println("비겼습니다.");
		}
	}
}
