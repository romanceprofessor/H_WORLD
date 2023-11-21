package com.tjoeun.ilsan.calc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalcView {
	
private static CalcView cv;
	
	private CalcView() {}
	public static CalcView getInstance() {
		if ( null == cv ) {
			cv = new CalcView();
		}
		return cv;
	}

	public void display(HttpServletRequest req, HttpServletResponse res, int sum) {
//			res.setCharacterEncoding("UTF-8");
//			res.setContentType("text/html; charset=UTF-8");
//			PrintWriter printWriter = res.getWriter();
			String operator = req.getParameter("operator");
			String operKor = "";
			if ("add".equals(operator)) {
				operKor = "합";
			}
			if ("del".equals(operator)) {
				operKor = "빼기";
			}
			if ("mul".equals(operator)) {
				operKor = "곱";
			}
			if ("div".equals(operator)) {
				operKor = "나누기";
			}
//			printWriter.write("두 수의 " + operKor + "은(는) " + sum + "입니다.");
			req.setAttribute("operKor", operKor);
			req.setAttribute("sum", sum);
	}
}
