package login.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginModel {

	public static void login(HttpServletRequest req) {
		String userId = req.getParameter("userId");
		String userPw = req.getParameter("userPw");
		if ( "hongkd".equals(userId) && "1234".equals(userPw) ) {
			req.getSession().setAttribute("userName","홍길동");
		} else {
			req.setAttribute("msg", "아이디 또는 비밀번호를 다시 확인해주세요.");
		}
	}
	
}
