package com.jsp.controller;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.portable.OutputStream;

import com.jsp.dao.ViewDao;

public class FileController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 //TODO Auto-generated method stub
		process(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req, resp);
	}
	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String fileId=req.getParameter("id");
		ViewDao bbsfDao=ViewDao.getInstance();
		String bbsFile=bbsfDao.select(fileId);
		
		InputStream is=null;
		java.io.OutputStream os=null;
		
		try
		{
			resp.setContentType("application/octet-stream");
			resp.setHeader("Content-Disposition", "attatchment; filename=" +bbsFile);
			
			byte b[]=new byte[1024];
			is=new FileInputStream(bbsFile);
			os= resp.getOutputStream();
			int data=0;
			while((data=is.read(b,0,b.length))!=-1)
			{
				os.write(b,0,data);
			}
			os.flush();
		}catch(Exception e) {System.out.println(e.getMessage());}
		finally{
			if(os!=null)
			{
				try
				{
					os.close();
				}catch(Exception e)
				{
					
				}
				
			}if(is!=null)
			{
				try
				{
					os.close();
				}catch(Exception e)
				{
					
				}
			}
		}
	}
}
