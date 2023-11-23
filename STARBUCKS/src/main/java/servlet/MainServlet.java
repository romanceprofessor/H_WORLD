package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import index.cotroller.IndexController;
import index.model.IndexModel;
import login.controller.LoginController;
import starbucks.controller.StarbucksController;

public class MainServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if ( -1 < uri.indexOf("/index.star")) {
			IndexController.service(req, res);
		}
		if ( -1 < uri.indexOf("/login.star")) {
			LoginController.service(req, res);
		}
		if ( -1 < uri.indexOf("/logout.star")) {
			LoginController.service(req, res);
		}
		if ( -1 < uri.indexOf("/starbucks/")) {
			StarbucksController.service(req, res);
//			boolean hasSession = IndexModel.checkSession(req);
//			if ( hasSession ) {
//			} else {
//				res.sendRedirect("/index.star");
//			}
		}
		
	}
	

}
