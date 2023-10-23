package blog2;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlogPhase {

	static DataBase db=new DataBase();
	static BlogMenu bm=new BlogMenu();
	int number;
	List<Board> list=new ArrayList<Board>();
	
	String[] insult= {"fuck","idiot"};
	
	void writeBoard() throws ClassNotFoundException, SQLException, InterruptedException
	{
		Scanner sc = new Scanner(System.in);
		Board board = new Board();
		LocalDateTime WriteTime = LocalDateTime.now();

		System.out.println("제목을 입력하세요");
		board.setTitle(sc.nextLine());
		System.out.println("내용을 입력하세요");
		board.setContent(sc.nextLine());
		for(int i=0;i<insult.length;i++)
		{
			if(board.getContent().contains(insult[i]))
			{
				board.setContent("개발자에 의해 차단된 메세지입니다.");
			}
		}
		board.setDate(dateBoard(WriteTime));

		list.add(board);
		System.out.println(list.size());
		bm.blogMenu();
	}
	
	void readBoard() throws ClassNotFoundException, SQLException, InterruptedException
	{
		System.out.println(list.size());
		if (list.size() == 0) {
			System.out.println("작성된 게시글이 없습니다.");
			bm.blogMenu();
		}
		System.out.println("[0]뒤로 가기");
		for (int i = 0; i < list.size(); i++) {
			Board board = list.get(i);
			System.out.println("[" + (i + 1) + "]" + board.getTitle());
		}
		// 제목조회
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt() - 1;
		number = input;
		if (input == -1) {
			bm.blogMenu();
		}
		// 0누를경우 뒤로가기
		try {
			Board board = list.get(input);
			System.out.println("제목:" + board.getTitle());
			System.out.println("내용:" + board.getContent());
			System.out.println("닉네임:" + board.getWriter());
			if (board.Comment.size() == 0) {
				System.out.println("작성된 댓글이 없습니다.");
			} else {
				System.out.println("┌────작성된 댓글────┐");
				for (int i = 0; i < board.Comment.size(); i++) {
					System.out.println((String) board.Comment.get(i));
				}
				System.out.println("└────────────────┘");
			}

			LocalDateTime now = LocalDateTime.now();
			String nowTime = dateBoard(now);
			int nowHour = Integer.parseInt(nowTime.substring(9, 11));
			int nowMin = Integer.parseInt(nowTime.substring(12, 14));
			int writeHour = Integer.parseInt(board.getDate().substring(9, 11));
			int writeMin = Integer.parseInt(board.getDate().substring(12, 14));
			int calHour = nowHour - writeHour;
			int calMin = nowMin - writeMin;

			if (writeMin > nowMin) {
				calHour -= 1;
				calMin = nowMin + 60 - writeMin;
			}
			if (calHour == 0 && calMin == 0) {
				System.out.println("작성된 시간:방금");
			} else {
				System.out.println("작성된 시간:" + (calHour) + "시간 " + (calMin) + "분 전");
			}

//		System.out.println("현재 시각:"+nowHour+"시"+nowMin+"분");
//		System.out.println("작성된 시각:"+writeHour+"시"+writeMin+"분");
//		System.out.println(calHour+"시"+calMin);

			// 시간 계산
			System.out.println("[0]뒤로 가기");
			System.out.println("[1]댓글 달기");
			System.out.println("[2]수정 하기");
			// 정보 출력
			input = sc.nextInt();
			sc.nextLine();
			if (input == 0) {
				readBoard();
			} else if (input == 1) {
				System.out.println("댓글을 작성하세요");
				board.Comment.add(sc.nextLine());
			} else if (input == 2) {
				fixBoard();
			}
			// 댓글 작성
		} catch (IndexOutOfBoundsException e) {
		}
	}
	
	void deleteBoard() throws ClassNotFoundException, SQLException, InterruptedException
	{
		if (list.size() == 0) {
			System.out.println("작성된 게시글이 없습니다.");
			bm.blogMenu();
		}
		System.out.println("[0]뒤로 가기");
		for (int i = 0; i < list.size(); i++) {
			Board board = list.get(i);
			System.out.println("[" + (i + 1) + "]" + board.getTitle());
		}
		// 제목조회
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt() - 1;
		if (input == -1) {
			bm.blogMenu();
		}
		list.remove(input);
	}
	String dateBoard(LocalDateTime x) {
		x = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy.MM.dd HH:mm");
		return x.format(formatter);
	}

	void fixBoard() {
		Scanner sc = new Scanner(System.in);
		Board board = list.get(number);
		System.out.println("바뀔 단어를 작성하세요.");
		String str = sc.nextLine();
		System.out.println("바꿀 단어를 작성하세요.");
		String str2 = sc.nextLine();
		boolean check = board.getContent().contains(str);
		if (check == true) {
			String fix = board.getContent().replace(str, str2);
			board.setContent(fix);
		} else if (check == false) {
			System.out.println("해당 단어가 존재하지 않습니다.");
		}
	}
}
