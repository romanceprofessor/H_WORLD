package starbucks3;
import java.util.Scanner;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		

		
		
		System.out.println("한잔당 가격=");
		int price = scanner.nextInt();
		Starbucks sb =new Starbucks(price); //한잔당 가격 
		
		System.out.println("스타벅스가 가진돈=");
		int smoney = scanner.nextInt();
		sb.havingMoney(smoney); //스타벅스가 처음에 가진돈 
		
		System.out.println("손님이 가진돈=");
		int gmoney = scanner.nextInt();
		Guest gs = new Guest(gmoney);//손님이 처음에 가진돈
		
		System.out.println("수량=");
		int count = scanner.nextInt();//주문수량
		
		int total = sb.total(count); //총액 메소드 불러오기
		System.out.println("총액="+total);
		
		int starmoney = sb.lastMoney(total);//결제후 스타벅스가 가진돈
		int guestmoney = gs.lastMoney(total);//결제후 손님에게 남은돈
		System.out.println("스타벅스가 가진돈:"+starmoney);
		System.out.println("손님 남은돈:"+guestmoney);
	}

}
