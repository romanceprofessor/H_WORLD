package ext;

public class A extends B{
	int a;
	
	public A() {
		// TODO Auto-generated constructor stub
		super(1);
		System.out.println("A 생성자");
	}
	
	void a() {
		b();
	}
	
	void a2() {
		a();
	}
	
	@Override
	void b() {
		System.out.println("b2()");
	}
}
