package com.jsp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dao.BbsDao;
import com.jsp.dao.TransactionDao;
import com.jsp.dao.ViewDao;
import com.jsp.dto.BbsDto;
import com.jsp.dto.BbsFileDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class UpdateController extends HttpServlet{
	private String bbsID;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		bbsID=req.getParameter("id");
		BbsDao bbsDao=BbsDao.getInstance();
		BbsDto bbsDto=bbsDao.selectById(bbsID);
		
		HttpSession session=req.getSession();
		session.setAttribute("bbsupdate", bbsDto);
		
		ViewDao viewdao=ViewDao.getInstance();
		List<BbsFileDto>files=viewdao.selectById(bbsID);
		
		session.setAttribute("filesupdate", files);
		RequestDispatcher rd=req.getRequestDispatcher("WEB-INF/bbstext3.jsp");
		rd.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=req.getSession();
		String sessionID=(String) session.getAttribute("sessionID");
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		String category=req.getParameter("category");
		
		
		BbsDto bbsDto=new BbsDto();
		bbsDto.setBbsTitle(title);
		bbsDto.setBbsCategory(category);
		bbsDto.setBbsContent(content);
		bbsDto.setBbsId(bbsID);
		
		TransactionDao tdao=TransactionDao.getInstance();
		
		int resultTrans=tdao.updateAll(bbsDto);
		req.setAttribute("resultTrans", resultTrans);
		process(req, resp);
	}
	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		RequestDispatcher rd=req.getRequestDispatcher("WEB-INF/bbs.jsp");
		rd.forward(req, resp);
	}
}
