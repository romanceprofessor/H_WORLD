package profetrycode;

public class Starbucks {
	private int amount;
	public Starbucks(int amount) {
		this.amount = amount;
	}
	void sell(Guest guest) throws CoffeeSoldOutException {
		--this.amount;
		System.out.println("남은 수량" + this.amount);
		if ( 1 > this.amount ) {
			throw new CoffeeSoldOutException("재고 없음");
		}
	}
}