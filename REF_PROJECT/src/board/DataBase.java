package board;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataBase {
	private List list = new ArrayList();
	Scanner scanner = new Scanner(System.in);
	void showList() {
		if ( 0 == list.size() ) {
			System.out.println("게시물이 없습니다.");
		}
		for ( int i = 0 ; i < list.size() ; i++ ) {
			Board board = (Board)list.get(i);
			
			System.out.print("번호:"+board.getNo());
			System.out.print(", 제목:"+board.getTitle());
			System.out.println(", 작성자:"+board.getWriter());
			
			System.out.println("-----------------------------");
			
			
			
		}
		System.out.println("게시글 번호를 입력하세요.");
		int a = scanner.nextInt();
		for	(int j =0;   j < list.size() ; j++ ) {
			Board board = (Board)list.get(j);
			
			
			
			if (a==(j+1)) {
				System.out.println("번호:"+board.getNo());
				System.out.println("제목:"+board.getTitle());
				System.out.println("내용:"+board.getContent());
				System.out.println("작성자:"+board.getWriter());
				System.out.println("작성일시:"+board.getDate());
			}
		}
		}
	
	
	
	void writeBoard() {
		Scanner scanner = new Scanner(System.in);
		Board board = new Board();
		System.out.println("제목을 입력하시오.");
		board.setTitle(scanner.nextLine());
		System.out.println("내용을 입력하시오.");
		board.setContent(scanner.nextLine());
		System.out.println("작성자를 입력하시오.");
		board.setWriter(scanner.nextLine());
		board.setNo(list.size()+1);
		board.setDate(getDate());
		list.add(board);
	}
	
	private String getDate() {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
		return dateTime.format(formatter);
	}


}
