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

public class RenewController extends HttpServlet{
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
		req.setCharacterEncoding("utf-8");
		HttpSession session=req.getSession();
		String id=req.getParameter("id");
		String pw=req.getParameter("pw");
		String email=req.getParameter("email");
		MemberDto mDto=new MemberDto();
		mDto.setEmail(email);
		mDto.setId(id);
		mDto.setPw(pw);
		MemberDao mdao=MemberDao.getInstance();
		mdao.update(mDto, session.getAttribute("sessionID").toString());
		session.setAttribute("sessionID", id);
		
		RequestDispatcher rd=req.getRequestDispatcher("WEB-INF/home.jsp");
		rd.forward(req, resp);
	}
	
}
