package rps;

import java.util.Scanner;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("묵찌빠 게임: 묵=0,찌=1,빠=2");
		int a = sc.nextInt();
		int num = (int) (Math.random() * 3);
		if (num == 0) {
			System.out.println("컴퓨터:묵");
			if (a == 1) {
				System.out.println("손님:찌");
				System.out.println("컴퓨터승!");
			} else if (a == 2) {
				System.out.println("손님:빠");
				System.out.println("손님승!");
			}
		}
		if (num == 1) {
			System.out.println("컴퓨터:찌");
			if (a == 2) {
				System.out.println("손님:빠");
				System.out.println("컴퓨터승!");
			} else if (a == 0) {
				System.out.println("손님:묵");
				System.out.println("손님승!");
			}
		} else if (num == 0) {
			System.out.println("컴퓨터:묵");
			if (a == 1) {
				System.out.println("손님:찌");
				System.out.println("컴퓨터승!");
			} else if (a == 2) {
				System.out.println("손님:빠");
				System.out.println("손님승!");
			}

		} else if (num == 2) {
			System.out.println("컴퓨터:빠");
			if (a == 0) {
				System.out.println("손님:묵");
				System.out.println("컴퓨터승!");
			} else if (a == 1) {
				System.out.println("손님:찌");
				System.out.println("손님승!");
			}
		} else if (num == a) {
			if (num == 2) {
				System.out.println("컴퓨터:빠");
				System.out.println("손님:빠");
				System.out.println("비겼습니다");
			}
			if (num == 1) {
				System.out.println("컴퓨터:찌");
				System.out.println("손님:찌");
				System.out.println("비겼습니다");
			}
			if (num == 0) {
				System.out.println("컴퓨터:묵");
				System.out.println("손님:묵");
				System.out.println("비겼습니다");
			}
		} else {
			System.out.println("잘못된 입력입니다.");
			
		}
	}
}
