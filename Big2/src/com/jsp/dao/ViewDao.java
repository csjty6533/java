package com.jsp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;

import com.jsp.dto.BbsDto;
import com.jsp.dto.BbsFileDto;
import com.jsp.dto.ChatDto;

public class ViewDao extends HttpServlet{
	private static ViewDao viewdao;
	private int result,chatresult,total;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private List<BbsFileDto> bbsList;
	private List<ChatDto> chatList;
	public static synchronized ViewDao getInstance()
	{
		if(viewdao==null)viewdao=new ViewDao();
		return viewdao;
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
	public int getTotalchat(String id)
	{
		conn=this.getConnect();
		try {
			StringBuffer query=new StringBuffer();
			query.append("select count(*) from chat  WHERE BBSID=? ");
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
	public List<BbsFileDto> selectById(String id) {

		BbsFileDto bbsfDto = new BbsFileDto();
		conn = this.getConnect();
		StringBuffer query = new StringBuffer();
		
		query.append("SELECT *");
		query.append("  FROM BBSWR");
		query.append("  WHERE KEY=? ");
		try {
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			bbsList=new ArrayList<>();
			while (rs.next()) {

				bbsfDto.setId(rs.getString("ID"));
				bbsfDto.setBbsId(rs.getString("BBSID"));
				bbsfDto.setOrgn_file_nm(rs.getString("ORGN_FILE_NM"));
				bbsfDto.setSave_file_nm(rs.getString("SAVE_FILE_NM"));
				bbsfDto.setKey(rs.getString("KEY"));
				bbsList.add(bbsfDto);
			}
		} catch (SQLException e) {

		} finally {

			this.close(conn, pstmt, null);

		}

		return bbsList;
	}
	public String select(String id) {

		String bbsfile=null;
		conn = this.getConnect();
		StringBuffer query = new StringBuffer();
		
		query.append("SELECT orgn_file_nm");
		query.append("  FROM BBSWR");
		query.append("  WHERE save_file_nm=? ");
		try {
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			bbsList=new ArrayList<>();
			if (rs.next()) {

				bbsfile=rs.getString("orgn_file_nm");
			}
		} catch (SQLException e) {

		} finally {

			this.close(conn, pstmt, null);

		}

		return bbsfile;
	}
	public List<ChatDto> selectAllChat(String bbsid)
	{
		chatList=new ArrayList<>();
		conn=this.getConnect();
		StringBuffer query=new StringBuffer();
		query.append("select chatid,id,cdate,content,bbsid from chat where bbsid=? order by chatid desc");
	
		try {
			pstmt=conn.prepareStatement(query.toString());
			pstmt.setString(1, bbsid);
			
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				ChatDto chatDto=new ChatDto();
				chatDto.setId(rs.getString("id"));
				chatDto.setDate(rs.getString("cdate"));
				chatDto.setContent(rs.getString("content"));
				chatDto.setChatId(rs.getString("chatid"));
				
				chatList.add(chatDto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			this.close(conn, pstmt, rs);
		}
		return chatList;
	}
	public int insertChat(ChatDto chatdto) {

		conn = this.getConnect();
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO chat(chatid, ID, content,cdate,bbsid)");
		query.append("  VALUES (chat_seq.nextval,? , ? ,sysdate ,?)");

		try {
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, chatdto.getId());
			pstmt.setString(2, chatdto.getContent());
			pstmt.setString(3, chatdto.getBbsid());
			chatresult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			this.close(conn, pstmt, null);

		}

		return chatresult;

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
