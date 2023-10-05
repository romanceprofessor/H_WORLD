package collect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CGV {
	
	List eventList;
	
	public CGV() {
		eventList = new ArrayList();
	}
	
	void setoph() {
		List list = new ArrayList();
		Map map = new HashMap();
		map.put("date", "9월24일(일)");
		map.put("time", "11:30");
		map.put("title", "오펜하이머");
		
		
		list.add(map);
		
		map = new HashMap();
		map.put("date", "9월26일(화)");
		map.put("time", "12:40");
		map.put("title", "오펜하이머");
		list.add(map);
		
		Map eMap = new HashMap();
		eMap.put("oph", list);
		
		eventList.add(eMap);
		
	}
	
	void setSuger() {
		List list = new ArrayList();
		
		Map map = new HashMap();
		map.put("date", "10월1일(일)");
		map.put("time", "11:20");
		map.put("title", "달짝지근해");
		list.add(map);
		
		map = new HashMap();
		map.put("date", "10월4일(수)");
		map.put("time", "15:20");
		map.put("title", "달짝지근해");
		list.add(map);
		
		Map eMap = new HashMap();
		eMap.put("suger", list);
		
		eventList.add(eMap);
		
	}
	
	List searchEvent(String event) {
		List resultList = null;
		outter : for ( int i = 0 ; i < eventList.size() ; i++ ) {
			Map map = (Map)eventList.get(i);
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