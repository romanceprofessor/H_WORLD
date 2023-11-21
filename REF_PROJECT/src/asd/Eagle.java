package asd;

public class Eagle extends Animal implements Fly {
	@Override
	void sound() {
		System.out.println("noise");
	}
	@Override
	void fly() {
		System.out.println("난다~");
		
	}
}
