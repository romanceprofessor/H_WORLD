package blog2;

import java.sql.SQLException;
import java.util.Scanner;

public class BlogMenu {

	static LogInStatus is=new LogInStatus();
	static BlogPhase bp=new BlogPhase();
	Scanner sc=new Scanner(System.in);
	void blogMenu() throws ClassNotFoundException, SQLException, InterruptedException
	{
		
		System.out.println("[1]게시글 작성[2]게시글 조회[3]게시글 삭제[4]뒤로 가기");
		
		int input=sc.nextInt();
		sc.nextLine();
		switch (input) {
		case 1:
			bp.writeBoard();
			break;
		case 2:
			bp.readBoard();
			break;
			
		case 3:
			bp.deleteBoard();
			break;
			
		case 4:
			is.main();
			break;		
		}		
	}	
}
