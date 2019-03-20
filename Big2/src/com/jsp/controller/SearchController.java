package com.jsp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dao.BbsDao;
import com.jsp.dto.BbsDto;

public class SearchController extends HttpServlet{
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
		String search=req.getParameter("content");
		BbsDao bbsDao=BbsDao.getInstance();
		List<BbsDto>list=bbsDao.selectbycontent(search);
		int total=bbsDao.getsearchTotal(search);
		
		HttpSession session=req.getSession();
		session.setAttribute("search", search);
		session.setAttribute("searchdto", list);
		session.setAttribute("total", total);

		RequestDispatcher rd=req.getRequestDispatcher("WEB-INF/search.jsp");
		rd.forward(req, resp);
	}
}
