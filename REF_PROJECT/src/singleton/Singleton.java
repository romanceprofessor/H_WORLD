package singleton;

public class Singleton {
	private static Singleton sg = new Singleton();
	
	private Singleton() {
		// TODO Auto-generated constructor stub
	}
	
	public static Singleton getInstance() {
		return sg;
	}
	
	public void fly() {
		System.out.println("난다!");
	}
}
