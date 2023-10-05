package collect;

import java.util.List;
import java.util.Map;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HangzhouAsianGame hg = new HangzhouAsianGame();
		hg.setESports();
		hg.setCycle();
		System.out.println("메뉴를 선택하세요:1.게시글 보기,2.게시글 작성");
		List list = hg.searchEvent("eSports");
		for(int i =0; i<list.size();i++) {
			Map map = (Map)list.get(i);
			System.out.println("게시물 번호:"+(i+1));
			System.out.println("날짜:"+map.get("date"));
			System.out.println("시각:"+map.get("time"));
			System.out.println("제목:"+map.get("title"));
			System.out.println("-------------------------");
		}
	}

}
