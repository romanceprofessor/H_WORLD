package login.model;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import cookie.CookieMaker;

public class LoginModel {

	//폼 로그인
	public static void login(HttpServletRequest req, HttpServletResponse res) {
		String userId = req.getParameter("userId");
		String userPw = req.getParameter("userPw");
		if ( "hongkd".equals(userId) && "1234".equals(userPw) ) {
			req.getSession().setAttribute("userName","홍길동");
			CookieMaker.makeCookie(res);
		} else {
			req.setAttribute("msg", "아이디 또는 비밀번호를 다시 확인해주세요.");
		}
	}
	
	//ajax 로그인
	public static String loginA(HttpServletRequest req, HttpServletResponse res) throws JsonSyntaxException, JsonIOException, IOException {
		String userName = "";
		JsonObject json = new Gson().fromJson(req.getReader(), JsonObject.class);
		System.out.println(json);
//		String userId = req.getParameter("userId");
//		String userPw = req.getParameter("userPw");
//		if ( "hongkd".equals(userId) && "1234".equals(userPw) ) {
//			userName = "hongkd";
//			req.getSession().setAttribute("userName",userName);
//			CookieMaker.makeCookie(res);
//		}
		return userName;
	}
	
	public static void logout(HttpServletRequest req, HttpServletResponse res) {
		req.getSession().removeAttribute("userName");
		CookieMaker.removeCookie(res);
	}
	
}
