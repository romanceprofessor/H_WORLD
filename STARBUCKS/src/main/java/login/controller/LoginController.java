package login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import index.model.IndexModel;
import login.model.LoginModel;
import starbucks.model.StarbucksModel;

public class LoginController {

	public static void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if ( -1 < uri.indexOf("/login.star") ) {
			LoginModel.login(req, res);
			req.getRequestDispatcher("/jsp/index.jsp").forward(req, res);
		}
		if ( -1 < uri.indexOf("/logout.star") ) {
			LoginModel.logout(req, res);
			req.getRequestDispatcher("/jsp/index.jsp").forward(req, res);
		}
	}
}
