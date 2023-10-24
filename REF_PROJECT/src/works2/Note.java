package works2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Note {

	static Run run = new Run();
	static LogInMethod lim = new LogInMethod();
	Scanner sc = new Scanner(System.in);
	PreparedStatement ps;

	String from = null;
	String to = null;
	String date = null;
	int check = 0;
	String content = "";

	void writeNote() {
		System.out.println("수신자 이름을 정확하게 입력해주세요.");
		to = sc.nextLine();
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
		from = run.name;
		date = dateNote(null);

		String sql = "" + "INSERT INTO NOTE " + "(NOTE_FROM,NOTE_TO,NOTE_DATE,NOTE_CHECK,NOTE_CONTENT)"
				+ "VALUES(?,?,?,?,?)";

		try {
			ps = run.co.prepareStatement(sql);
			ps.setString(1, from);
			ps.setString(2, to);
			ps.setString(3, date);
			ps.setInt(4, check);
			ps.setString(5, content);

			ps.executeUpdate();
			System.out.println("정상적으로 발송되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void readNote() {
		List<NoteFrame> list = new ArrayList<NoteFrame>();
		int check = 0;

		String sql = "SELECT * FROM NOTE WHERE NOTE_TO = ?";

		try {
			ps = run.co.prepareStatement(sql);
			ps.setString(1, run.name);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				NoteFrame nf = new NoteFrame();
				nf.setFrom(rs.getString(1));
				nf.setTo(rs.getString(2));
				nf.setDate(rs.getString(3));
				nf.setCheck(rs.getInt(4));
				nf.setContent(rs.getString(5));
				list.add(nf);
			}
			if (list.size() == 0) {
				System.out.println("수신한 쪽지가 없습니다.");
			}

			for (int i = 0; i < list.size(); i++) {
				NoteFrame nf = list.get(i);
				if (nf.getCheck() == 0) {
					check++;
				}
			}
			System.out.println("확인하지 않은 쪽지가 " + check + "통 있습니다.");

			for (int i = 0; i < list.size(); i++) {
				String check2 = "";
				NoteFrame nf = list.get(i);
				if (nf.getCheck() == 0) {
					check2 = " 미확인";
				} else if (nf.getCheck() == 1) {
					check2 = " 확인";
				}
				System.out.println("[" + (i + 1) + "]" + nf.getFrom() + check2);
			}
			System.out.println("[" + (list.size() + 1) + "]뒤로 가기");
			int input = (sc.nextInt() - 1);
			sc.nextLine();
			if (input == list.size()) {
				lim.note();
			}
			NoteFrame nf = list.get(input);
			System.out.println("=====================");
			System.out.println("[수신자]" + nf.getTo());
			System.out.println("[내용]:" + nf.getContent());
			System.out.println("[발신자]:" + nf.getFrom());
			System.out.println("[작성시간]" + nf.getDate());
			System.out.println("=====================");

			sql = "" + "UPDATE NOTE SET NOTE_CHECK=? WHERE NOTE_TO=?";
			ps = run.co.prepareStatement(sql);
			ps.setInt(1, 1);
			ps.setString(2, run.name);
			ps.executeUpdate();

		} catch (SQLException |IndexOutOfBoundsException e) {
			e.printStackTrace();
		}

	}

	void deleteNote() {
		List list = new ArrayList();
		String title = null;

		String sql = "SELECT NOTE_FROM FROM NOTE WHERE NOTE_TO = ?";
		
		try {
			ps = run.co.prepareStatement(sql);
			ps.setString(1, run.name);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				list.add(rs.getString("NOTE_FROM"));
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

		sql = "DELETE FROM NOTE WHERE NOTE_FROM='" + title + "'";

		try {
			ps = run.co.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			System.out.println("정상적으로 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	String dateNote(LocalDateTime x) {
		x = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy.MM.dd HH:mm");
		return x.format(formatter);
	}
}
