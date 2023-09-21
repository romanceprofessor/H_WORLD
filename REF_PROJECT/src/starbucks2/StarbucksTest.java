package starbucks2;

import java.util.Scanner;

public class StarbucksTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("한잔당 가격=");
		String strX = scanner.nextLine();
		int x=Integer.parseInt(strX);
		
		
		
		
		
		
		System.out.print("수량:");
		String strY = scanner.nextLine();
		int y = Integer.parseInt(strY);
		int result = x*y;
		
		System.out.println("총액:"+result+"원");
	}

}
