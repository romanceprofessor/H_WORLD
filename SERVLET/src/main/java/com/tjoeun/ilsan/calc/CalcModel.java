package com.tjoeun.ilsan.calc;

import javax.servlet.http.HttpServletRequest;

public class CalcModel {
	
	private static CalcModel cm;
	
	private CalcModel() {}
	public static CalcModel getInstance() {
		if ( null == cm ) {
			cm = new CalcModel();
		}
		return cm;
	}
	
	public int compute(HttpServletRequest req) {
		String num1 = req.getParameter("num1");
		String operator = req.getParameter("operator");
		String num2 = req.getParameter("num2");
		int sum = 0;
		if ("add".equals(operator)) {
			sum = Integer.parseInt(num1) + Integer.parseInt(num2);
		}
		if ("del".equals(operator)) {
			sum = Integer.parseInt(num1) - Integer.parseInt(num2);
		}
		if ("mul".equals(operator)) {
			sum = Integer.parseInt(num1) * Integer.parseInt(num2);
		}
		if ("div".equals(operator)) {
			sum = Integer.parseInt(num1) / Integer.parseInt(num2);
		}
		return sum;
	}

}
