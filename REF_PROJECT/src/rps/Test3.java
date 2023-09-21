package rps;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("가위바위보 게임에 오신걸 환영합니다");
		RockPaperScissor rps = new RockPaperScissor();
		rps.setGuestNumber();
		rps.printNumber();
		rps.winAndLose();
	}
	
}
