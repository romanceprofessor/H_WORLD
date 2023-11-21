package starbucks.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import starbucks.model.StarbucksModel;

public class StarbucksController {

	public static void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if ("/starbucks/menu.star".equals(uri)) {
			req.getRequestDispatcher("/jsp/starbucks/menu.jsp").forward(req, res);
		}
		if ("/starbucks/order.star".equals(uri)) {
			StarbucksModel.makeFood(req);
			req.getRequestDispatcher("/jsp/starbucks/order.jsp").forward(req, res);
		}
	}
}
