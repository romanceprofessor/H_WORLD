package starbucks3;

public class Starbucks {
	int priceOfIceAme;
	
	int starbucksMoney;
	public Starbucks(int priceOfIceAme) {
		this.priceOfIceAme = priceOfIceAme;
		
	}
	int total(int count) {
		return priceOfIceAme*count;
		
	}
	int havingMoney(int smoney) {
		return starbucksMoney = smoney;
	}
	int lastMoney(int total) {
		return starbucksMoney +total;
	}
}
