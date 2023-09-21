package animal;

public class Animal extends Object {
	String name = "animal";
	abstract void fly();
	void soundFeed() {
		System.out.println("Animal Feed");
	}
	public String getName() {
		return this.name;
	}
}
