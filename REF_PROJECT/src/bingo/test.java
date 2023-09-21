package bingo;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("홀짝게임 시작~!");
		Bingo bg = new Bingo();
		bg.setnumber();
		bg.bingogame();
		bg.winAndLose();
	}

}
