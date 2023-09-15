package singleton;

public class SingletonTester {
	public static void main(String[] args) {
		Singleton plane = Singleton.getInstance();
		
		plane.fly();
	}
}
