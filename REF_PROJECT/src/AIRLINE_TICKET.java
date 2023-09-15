
public class AIRLINE_TICKET {

	String ticketNumber;
	String startTime;
	String endTime;
	String from;
	String to;
	String flightNumber;
	boolean used = false;

	void setUsed() {
		used = true;
	}

	boolean isUsed() {
		return used;
	}
}
