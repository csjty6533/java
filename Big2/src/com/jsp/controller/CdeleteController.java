package com.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dao.BbsDao;

public class CdeleteController extends HttpServlet{
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
		BbsDao bbsDao=BbsDao.getInstance();
		String chatId=req.getParameter("chatid");
		bbsDao.DeleteChat(chatId);
		
		RequestDispatcher rd=req.getRequestDispatcher("view.do?id="+bbsId);
		rd.forward(req, resp);
	}
}
