package works2;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Board {

	Scanner sc = new Scanner(System.in);
	static Run run = new Run();
	static LogInMethod lim = new LogInMethod();
	PreparedStatement ps;

	String title = null;
	String content = "";
	String writer = null;
	String date = null;

	void writeBoard() {
		System.out.println("제목을 입력해주세요.");
		title = sc.nextLine();
		System.out.println("내용을 입력해주세요.\n작성을 마치고 싶을 경우에 '종료'라고 입력해주세요.");
		String sentence;
		while (true) {
			sentence = sc.nextLine();
			if (sentence.contains("종료")) {
				break;
			}
			content += sentence + "\n";
		}
		content.replace("종료", "");
		content = content.trim();
		writer = run.name;
		date = dateBoard(null);

		String sql = "" + "INSERT INTO BOARD " + "(BOARD_TITLE,BOARD_CONTENT,BOARD_WRITER,BOARD_DATE)"
				+ "VALUES(?,?,?,?)";
		try {
			ps = run.co.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, content);
			ps.setString(3, writer);
			ps.setString(4, date);

			ps.executeUpdate();
			System.out.println("정상적으로 게시되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void readBoard() {
		List list = new ArrayList();
		String title = null;

		String sql = "SELECT BOARD_TITLE FROM BOARD";

		try {
			ps = run.co.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				list.add(rs.getString("BOARD_TITLE"));
			}
			if (list.size() == 0) {
				System.out.println("작성된 게시글이 존재하지 않습니다.");
				lim.board();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println("[" + (i + 1) + "]" + list.get(i));
		}
		int input = (sc.nextInt() - 1);
		sc.nextLine();
		title = (String) list.get(input);

		sql = "SELECT * FROM BOARD WHERE BOARD_TITLE='" + title + "'";

		try {
			ps = run.co.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				content = rs.getString("BOARD_CONTENT");
				writer = rs.getString("BOARD_WRITER");
				date = rs.getString("BOARD_DATE");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("[제목]" + title + "\n[내용]" + content + "\n[작성자]" + writer + "\n[작성시간]" + date);

	}

	void fixBoard() {
		List list = new ArrayList();
		String title = null;

		String sql = "SELECT BOARD_TITLE,BOARD_CONTENT FROM BOARD";

		try {
			ps = run.co.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				list.add(rs.getString("BOARD_TITLE"));
			}
			if (list.size() == 0) {
				System.out.println("수정할 게시글이 존재하지 않습니다.");
				lim.board();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println("[" + (i + 1) + "]" + list.get(i));
		}
		int input = (sc.nextInt() - 1);
		sc.nextLine();
		title = (String) list.get(input);

		System.out.printf("수정할 제목 입력: ");
		
		String settitle = sc.next();			
		
		System.out.printf("수정할 내용 입력: ");
		
		String content = sc.next();
		
		sql = "UPDATE BOARD SET BOARD_TITLE = ?, BOARD_CONTENT = ? WHERE BOARD_TITLE = '"+title+"'";

		try {
			ps = run.co.prepareStatement(sql);
			ps.setString(1, settitle);

			ps.setString(2, content);
		
			int rs = ps.executeUpdate();
			System.out.println(rs+"건이 정상적으로 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void deleteBoard() {
		List list = new ArrayList();
		String title = null;

		String sql = "SELECT BOARD_TITLE FROM BOARD";

		try {
			ps = run.co.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				list.add(rs.getString("BOARD_TITLE"));
			}
			if (list.size() == 0) {
				System.out.println("작성된 게시글이 존재하지 않습니다.");
				lim.board();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println("[" + (i + 1) + "]" + list.get(i));
		}
		int input = (sc.nextInt() - 1);
		sc.nextLine();
		title = (String) list.get(input);

		sql = "DELETE FROM BOARD WHERE BOARD_TITLE='" + title + "'";

		try {
			ps = run.co.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			System.out.println("정상적으로 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	String dateBoard(LocalDateTime x) {
		x = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy.MM.dd HH:mm");
		return x.format(formatter);
	}

}
