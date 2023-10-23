package blog2;

import java.sql.SQLException;

public class Test {

	static DataBase db=new DataBase();
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		boolean status=db.loginStatus;
		
		LogOutStatus os=new LogOutStatus();
		LogInStatus is=new LogInStatus();
		
		while(true)
		{
			if(status==false)
			{
				try {
					try {
						os.main();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			else if(status==true)
			{
				try {
					try {
						is.main();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	
		}	
	}
}