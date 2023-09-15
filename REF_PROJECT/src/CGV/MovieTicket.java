package CGV;

public class MovieTicket {
	private static String theater = "CGV";
	
	String ticketNum;
	String title;
	String date;
	String room;
	
	public MovieTicket() {
		// TODO Auto-generated constructor stub
		ticketNum = "20230912";
		title = "JAVA";
		date = "23.09.12";
		room = "7관";
	}
	
	void setTitle(String title) {
		this.title = title;
	}
	
	void setDate(String date) {
		this.date = date;
	}
	
	void setRoom(String room) {
		this.room = room;
	}
	
	void printInfo() {
		System.out.println("극장명 : " + theater);
		System.out.println("티켓번호 : " + ticketNum);
		System.out.println("제목 : " + title);
		System.out.println("날짜 : " + date);
		System.out.println("상영관 : " + room);
	}
	
	void fixTicket(int n, String info) {
		if(n==2){
			setDate(info);
		}else if(n==3){
			setTitle(info);
		}else if(n==4){
			setRoom(info);
		}
	}
	
	
}
