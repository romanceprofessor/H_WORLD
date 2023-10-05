package collect;

import java.util.List;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		CGV cgv = new CGV();
		cgv.setoph();
		cgv.setSuger();
		System.out.println();
		List list = cgv.searchEvent("oph");
		for(int i =0; i<list.size();i++) {
			Map map = (Map)list.get(i);
			System.out.println("날짜:"+map.get("date"));
			System.out.println("시각:"+map.get("time"));
			System.out.println("제목:"+map.get("title"));
			System.out.println("-------------------------");
		}
		List list1 = cgv.searchEvent("suger");
		for(int i =0; i<list1.size();i++) {
			Map map = (Map)list1.get(i);
			System.out.println("날짜:"+map.get("date"));
			System.out.println("시각:"+map.get("time"));
			System.out.println("제목:"+map.get("title"));
			System.out.println("-------------------------");
		}
		System.out.println();
	}

}
