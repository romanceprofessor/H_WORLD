package animal;

import animal.ext.Tiger;

public class Zookeeper {
	Animal a;
	void feed(Object a) {
		if (a instanceof Tiger) {
			System.out.print("Tiger Feed");
		}else {
			a.soundFeed();
		}
		
		
	
	}
	
}
