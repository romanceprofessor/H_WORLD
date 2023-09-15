
/*
 * 제가 고객이 되어서 요청하는 기능을 만들어보세요.
 * 여행예약 사이트를 만들고 싶어요.
 * 구체적으로는 고객에게 여행지별 항공료, 숙박비를 알려주는거에요.
 * */


public class MY_TRAVEL {
	
	String destination; //목적지
	double planePrice;
	double hotelPerDay;
	
	double hotelPrice(double howManyDays) {
		return hotelPerDay * howManyDays;
	}
	
	double getPlane() {
		return planePrice;
	}
	
}
