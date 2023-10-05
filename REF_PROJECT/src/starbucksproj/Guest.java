package starbucksproj;

public class Guest {
	int guestNum ;
	public  Guest(int b) {
		guestNum = b;
	}
	public void order(int i) {
		System.out.println(i+"번째 손님 커피주문하기");
	}
}
