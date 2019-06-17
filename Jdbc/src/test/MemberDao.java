package test;

import java.sql.*;



public class MemberDao {
	static Connection c=null;
	PreparedStatement p=null;
	int result=0;
	public static Connection getConnect()
	{
		String driverName="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="BIG";
		String password="1234";
		try {
			Class.forName(driverName);
			c=DriverManager.getConnection(url, user, password);
			
			System.out.println("con");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());;
		}
		return c;
	}
	public static void main(String[] args) 
	{
		c=getConnect();
	}
}