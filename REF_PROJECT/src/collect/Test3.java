package collect;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		int d;

		LocalDateTime dateTime = LocalDateTime.now();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

		NoticeBorad nb = new NoticeBorad();
		Scanner ss = new Scanner(System.in);
		nb.setnote();

		boolean e = true;
		
		while (e == true) {
			System.out.println("메뉴를 선택하세요:1.게시글 보기,2.게시글 작성,3.종료");
			d = ss.nextInt();
			if (d == 1) {
				List list = nb.searchEvent("note");
				for (int i = 0; i < list.size(); i++) {
					Map map = (Map) list.get(i);
					System.out.println("게시물 번호:" + (i + 1));
					System.out.println("제목:" + map.get("Title"));
					System.out.println("내용:" + map.get("contain"));
					System.out.println("작성자명:" + map.get("name"));
					System.out.println(dateTime.format(formatter));
					System.out.println("-------------------------");
				}
				
			}
			else if (d == 2) {
			nb.writenote();
			List list = nb.searchEvent("작성");
			int i = 0;
				Map map = (Map) list.get(i);
				System.out.println("게시물 번호:" + (i + 1));
				i++;
				System.out.println("제목:" + map.get("Title"));
				System.out.println("내용:" + map.get("contain"));
				System.out.println("작성자명:" + map.get("name"));
				System.out.println(dateTime.format(formatter));
				System.out.println("-------------------------");
				
			
			}
			else if (d==3) {
				break;
			}
			
		}
	}
}
