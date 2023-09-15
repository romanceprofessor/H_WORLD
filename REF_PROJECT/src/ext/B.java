package ext;

public class B extends C{
	int b;
	
	public B() {
		
		System.out.println("B 생성자");
	}
	
	public B(int i) {
		System.out.println("B-1 생성자");
	}
	
	void b() {
		System.out.println("b()");
	}
}
