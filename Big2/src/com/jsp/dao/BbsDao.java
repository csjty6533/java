package com.jsp.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.dto.BbsDto;
import com.jsp.dto.BbsFileDto;
import com.jsp.dto.ChatDto;
public class BbsDao {
	private static BbsDao bbsdao;
	private int result;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private List<BbsDto> bbsList;
	private List<BbsDto> searchList;
	int total;
	public static synchronized BbsDao getInstance()
	{
		if(bbsdao==null)bbsdao=new BbsDao();
		return bbsdao;
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
	public int getTotal()
	{
		conn=this.getConnect();
		try {
			StringBuffer query=new StringBuffer();
			query.append("select count(*) from bbs");
			pstmt=conn.prepareStatement(query.toString());
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				total=rs.getInt("count(*)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			this.close(conn, pstmt, rs);
		}
		return total;
	}
	public int getsearchTotal(String content)
	{
		conn=this.getConnect();
		try {
			StringBuffer query=new StringBuffer();
			query.append("select count(*) from bbs WHERE BBSCONTENTS LIKE ?");
			pstmt=conn.prepareStatement(query.toString());
			pstmt.setString(1, "%"+content+"%");
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				total=rs.getInt("count(*)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			this.close(conn, pstmt, rs);
		}
		return total;
	}
	public List<BbsDto> selectAll(int startNum,int perpage)
	{
		bbsList=new ArrayList<>();
		conn=this.getConnect();
		StringBuffer query=new StringBuffer();
		query.append("SELECT T2.*");
		query.append("  FROM (SELECT ROWNUM R2, T.*");
		query.append("  FROM (SELECT BBSID, ID ,substr(BBSTITLE, 1, 10) BBSTITLE, ");
		query.append("  BBSDATE , BBSCATEGORY, substr(BBSCONTENTS, 1, 15) 	BBSCONTENTS, BBSHIT ");
		query.append("  FROM BBS ORDER BY BBSID DESC ) T) T2");
		query.append("  WHERE T2.R2 BETWEEN ? AND ?");
	
		try {
			pstmt=conn.prepareStatement(query.toString());
			pstmt.setInt(1, startNum);
			
			pstmt.setInt(2, perpage);
			
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				BbsDto bbsDto=new BbsDto();
				bbsDto.setId(rs.getString("ID"));
				bbsDto.setBbsId(rs.getString("BBSID"));
				bbsDto.setBbsTitle(rs.getString("BBSTITLE"));
				bbsDto.setBbsDate(rs.getString("BBSDATE"));
				bbsDto.setBbsCategory(rs.getString("BBSCATEGORY"));
				bbsDto.setBbsContent(rs.getString("BBSCONTENTS"));
				bbsDto.setBbsHit(rs.getString("BBSHIT"));
	
				bbsList.add(bbsDto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			this.close(conn, pstmt, rs);
		}
		return bbsList;
	}
	
	
	public int insert(BbsDto bbsDto) {

		conn = this.getConnect();
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO BBS(BBSID, ID, BBSTITLE, BBSDATE, BBSCATEGORY, BBSCONTENTS, BBSHIT)");
		query.append("  VALUES (bbs_seq.nextval ,? ,? ,sysdate,? ,? ,0 )");

		try {
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, bbsDto.getId());
			pstmt.setString(2, bbsDto.getBbsTitle());
			pstmt.setString(3, bbsDto.getBbsCategory());
			pstmt.setString(4, bbsDto.getBbsContent());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			this.close(conn, pstmt, null);

		}

		return result;

	}

	public int insertOracle(BbsDto bbsDto) {

		conn = this.getConnect();
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO BBS(BBSID, ID, BBSTITLE, BBSDATE, BBSCATEGORY, BBSCONTENTS, BBSHIT)");
		query.append("  VALUES (SEQ.NEXTVAL ,? ,? ,NOW() ,? ,? ,0 )");

		try {
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, bbsDto.getId());
			pstmt.setString(2, bbsDto.getBbsTitle());
			pstmt.setString(3, bbsDto.getBbsCategory());
			pstmt.setString(4, bbsDto.getBbsContent());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			this.close(conn, pstmt, null);

		}

		return result;

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
	public int getBoardCount()
	{
		conn = this.getConnect();
		StringBuffer query = new StringBuffer();
		query.append("SELECT count(*)");
		query.append("  FROM BBS ");

		try {
			pstmt = conn.prepareStatement(query.toString());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return rs.getInt("count(*)");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(conn, pstmt, rs);

		}
		return -1;
	}
	public int hitUpdate(String id)
	{
		conn=this.getConnect();
		StringBuffer query=new StringBuffer();
		query.append("UPDATE BBS SET BBSHIT=BBSHIT+1 WHERE BBSID=?");
		try
		{
			pstmt=conn.prepareStatement(query.toString());
			pstmt.setString(1, id);
			result=pstmt.executeUpdate();
		}catch(Exception e)
		{
			
		}finally
		{
			this.close(conn, pstmt, null);
		}
		return result;
	}
	public BbsDto selectById(String id) {
		BbsDto bbsDto = new BbsDto();
		conn = this.getConnect();
		StringBuffer query = new StringBuffer();
		
		query.append("SELECT *");
		query.append("  FROM BBS");
		query.append("  WHERE BBSID=? ");
		try {
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				bbsDto.setId(rs.getString("ID"));
				bbsDto.setBbsId(rs.getString("BBSID"));
				bbsDto.setBbsTitle(rs.getString("BBSTITLE"));
				bbsDto.setBbsDate(rs.getString("BBSDATE"));
				bbsDto.setBbsCategory(rs.getString("BBSCATEGORY"));
				bbsDto.setBbsContent(rs.getString("BBSCONTENTS"));
				bbsDto.setBbsHit(rs.getString("BBSHIT"));

			}
		} catch (SQLException e) {

		} finally {

			this.close(conn, pstmt, null);

		}

		return bbsDto;
	}
	public int Delete(String id)
	{
		conn = this.getConnect();
		StringBuffer query = new StringBuffer();
		
		query.append("DELETE ");
		query.append("  FROM BBS");
		query.append("  WHERE BBSID=? ");
		try
		{
			pstmt=conn.prepareStatement(query.toString());
			pstmt.setString(1, id);
			result=pstmt.executeUpdate();
		}catch(Exception e)
		{
			
		}finally
		{
			this.close(conn, pstmt, rs);
		}
		return result;
	}
	public int DeleteChat(String id)
	{
		conn = this.getConnect();
		StringBuffer query = new StringBuffer();
		
		query.append("DELETE ");
		query.append("  FROM CHAT");
		query.append("  WHERE CHATID=? ");
		try
		{
			pstmt=conn.prepareStatement(query.toString());
			pstmt.setString(1, id);
			result=pstmt.executeUpdate();
		}catch(Exception e)
		{
			
		}finally
		{
			this.close(conn, pstmt, rs);
		}
		return result;
	}
	public List<BbsDto> selectbycontent(String content)
	{
		conn = this.getConnect();
		StringBuffer query = new StringBuffer();
		searchList=new ArrayList<>();
		query.append("SELECT *");
		query.append("  FROM BBS");
		query.append("  WHERE BBSCONTENTS LIKE ? ");
		try
		{
			
			pstmt=conn.prepareStatement(query.toString());
			pstmt.setString(1, "%"+content+"%");
			rs=pstmt.executeQuery();
			while (rs.next()) {
				BbsDto bbsDto = new BbsDto();
				bbsDto.setId(rs.getString("ID"));
				bbsDto.setBbsId(rs.getString("BBSID"));
				bbsDto.setBbsTitle(rs.getString("BBSTITLE"));
				bbsDto.setBbsDate(rs.getString("BBSDATE"));
				bbsDto.setBbsCategory(rs.getString("BBSCATEGORY"));
				bbsDto.setBbsContent(rs.getString("BBSCONTENTS"));
				bbsDto.setBbsHit(rs.getString("BBSHIT"));
				
				searchList.add(bbsDto);
			}
		}catch(Exception e)
		{
			
		}finally
		{
			this.close(conn, pstmt, rs);
		}
		return searchList;
	}
}
