package com.jsp.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dao.TransactionDao;
import com.jsp.dto.BbsDto;
import com.jsp.dto.BbsFileDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class TextController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd=req.getRequestDispatcher("WEB-INF/bbstext1.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path="C:/temp/";
		MultipartRequest mRequest=new MultipartRequest(req, path,1024*1024*50,"utf-8",new DefaultFileRenamePolicy());
		TransactionDao tdao=TransactionDao.getInstance();
		
		HttpSession session=req.getSession();
		String sessionID=null;
		if(session.getAttribute("sessionID")!=null)
		{
			sessionID=(String)session.getAttribute("sessionID");
		}
		String category=mRequest.getParameter("category");
		String title=mRequest.getParameter("title");
		String content=mRequest.getParameter("content");
		
		
		BbsDto bbsDto=new BbsDto();
		bbsDto.setId(sessionID);
		bbsDto.setBbsTitle(title);
		bbsDto.setBbsCategory(category);
		bbsDto.setBbsContent(content);
		
		List<BbsFileDto> bbsfDtoList=new ArrayList<BbsFileDto>();
		BbsFileDto bbsfDto=null;
		
		
		for(int i=1;i<50;i++)
		{
			//name[i]=new String(mRequest.getOriginalFileName("bbs_file"+i));
			
			if(mRequest.getOriginalFileName("bbs_file"+i)==null)break;
			
			//file[i]=mRequest.getFile("bbs_file"+i);
			//changeName[i]=file[i].getName();
			bbsfDto=new BbsFileDto();
			bbsfDto.setId(sessionID);
			//System.out.println(sessionID);
			bbsfDto.setOrgn_file_nm(path+mRequest.getOriginalFileName("bbs_file"+i));
			//System.out.println(mRequest.getOriginalFileName("bbs_file"+i)+path);
			bbsfDto.setSave_file_nm(path+mRequest.getFile("bbs_file"+i).getName());
			//System.out.println(path+changeName[i]);
			
			bbsfDtoList.add(bbsfDto);
		}
		
		
		int result=tdao.insertAll(bbsDto,bbsfDtoList);
		
		if(result>0)
		{
			RequestDispatcher rd=req.getRequestDispatcher("WEB-INF/bbs.jsp");
			rd.forward(req, resp);
		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("WEB-INF/home.jsp");
			rd.forward(req, resp);
		}
	}
	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		req.setCharacterEncoding("utf-8");
		
		
		RequestDispatcher rd=req.getRequestDispatcher("WEB-INF/bbstext1.jsp");
		rd.forward(req, resp);
	}
}
