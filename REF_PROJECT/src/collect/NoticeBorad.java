package collect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Scanner;
public class NoticeBorad {
	List noteList;
	Scanner sc = new Scanner(System.in);
	public NoticeBorad() {
		noteList = new ArrayList();
	}
	void setnote() {
		List list = new ArrayList();
		Map map = new HashMap();
		map.put("Title", "국어");
		map.put("contain", "어쩌구 저쩌구 랄라블라");
		map.put("name", "이승혁");
		list.add(map);
		
		
		map = new HashMap();
		map.put("Title", "수학");
		map.put("contain", "어쩌구 저쩌구 랄라블라");
		map.put("name", "이승혁");
		list.add(map);
		
		Map eMap = new HashMap();
		eMap.put("note", list);
		
		noteList.add(eMap);
	}
	void writenote() {
		Scanner sc = new Scanner(System.in);
		System.out.println("제목을 입력하세요");
		String a = sc.nextLine();
		System.out.println("내용을 입력하세요");
		String b = sc.nextLine();
		System.out.println("작성자명을 입력하세요");
		String c = sc.nextLine();
		Map map = new HashMap();
		map.put("Title", a);
		map.put("contain", b);
		map.put("name", c);
		
		List list = new ArrayList();
		list.add(map);
		
		Map eMap = new HashMap();
		eMap.put("작성", list);
		
		noteList.add(eMap);
	}
	List searchEvent(String event) {
		List resultList = null;
		outter : for ( int i = 0 ; i < noteList.size() ; i++ ) {
			Map map = (Map)noteList.get(i);
			Set set = map.keySet();
			
			Iterator ite = set.iterator();
			
			while ( ite.hasNext() ) {
				
				String name = (String)ite.next();
				if ( event.equals(name) ) {
					
					resultList = (List)map.get(name);
					break outter;
				}
			}
		}
		
		return resultList;
	}
}
