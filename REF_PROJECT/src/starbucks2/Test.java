package starbucks2;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("한잔당 가격=");
		int price = scanner.nextInt();
		Starbucks sb =new Starbucks(price);
	
		System.out.println("수량=");
		int count = scanner.nextInt();
		int total = sb.total(count);
		System.out.println("총액="+total);
		

	
	}

}
