package blog2;

import java.util.ArrayList;
import java.util.List;

public class Board {
	static DataBase db=new DataBase();
	private String Title;
	private String Content;
	private String Writer;
	private String Date;
	
	List Comment=new ArrayList();

	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getWriter() {
		return Writer;
	}
	public void setWriter(String writer) {
		Writer = db.ID;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}	
}
