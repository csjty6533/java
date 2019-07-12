package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Connection {

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
}
