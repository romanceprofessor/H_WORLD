package blog2;

import java.sql.SQLException;
import java.util.Scanner;

public class LogInStatus {

	LogOutStatus os=new LogOutStatus();
	static DataBase db=new DataBase();
	BlogMenu bm=new BlogMenu();
	
	Scanner sc=new Scanner(System.in);
	static String id;
	
	void main() throws ClassNotFoundException, SQLException, InterruptedException
	{
		{
			System.out.println(id+"님 입장을 환영합니다!");
			System.out.println("[1]게시판 보기[2]로그아웃[3]회원정보 변경[4]종료");
			int input=sc.nextInt();
			sc.nextLine();
			switch (input) {
			case 1:
				bm.blogMenu();
				break;
			case 2:
				db.loginStatus=false;
				os.main();
				break;
				
			case 3:
				db.fixAccount();
				break;
				
			case 4:
				System.exit(0);
				break;				
			}
			
		}
	}
	
}
