package com.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dao.BbsDao;
import com.jsp.dao.TransactionDao;

public class DeleteController extends HttpServlet{
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
		String bbsId=req.getParameter("id");
		
		TransactionDao tdao=TransactionDao.getInstance();
		tdao.DeleteAll(bbsId);
		
		RequestDispatcher rd=req.getRequestDispatcher("WEB-INF/bbs.jsp");
		rd.forward(req, resp);
	}
}
