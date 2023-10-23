package blog2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DataBase {

	static Connection co;
	static PreparedStatement ps;
	static boolean loginStatus=false;
	static String ID;
	
	static LogInStatus is=new LogInStatus();
	Scanner sc=new Scanner(System.in);
	
	void basic() throws ClassNotFoundException, SQLException
	{
		Class.forName("oracle.jdbc.OracleDriver");
		co=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl",
				"LEE","jinwoo");
	}
	
	void makeAccount() throws SQLException
	{
		System.out.print("이름:");
		String name=sc.nextLine();
		System.out.print("사용할 아이디:");
		String id=sc.nextLine();
		System.out.print("사용할 비밀번호:");
		String password=sc.nextLine();
		System.out.print("비밀번호를 한번 더 입력하세요:");
		String password2=sc.nextLine();
		if(password.equals(password2)==false)
		{
			System.out.println("비밀번호가 일치하지 않습니다.");
			return;
		}

		System.out.print("나이:");
		int age=sc.nextInt();
		sc.nextLine();
		System.out.print("성별(남,여):");
		String gender=sc.nextLine();
		if(gender.equals("남")||gender.equals("여"))
		{					
		}
		else {
			System.out.println("(남,여) 중 하나로 입력하세요");
			return;
		}
		System.out.print("이메일 주소:");
		String email=sc.nextLine();
		if(email.contains("@")==false)
		{
			System.out.println("올바른 형식의 이메일 주소를 입력하세요.");
			return;
		}
		System.out.println("이름:"+name+" 아이디:"+id+" 나이:"+age+" 성별:"+gender+" 이메일 주소:"+email);
		System.out.println("입력한 정보가 맞습니까?\n[1]네[2]아니오");
		int input=sc.nextInt();
		sc.nextLine();
		if(input==1)
		{
			String sql = "" + "INSERT INTO MEM_INFO"
					+ "(NAME,ID,PASSWORD,AGE,GENDER,EMAIL)" 
					+ "VALUES(?,?,?,?,?,?)";
			
			ps = co.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, id);
			ps.setString(3, password);
			ps.setInt(4, age);
			ps.setString(5, gender);
			ps.setString(6, email);
		
			ps.executeUpdate();
			System.out.println("계정을 생성하는데 성공했습니다!\n가입을 축하합니다.");
			ps.close();
		}
		else if(input==2)
		{
			return;
		}
		
	}
	
	void loginAccount() throws SQLException, ClassNotFoundException, InterruptedException
	{
		System.out.println("아이디를 입력하세요");
		ID=sc.nextLine();
		is.id=ID;
		System.out.println("비밀번호를 입력하세요");
		String PW=sc.nextLine();
		
		String sql=""+
				"SELECT PASSWORD FROM MEM_INFO WHERE ID = "+"'"+ID+"'";
		ps=co.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			if(rs.getString("PASSWORD").equals(PW))
			{
				System.out.println("로그인 성공");
				loginStatus=true;
				is.main();
			}
			else
			{
				System.out.println("로그인 정보가 일치하지 않습니다.");
			}
		}	
	}

	void fixAccount() throws SQLException
	{
		System.out.println("회원정보 변경을 위해 다시 한 번 아이디를 입력해주세요.");
		ID=sc.nextLine();
		System.out.println("어떤 정보를 변경하시겠습니까?");
		System.out.println("[1]이름[2]비밀번호[3]나이[4]이메일 주소");
		int input=sc.nextInt();
		switch (input) {
		case 1:
			System.out.println("변경할 이름을 입력해주세요.");
			String name=sc.nextLine();
			
			String sql=""+"update mem_info"
					+ " set name="+"'"+name+"'"
					+ " where id="+"'"+ID+"'";
			ps=co.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			if(rs.next())
			{
				System.out.println("이름 변경에 성공했습니다.");
			}
			else if(rs.next()==false)
			{
				System.out.println("실패");
			}
			
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		}
	}
	void findPassword() throws SQLException, InterruptedException
	{
		System.out.println("아이디를 입력해주세요.");
		ID=sc.nextLine();
		System.out.println("이름을 입력해주세요.");
		String name=sc.nextLine();
		System.out.println("나이를 입력해주세요.");
		int age=sc.nextInt();
		sc.nextLine();
		System.out.println("비밀번호를 찾는 중입니다");
		for(int i=0;i<15;i++)
		{
			Thread.sleep(150);
			System.out.print(".");
		}
		
		String sql=""+
				"select password "
				+ "from mem_info "
				+ "where id="+"'"+ID+"'"
				+ " and name="+"'"+name+"'"
				+ " and age="+age;
		
		ps=co.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		rs.next();
		String password=rs.getString("PASSWORD");
		if(password!=null)
		{
			System.out.println();
			System.out.println("요청하신 비밀번호는 "+password+"입니다.");
		}
	}
	
}
