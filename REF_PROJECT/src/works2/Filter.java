package works2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import oracle.net.aso.l;

public class Filter { // 카테고리 별 검색

	private static String sql;
	static Run run=new Run();
	static PreparedStatement ps;
	static LogIn li=new LogIn();
	
	static void main() {
		try {
			Scanner sc = new Scanner(System.in);

			System.out.println("원하는 필터를 입력해주세요");
			System.out.println("[1]이름별 찾기");
			System.out.println("[2]부서별 찾기");
			System.out.println("[3]직급별 찾기");
			System.out.println("[4]뒤로 가기");
			int searchFilter = sc.nextInt();
			sc.nextLine();
			while (true) {

				if (1 == searchFilter) {
					setSql(" SELECT * " + " FROM WORKS " + " WHERE REGEXP_LIKE  ( PRO_NAME , ? ) ");
					ps= run.co.prepareStatement(getSql());

					System.out.print("이름을 입력해주세요.");
					FilterResult.result(ps);
					break;
				}
				else if (2 == searchFilter) {
					setSql(" SELECT * " + " FROM WORKS  " + " WHERE REGEXP_LIKE  ( PRO_TEAM , ? )  "); 
					ps = run.co.prepareStatement(getSql());

					System.out.print("부서를 입력해주세요.");
					FilterResult.result(ps);
					break;
				}
				else if (3 == searchFilter) {
					setSql(" SELECT * " + " FROM WORKS " + " WHERE REGEXP_LIKE  ( PRO_GRADE , ? )  "); 
					ps = run.co.prepareStatement(getSql());

					System.out.print("직급을 입력해주세요.");
					FilterResult.result(ps);
					break;
				}
				else if (4 == searchFilter) {
					break;
				}
				else {
					System.out.println("올바른 값을 입력해주세요.");
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("올바른 값을 입력해주세요.");
			main();
		} catch (SQLException e) {
			
		} catch (Exception e) {
			
		}
	}

	public static String getSql() {
		return sql;
	}

	public static void setSql(String sql) {
		Filter.sql = sql;
	}
}