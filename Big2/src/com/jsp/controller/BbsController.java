package com.jsp.controller;

import java.util.List;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dao.BbsDao;
import com.jsp.dao.ViewDao;
import com.jsp.dto.BbsDto;
import com.jsp.dto.BbsFileDto;
import com.sun.jmx.snmp.Timestamp;
public class BbsController extends HttpServlet{
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
		int pageId;
		if(req.getParameter("pageId")==null)pageId=1;
		else pageId=Integer.parseInt(req.getParameter("pageId"));
		
		HttpSession session=req.getSession();
		session.setAttribute("currentpage", pageId);
		
		BbsDao bbsDao=BbsDao.getInstance();
		int total=bbsDao.getTotal();
		session.setAttribute("totalpage", total);
		
		int startN=(pageId-1)*10;
		int endN;
		
		if(total>startN+10)endN=startN+10;
		else endN=total;
		
		List <BbsDto>list=bbsDao.selectAll(startN,endN);
		
		req.setAttribute("list", list);
		session.setAttribute("list", list);
		
		RequestDispatcher rd=req.getRequestDispatcher("WEB-INF/bbs.jsp");
		rd.forward(req, resp);
	}
}
