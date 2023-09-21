package ifc;

public class CTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//B b = new C();
		//A a = new C();
		//a.a();
		//b.b();
		C c = new C();
		
		ct1(new C());
		ct1(null);
		ct1(c);
	}	
		static void ct1(C c) {
			System.out.println("Hello World");
		}
		
	

}
