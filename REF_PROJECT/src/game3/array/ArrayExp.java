package game3.array;



public class ArrayExp {
	
	int[] arr = new int[10];
	int[] arrEven = new int[10];
	int max;
	
	public ArrayExp() {
		int number = 0 ;
		int indexOfEven = 0;
		for ( int i = 0 ; i<arr.length ; i++ ) {
			number = (int)(Math.random()*100)+1;
			arr[i] = number;
			if ( 0 == number % 2 ) {
				arrEven[indexOfEven] = number;
				indexOfEven++;
			}
		}
	}
	
	void getMaxArr() {
		int num1 = arr[0];
		int num2 = arr[1];
		max = getMaxNum(num1, num2);
		for ( int i = 2 ; i < arr.length ; i++ ) {
			max = getMaxNum(max, arr[i]);
		}
	}
	
	int getMaxNum(int num1, int num2) {
		if ( num1 > num2 ) {
			return num1;
		} else {
			return num2;
		}
	}
	
	
	
	
	
	
	

}
