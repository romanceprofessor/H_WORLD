
public class CalculatorTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator cal = new Calculator();
		
		int result = cal.add(1,1);
		System.out.println(result);
		
		result = cal.del(5,1);
		System.out.println(result);
		System.out.println(cal.getSum());
		
		result = cal.add(1,2,3);
		System.out.println(result);
	}

}
