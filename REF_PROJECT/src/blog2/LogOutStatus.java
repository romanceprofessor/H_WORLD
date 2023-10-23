package blog2;

import java.sql.SQLException;
import java.util.Scanner;

public class LogOutStatus {

	static DataBase db=new DataBase();
	static BlogMenu bm=new BlogMenu();
	
	Scanner sc = new Scanner(System.in);
	
	void main() throws SQLException, ClassNotFoundException, InterruptedException {
		db.basic();
		if(db.loginStatus==false)
		{
			System.out.println("입장하려면 로그인해주세요.");
			System.out.println("[1]로그인[2]회원가입[3]비밀번호 찾기[4]종료");
			int input = sc.nextInt();
			sc.nextLine();
			switch (input) {
			case 1:
				logIn();
				break;
			case 2:
				signIn();
				break;
			case 3:
				findPassword();
				break;
			case 4:
				System.exit(0);
				break;
			}		
		}
	}
	
	void logIn() throws SQLException, ClassNotFoundException, InterruptedException
	{
		db.loginAccount();
		if(db.loginStatus==true)
		{
			bm.blogMenu();
		}
	}
	void signIn() throws SQLException
	{
		System.out.println("회원가입을 진행하시겠습니까?\n[1]네[2]아니오");
		int input=sc.nextInt();
		if(input==1)
		{
			db.makeAccount();
		}
		else if(input==2)
		{
			return;
		}
	}
	void findPassword() throws SQLException, InterruptedException
	{
		db.findPassword();
	}
	
}
