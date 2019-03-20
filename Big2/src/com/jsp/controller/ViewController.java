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
import com.jsp.dao.ViewDao;
import com.jsp.dto.BbsDto;
import com.jsp.dto.BbsFileDto;
import com.jsp.dto.ChatDto;


public class ViewController extends HttpServlet{
	
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
		
		String chatcontent = null;
		String bbsId=req.getParameter("id");		
		String sessionID = null;
		
		BbsDao bbsDao=BbsDao.getInstance();
		ViewDao viewdao=ViewDao.getInstance();
		BbsDto bbsDto=new BbsDto();
		
		int result=bbsDao.hitUpdate(bbsId);
		bbsDto=bbsDao.selectById(bbsId);
		//req.setAttribute("bbsview", bbsDto);
		session.setAttribute("bbsview", bbsDto);
		
		if(session.getAttribute("sessionID")!=null)
		{
			sessionID=(String)session.getAttribute("sessionID");
		}
		if(req.getParameter("chatcontent")!=null)chatcontent=req.getParameter("chatcontent");
		else System.out.println("null");
		if(chatcontent!=null&&sessionID!=null) 
				{
					ChatDto chatDto=new ChatDto();
					chatDto.setId(sessionID);
					System.out.println(sessionID);
					chatDto.setContent(chatcontent);
					System.out.println(chatcontent);
					chatDto.setBbsid(bbsId);
					System.out.println(bbsId);
					viewdao.insertChat(chatDto);
				}
				List<ChatDto> chatfiles=viewdao.selectAllChat(bbsId);
				session.setAttribute("chatlist", chatfiles);
		
		List<BbsFileDto>files=viewdao.selectById(bbsId);
		//req.setAttribute("files", files);
		session.setAttribute("filesview", files);
		RequestDispatcher rd=req.getRequestDispatcher("WEB-INF/bbstext2.jsp");
		rd.forward(req, resp);
		
	}
}
