package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import dto.PayDto;
import view.Main;

public class PayDao {
	private Connection con;
	private Statement stmt;
	private ResultSet rst;
	
	public Connection getConnection() throws Exception//����
	{
		
		String driverName="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="pc";
		String password="1234";
		try {
			Class.forName(driverName);
			con=DriverManager.getConnection(url, user, password);
			//if(con!=null)System.out.println("con");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("con");
		
		return con;
	}
	void close(Connection a1,Statement a2,ResultSet a3)//�ݱ�
	{
		Connection c=a1;
		Statement s=a2;
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
		if(s!=null)
		{
			try {
				s.close();
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
	public void commit()
	{
		Connection c=null;
		PreparedStatement p=null;
		String sql="";
		
		try {
			c=getConnection();
		
			sql=" commit";
			p=c.prepareStatement(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			close(c,p,null);
		}
	}
	private void sqlRun()
	{
		String query="select * from product";
		try {
			stmt=con.createStatement();
			rst=stmt.executeQuery(query);
			
			this.close(con,stmt,rst);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int insert(PayDto a1)
	{
		int count=0;
		Connection c=null;
		PreparedStatement p=null;
		String sql="";
		
		try {
			c=getConnection();
		
			sql=" INSERT INTO currents (scode, pcode, starttime)";
			sql+="	VALUES (?, ?, ?)" ;
			
			p=c.prepareStatement(sql);
			p.setInt(1, a1.getScode());
			p.setString(2, a1.getPcode());
			p.setString(3, a1.getStarttime());
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
	
	public ArrayList select()//id�� ���� select
	{
		Connection c=null;
		PreparedStatement p=null;
		ResultSet r=null;
		String sql="";
		ArrayList<Integer>scode=new ArrayList<Integer>();
		try {
			c=getConnection();
			sql="select scode from currents";
			p=c.prepareStatement(sql);
			
			r=p.executeQuery();
			if(r.next())
			{
				scode.add(r.getInt("scode"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			close(c,p,r);
		}
		return scode;
	}
	public int insertOrder(PayDto a1)
	{
		int count=0;
		Connection c=null;
		PreparedStatement p=null;
		String sql="";
		
		try {
			c=getConnection();
		
			sql=" INSERT INTO currents (scode, pcode, starttime)";
			sql+="	VALUES (?, ?, ?)" ;
			
			p=c.prepareStatement(sql);
			p.setInt(1, a1.getScode());
			p.setString(2, a1.getPcode());
			p.setString(3, a1.getStarttime());
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
}
