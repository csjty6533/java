package com.jsp.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.BbsDto;
import com.jsp.dto.BbsFileDto;

public class TransactionDao extends HttpServlet{
	
	private static TransactionDao tdao;
	private Connection conn;
	private int result,result2;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private List<BbsDto> bbsList;
	
	public static synchronized TransactionDao getInstance()
	{
		if(tdao==null)tdao=new TransactionDao();
		return tdao;
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	public Connection getConnect()
	{
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "BIG";
		String pw = "1234";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pw);
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public int insertAll(BbsDto bbsDto,List<BbsFileDto>bbsfDto)
	{
		conn=this.getConnect();
		try
		{
			conn.setAutoCommit(false);
			result=this.insertBbs(conn,bbsDto);
			for(BbsFileDto bbsfdto: bbsfDto)
			{
				result2=this.insertfBbs(conn,bbsfdto);
			}
			if(result>0&&result2>0)conn.commit();
			else conn.rollback();
		}catch(Exception e)
		{
			
		}finally
		{
			this.close(conn,null,null);
		}
		
		return result+result2;
	}
	public int insertBbs(Connection conn,BbsDto bbsDto) {

		conn = this.getConnect();
		
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO BBS(BBSID, ID, BBSTITLE, BBSDATE, BBSCATEGORY, BBSCONTENTS, BBSHIT)");
		query.append("  VALUES (SEQ.NEXTVAL ,? ,? ,sysdate ,? ,? ,0 )");

		try {
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, bbsDto.getId());
			pstmt.setString(2, bbsDto.getBbsTitle());
			pstmt.setString(3, bbsDto.getBbsCategory());
			pstmt.setString(4, bbsDto.getBbsContent());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			this.close(conn, pstmt, null);
		}

		return result;

	}
	
	public int insertfBbs(Connection conn,BbsFileDto bbsDto) {

		conn = this.getConnect();
	
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO BBSWR(BBSID, ID, ORGN_FILE_NM, SAVE_FILE_NM, KEY)");
		query.append("  VALUES (BBS_SEQ.NEXTVAL,? ,? ,? ,(select max(bbsId) from bbs) )");

		try {
			
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, bbsDto.getId());
			System.out.println(bbsDto.getId());
			pstmt.setString(2, bbsDto.getOrgn_file_nm());
			System.out.println(bbsDto.getOrgn_file_nm());
			pstmt.setString(3, bbsDto.getSave_file_nm());
			System.out.println(bbsDto.getSave_file_nm());
			
			result2 = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			this.close(conn, pstmt, null);
		}

		return result2;

	}
	public int updateAll(BbsDto bbsDto)
	{
		conn=this.getConnect();
		try {
			conn.setAutoCommit(false);
			result=this.updateBbs(conn,bbsDto);
			
			if(result>0)conn.commit();
			else conn.rollback();
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}finally
		{
			this.close(conn, null, null);
		}return result;
	}
	public int updateBbs(Connection conn,BbsDto bbsDto)
	{
		StringBuffer query=new StringBuffer();
		query.append("UPDATE BBS SET ");
		query.append(" BBSTITLE=? ,BBSCATEGORY=?, BBSCONTENTS=?, BBSDATE=SYSDATE ");
		query.append(" WHERE BBSID=?");
		try
		{
			pstmt=conn.prepareStatement(query.toString());
			pstmt.setString(1, bbsDto.getBbsTitle());
			pstmt.setString(2, bbsDto.getBbsCategory());
			pstmt.setString(3, bbsDto.getBbsContent());
			pstmt.setString(4, bbsDto.getBbsId());
			
			result=pstmt.executeUpdate();
		}
		catch(Exception e) {};
		return result;
	}
	public int updatefBbs(Connection conn,BbsFileDto bbsDto)
	{
		StringBuffer query=new StringBuffer();
		query.append("UPDATE BBSWR SET ");
		query.append(" BBSID=?,ID=?, ORGN_FILE_NM=?, SAVE_FILE_NM=?");
		query.append(" WHERE KEY=?");
		try
		{
			pstmt=conn.prepareStatement(query.toString());
			pstmt.setString(3, bbsDto.getOrgn_file_nm());
			pstmt.setString(4, bbsDto.getSave_file_nm());
			pstmt.setString(3, bbsDto.getOrgn_file_nm());
			pstmt.setString(4, bbsDto.getSave_file_nm());
			pstmt.setString(5, bbsDto.getKey());
		
			result=pstmt.executeUpdate();
		}
		catch(Exception e) {};
		return result;
	}
	public int DeleteAll(String bbsId)
	{
		conn = this.getConnect();
		try
		{
			conn.setAutoCommit(false);
			BbsDao bbsdao=BbsDao.getInstance();
			result=bbsdao.Delete(bbsId);
			int result2=tdao.Delete(bbsId);
			if(result>0&&result2>0)conn.commit();
			else conn.rollback();
		}catch(Exception e)
		{
			
		}finally
		{
			this.close(conn, pstmt, rs);
		}
		return result;
		
	}
	public int Delete(String id)
	{
		conn = this.getConnect();
		StringBuffer query = new StringBuffer();
		
		query.append("DELETE ");
		query.append("  FROM BBSWR");
		query.append("  WHERE KEY=? ");
		try
		{
			pstmt=conn.prepareStatement(query.toString());
			pstmt.setString(1, id);
			result2=pstmt.executeUpdate();
		}catch(Exception e)
		{
			
		}finally
		{
			this.close(conn, pstmt, rs);
		}
		return result2;
	}
	public void close(Connection conn, PreparedStatement stmt, ResultSet rs) {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}

	}
}
