package forexe;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int sum = 0;
		
		List tecketList = new ArrayList();
		for(int i=1;i<1001;i++) {
			EverlandTickect ev = new EverlandTickect();
			tecketList.add(ev);
			if(i%28==0) {
				sum +=0;
				System.out.println("티켓번호:"+i+",종류:"+ev.bigevent+",입장료"+ev.bigeventTi+",누적:"+sum);
			}
			else if(i%4==0) {
				sum +=ev.teenAgerTi;
				System.out.println("티켓번호:"+i+",종류:"+ev.teenager+",입장료"+ev.teenAgerTi+",누적:"+sum);
			}
			else if(i%7==0) {
				sum +=ev.preschoolchildTi;
				System.out.println("티켓번호:"+i+",종류:"+ev.preschoolchild+",입장료"+ev.preschoolchildTi+",누적:"+sum);
			}
			else {
				sum +=ev.adultTi;
				System.out.println("티켓번호:"+i+",종류:"+ev.adult+",입장료"+ev.adultTi+",누적:"+sum);
			}
			
		}
		System.out.println("총매출"+sum);
		
	}

}
