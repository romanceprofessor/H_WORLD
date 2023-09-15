
public class Calculator {

	private static int sum;
	int number;
	
	int add(int n1, int n2) {
		sum = n1+n2;
		return n1+n2;
	}
	
	
	int add(int n1, int n2, int n3) {
		sum = n1+n2+n3;
		return n1+n2+n3;
	}
	
	int del(int n1, int n2) {
		sum = n1 - n2;
		return n1-n2;
	}
	
	int getSum() {
		return sum;
	}
}
