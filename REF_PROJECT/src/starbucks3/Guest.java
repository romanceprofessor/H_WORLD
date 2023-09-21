package starbucks3;

public class Guest {
	int Guestmoney;
	public Guest(int Guestmoney) {
		this.Guestmoney = Guestmoney;
		
	}
	int lastMoney(int total) {
		return Guestmoney -total;
	}
}
