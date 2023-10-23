package profetrycode;

public class Test {
	public static void main(String[] args) {
		Starbucks starbuck = new Starbucks(200);
		while (true) {
			try {
				starbuck.sell(new Guest());
			} catch (CoffeeSoldOutException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				break;
			}
		}
		System.out.println("스벅 closed");
	}
}