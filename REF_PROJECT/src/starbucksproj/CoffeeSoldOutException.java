package starbucksproj;

public class CoffeeSoldOutException extends Exception {
	public CoffeeSoldOutException() {
	}

	public CoffeeSoldOutException(String message) {
		super(message);
	}
}
