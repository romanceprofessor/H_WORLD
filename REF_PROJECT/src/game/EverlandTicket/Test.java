package game.EverlandTicket;

import java.util.List;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int total = 0;
		List ticketList = new ArrayList();
		EverlandTicket et = null;
		for (int i = 1; i < 1001; i++) {
			if(i%28==0) {
				et = new EverlandTicket(i,"빅이벤트",0);
				total += et.price;
				System.out.println("티켓번호:"+et.no+", 종류:"+et.type+", 입장료:"+et.price+", 누적:"+total);
				ticketList.add(et);
			}
			else if(i%4==0){
			et = new EverlandTicket(i,"청소년",35000);
			total += et.price;
			System.out.println("티켓번호:"+et.no+", 종류:"+et.type+", 입장료:"+et.price+", 누적:"+total);
			ticketList.add(et);
			}
			else if(i%7==0){
				et = new EverlandTicket(i,"미취학아동",18000);
				total += et.price;
				System.out.println("티켓번호:"+et.no+", 종류:"+et.type+", 입장료:"+et.price+", 누적:"+total);
				ticketList.add(et);
			}
			else {
				et = new EverlandTicket(i,"성인",50000);
				total += et.price;
				System.out.println("티켓번호:"+et.no+", 종류:"+et.type+", 입장료:"+et.price+", 누적:"+total);
				ticketList.add(et);
			}
			
		}
		System.out.println();	
		System.out.println("총액은 "+total+"원 입니다");
	}
	
}

	







