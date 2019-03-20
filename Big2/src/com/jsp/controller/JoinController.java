package com.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dao.MemberDao;
import com.jsp.dto.MemberDto;

public class JoinController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/home2.jsp");
		rd.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		String jogakId=req.getParameter("id");
		String pw=req.getParameter("pw");
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		

		MemberDao dao=MemberDao.getInstance();
		
		MemberDto dto=new MemberDto();
		dto.setId(jogakId);
		dto.setPw(pw);
		dto.setName(name);
		dto.setEmail(email);
		int joinResult=dao.join(dto);
		
		if(joinResult>0)
		{
			req.setAttribute("joinResult", joinResult);
			HttpSession session=req.getSession();
			session.setAttribute("sessionID", jogakId);
			RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/home.jsp");
			rd.forward(req, resp);
		}
		else 
		{
			req.setAttribute("joinResult", 0);
			RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/home2.jsp");
			rd.forward(req, resp);
		}
	}
}
