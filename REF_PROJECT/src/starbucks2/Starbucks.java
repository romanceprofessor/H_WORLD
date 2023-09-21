package starbucks2;

public class Starbucks {

	int priceOfIceAme;
	int countOfIceAme;
	String a;
	public Starbucks(int priceOfIceAme) {
		this.priceOfIceAme = priceOfIceAme;
		
	}

	int total(int count) {
		return priceOfIceAme*count;
		
	}
	
}
