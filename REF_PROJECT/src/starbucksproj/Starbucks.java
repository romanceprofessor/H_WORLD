package starbucksproj;

public class Starbucks {
	int coffeeNum ;
	int coffee;
	public Starbucks(int a) {
		coffeeNum = a;
		coffee = 200-a;
	}

	
	
	
	
	public void sell(int num) throws CoffeeSoldOutException {
		if (num>200) {
			throw new CoffeeSoldOutException("[재고부족]");
		}
		System.out.println(num+"번째 손님 주문완료");
	}

}
