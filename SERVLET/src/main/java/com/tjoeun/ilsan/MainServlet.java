package com.tjoeun.ilsan;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tjoeun.ilsan.calc.CalcController;

public class MainServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("MainServlet - doGet");
		doPost(req,res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("MainServlet - doPost");
		String uri = req.getRequestURI();
		System.out.println("uri:"+uri);
		String url = req.getRequestURL().toString();
		System.out.println("url:"+url);
		if (uri.startsWith("/calc/")) {
			CalcController.getInstance().service(req,res);
		}
		res.sendRedirect("https://is.tjoeun.co.kr/");
		
		
		
		
	}

}
