package com.exam.dao;
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.exam.vo.Member;

public class MemberDao {
 
	public MemberDao()
	{
		createTable();
	}
	private Connection getConnection() throws Exception//접속
	{
	
		String driverName="org.h2.Driver";
		String url="jdbc:h2:tcp://localhost/~/test";
		String user="sa";
		String password="";
		
		Class.forName(driverName);
		Connection c=DriverManager.getConnection(url, user, password);
		
		return c;
	}
	void close(Connection a1,PreparedStatement a2,ResultSet a3)//닫기
	{
		Connection c=a1;
		PreparedStatement p=a2;
		ResultSet rs=a3;
		if(rs!=null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(p!=null)
		{
			try {
				p.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(c!=null)
		{
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public void createTable()//table만들기
	{
		Connection c=null;
		PreparedStatement p=null;
		String sql="";
		try {
			c=this.getConnection();
			sql="CREATE TABLE IF NOT EXISTS  member ("
					+ " id   INTEGER    PRIMARY KEY,"
				    + " name   VARCHAR(30),"
				    + " reg_date  TIMESTAMP"
				    + ")";
			p=c.prepareStatement(sql);
			p.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			close(c,p,null);
		}
	}
	public int insert(Member a1)//insert하고 행개수 리턴
	{
		int count=0;//변경 행개수
		Connection c=null;
		PreparedStatement p=null;
		String sql="";
		
		try {
			c=getConnection();
		
			sql=" INSERT INTO member (id, name, reg_date)";
			sql+="	VALUES (?, ?, CURRENT_TIMESTAMP)" ;
			
			p=c.prepareStatement(sql);
			p.setInt(1, a1.getId());
			p.setString(2, a1.getName());
			
			count=p.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			close(c,p,null);
		}
		return count;
	}
	public int deleteAll()//delete 하고 행개수 리턴
	{
		int count=0;//변경 행개수
		Connection c=null;
		PreparedStatement p=null;
		String sql="";
		
		try {
			c=getConnection();
		
			sql="delete from member";
		
			p=c.prepareStatement(sql);
			count=p.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			close(c,p,null);
		}
		return count;
	}
	public List<Member> getMembers()//selectAll
	{
		List<Member> list=new ArrayList<Member>();
		Connection c=null;
		PreparedStatement p=null;
		ResultSet r=null;
		String sql="";
		
		try {
			c=getConnection();
			sql="select * from member order by id";
			p=c.prepareStatement(sql);
			r=p.executeQuery();
			while(r.next())
			{
				Member a1=new Member();
				a1.setId(r.getInt("id"));
				a1.setName(r.getString("name"));
				a1.setReg_Date(r.getTimestamp("reg_date"));
				list.add(a1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			close(c,p,r);
		}
		return list;
	}
	public int updateByid(Member a1)//update where id=?
	{
		Connection c=null;
		PreparedStatement p=null;
		String sql="";
		int count=0;
		try {
			c=getConnection();
			sql="update member set name=? where id=?";
			p=c.prepareStatement(sql);
			
			p.setString(1, a1.getName());
			p.setInt(2, a1.getId());
			
			count=p.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			close(c,p,null);
		}
		return count;
	}
	public Member getMemberById(int a1)//id로 한행 select
	{
		Connection c=null;
		PreparedStatement p=null;
		ResultSet r=null;
		String sql="";
		Member m=null;
		try {
			c=getConnection();
			sql="select * from member where id=?";
			p=c.prepareStatement(sql);
			p.setInt(1, a1);
			r=p.executeQuery();
			if(r.next())
			{
				Member a2=new Member();
				a2.setId(r.getInt("id"));
				a2.setName(r.getString("name"));
				a2.setReg_Date(r.getTimestamp("reg_date"));
				m=a2;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			close(c,p,r);
		}
		return m;
	}
}
