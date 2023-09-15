package starbucks;

public class StarbucksTester {

	public static void main(String[] args) {
		Starbucks starbucks = new Starbucks();
		Guest guest = new Guest(new Money());
		guest.order(starbucks);
		
	}

}
