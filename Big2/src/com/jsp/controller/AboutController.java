package com.jsp.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.jmx.snmp.Timestamp;

public class AboutController extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req, resp);
	}
	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		HttpSession session=req.getSession();
		if(session.getAttribute("sessionID")==null)
		{
			RequestDispatcher rd=req.getRequestDispatcher("WEB-INF/home2.jsp");
			rd.forward(req, resp);
		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("WEB-INF/about.jsp");
			rd.forward(req, resp);
		}
		
	}
}
