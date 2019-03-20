package com.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dao.MemberDao;

public class LoginController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/main2.jsp");
		rd.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		String id=req.getParameter("id");
		String pw=req.getParameter("pw");
		MemberDao dao=MemberDao.getInstance();
		int loginResult=dao.login(id,pw);
		if(loginResult==1)
		{
			req.setAttribute("loginResult", 1);
			HttpSession session=req.getSession();
			session.setAttribute("sessionID", id);
			RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/main.jsp");
			rd.forward(req, resp);
		}else
		{
			req.setAttribute("loginResult", 0);
			RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/main2.jsp");
			rd.forward(req, resp);
		}
	}
}
