package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Booklist {
	private Connection c;
	private Statement s;
	private ResultSet r;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Booklist b=new Booklist();
		b.sqlRun();
	}
	public Booklist()
	{	
		String driverName="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="madang";
		String password="madang";
		
		try {
			Class.forName(driverName);
			c=DriverManager.getConnection(url, user, password);
			if(c!=null)System.out.println("con");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("con");
	}
	private void sqlRun()
	{
		String query="select * from Book";
		try {
			s=c.createStatement();
			r=s.executeQuery(query);
			System.out.println("No \tBook Name \t\tPublisher \tPrice");
			while(r.next())
			{
				System.out.print(+r.getInt(1));
				System.out.print("\t"+r.getString(2));
				System.out.print("\t\t"+r.getString(3));
				System.out.println("\t\t"+r.getInt(4));
			}
			c.close();
			s.close();
			r.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
