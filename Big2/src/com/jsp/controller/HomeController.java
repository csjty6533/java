package com.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController extends HttpServlet{
	@Override
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
		RequestDispatcher rd=req.getRequestDispatcher("WEB-INF/home.jsp");
		rd.forward(req, resp);
	}
	private void viewHome(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException
	{
		RequestDispatcher rd=req.getRequestDispatcher("WEB-INF/home.jsp");
		rd.forward(req, rep);
	}
}
