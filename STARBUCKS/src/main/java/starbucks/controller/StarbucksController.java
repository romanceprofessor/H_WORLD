package starbucks.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import starbucks.model.StarbucksModel;

public class StarbucksController {

	public static void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if ( -1 < uri.indexOf("/menu.star") ) {
			req.getRequestDispatcher("/jsp/starbucks/menu.jsp").forward(req, res);
		}
		if ( -1 < uri.indexOf("/order.star") ) {
			StarbucksModel.makeFood(req);
			req.getRequestDispatcher("/jsp/starbucks/order.jsp").forward(req, res);
		}
	}
}
