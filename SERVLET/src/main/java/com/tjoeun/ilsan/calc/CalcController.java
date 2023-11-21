package com.tjoeun.ilsan.calc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalcController {
	
	private static CalcController cc;
	
	private CalcController() {}
	public static CalcController getInstance() {
		if ( null == cc ) {
			cc = new CalcController();
		}
		return cc;
	}
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if ("/calc/show.do".equals(uri)) {
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/calc/calc_compute.jsp");
			rd.forward(req, res);
		}
		if ("/calc/compute.do".equals(uri)) {
			int sum = CalcModel.getInstance().compute(req);
			CalcView.getInstance().display(req,res,sum);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/calc/calc_compute_result.jsp");
			rd.forward(req, res);
		}
	}
	
}
