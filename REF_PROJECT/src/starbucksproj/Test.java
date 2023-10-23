package starbucksproj;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Starbucks sb = null;
		Guest gs = null;
		for(int i=1;i<202;i++) {
			sb = new Starbucks(i);
			gs = new Guest(i);
			try {
				
				gs.order(i);
				sb.sell(i);
				
				if (i<201) {
					System.out.println("손님번호:"+gs.guestNum);
					System.out.println("커피번호:"+sb.coffeeNum);
					System.out.println("남은 재고:"+sb.coffee);
				}
				
			}catch (CoffeeSoldOutException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			
			
		
		}
					
		System.out.println("영업종료");		
			
	
	}

}
