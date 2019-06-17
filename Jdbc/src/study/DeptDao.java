package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeptDao {
	private static DeptDao deptDao;
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private int result;
	public static synchronized DeptDao getInstance()
	{
		if(deptDao==null)deptDao=new DeptDao();
		return deptDao;
	}
	public Connection getConnect()
	{	
		String driverName="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="study";
		String password="study1234";
		
		try {
			Class.forName(driverName);
			conn=DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public int Delete(String id)
	{
		conn = this.getConnect();
		StringBuffer query = new StringBuffer();
		
		query.append("DELETE ");
		query.append("  FROM TEST ");
		query.append("  WHERE NAME=? ");
		try
		{
			pstmt=conn.prepareStatement(query.toString());
			System.out.println(result+" "+id+1);
			pstmt.setString(1, id);
			System.out.println(result+" "+id+2);
			result=pstmt.executeUpdate();
			System.out.println(result+" "+id+3);
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}finally
		{
			this.close(conn, pstmt, rs);
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
}
