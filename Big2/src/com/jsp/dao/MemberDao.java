package com.jsp.dao;

import java.sql.*;

import com.jsp.dto.BbsDto;
import com.jsp.dto.MemberDto;

import sun.security.jca.GetInstance;

public class MemberDao {
	private static MemberDao dao;
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private int result=0;
	public MemberDao()
	{
		
	}
	public static synchronized MemberDao getInstance()
	{
		if(dao==null)dao=new MemberDao();
		return dao;
	}
	public Connection getConnect() {
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

	public int join(MemberDto dto)
	{
		try
		{
			conn=getConnect();
			StringBuffer query =new StringBuffer();
			query.append(" insert into member (id,pw,name,email)");
			query.append(" values(?,?,?,?)");
			pstmt=conn.prepareStatement(query.toString());
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getEmail());
			
			result=pstmt.executeUpdate();
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}finally
		{
			closeAll(conn,null,pstmt);
		}
		return result;
	}
	public void closeAll(Connection c,ResultSet r,PreparedStatement p)
	{
		try {
			if(r!=null)r.close();
			if(p!=null)p.close();
			if(c!=null)c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int login(String id,String pw)
	{
		conn=this.getConnect();
		StringBuffer query=new StringBuffer();
		query.append("SELECT PW");
		query.append(" from member");
		query.append(" where id=?");
		try
		{
			pstmt=conn.prepareStatement(query.toString());
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				if(rs.getString("pw").equals(pw))return 1;
				else return 0;
			}
		}catch(Exception e) {}
		finally {
			closeAll(conn,rs,pstmt);
		}
		return 0;
	}
	public MemberDto selectById(String id) {
		MemberDto mDto = new MemberDto();
		conn = this.getConnect();
		StringBuffer query = new StringBuffer();
		
		query.append("SELECT *");
		query.append("  FROM MEMBER");
		query.append("  WHERE ID=? ");
		try {
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				mDto.setId(rs.getString("ID"));
				mDto.setEmail(rs.getString("EMAIL"));
				mDto.setName(rs.getString("NAME"));
				mDto.setPw(rs.getString("PW"));
			}
		} catch (SQLException e) {

		} finally {

			closeAll(conn, rs, pstmt);

		}

		return mDto;
	}
	public int update(MemberDto mDto,String id)
	{
		conn = this.getConnect();
		this.updateBBS(mDto, id);
		this.updatefBBS(mDto, id);
		this.updateChat(mDto, id);
		StringBuffer query=new StringBuffer();
		query.append("UPDATE MEMBER SET ");
		query.append(" ID=? ,PW=?, EMAIL=?");
		query.append(" WHERE ID=?");
		try
		{
			pstmt=conn.prepareStatement(query.toString());
			pstmt.setString(1, mDto.getId());
			pstmt.setString(2, mDto.getPw());
			pstmt.setString(3, mDto.getEmail());
			pstmt.setString(4, id);
			result=pstmt.executeUpdate();
		}
		catch(Exception e) {};
		return result;
	}
	public int updateBBS(MemberDto mDto,String id)
	{
		conn = this.getConnect();
		StringBuffer query=new StringBuffer();
		query.append("UPDATE BBS SET ");
		query.append(" ID=?");
		query.append(" WHERE ID=?");
		try
		{
			pstmt=conn.prepareStatement(query.toString());
			pstmt.setString(1, mDto.getId());
			pstmt.setString(2, id);
			result=pstmt.executeUpdate();
		}
		catch(Exception e) {};
		return result;
	}
	public int updatefBBS(MemberDto mDto,String id)
	{
		conn = this.getConnect();
		StringBuffer query=new StringBuffer();
		query.append("UPDATE BBSWR SET ");
		query.append(" ID=? ");
		query.append(" WHERE ID=?");
		try
		{
			pstmt=conn.prepareStatement(query.toString());
			pstmt.setString(1, mDto.getId());
			pstmt.setString(2, id);
			result=pstmt.executeUpdate();
		}
		catch(Exception e) {};
		return result;
	}
	public int updateChat(MemberDto mDto,String id)
	{
		conn = this.getConnect();
		StringBuffer query=new StringBuffer();
		query.append("UPDATE CHAT SET ");
		query.append(" ID=? ");
		query.append(" WHERE ID=?");
		try
		{
			pstmt=conn.prepareStatement(query.toString());
			pstmt.setString(1, mDto.getId());
			pstmt.setString(2, id);
			result=pstmt.executeUpdate();
		}
		catch(Exception e) {};
		return result;
	}
}
