import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class jdbcselect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection c=null;
		PreparedStatement p=null;
		ResultSet r=null;
		String driverName="org.h2.Driver";
		String url="jdbc:h2:tcp://localhost/~/test";
		String user="sa";
		String password="";
		String sql="";
		
		
		try {
			Class.forName(driverName);
			c=DriverManager.getConnection(url, user, password);
			
			sql="select * from member order by id";
			p=c.prepareStatement(sql);
			r=p.executeQuery();
			while(r.next())
			{
				System.out.print(r.getInt("id"));
				System.out.print("\t"+r.getString("name"));
				System.out.println("\t"+r.getTimestamp("reg_date"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
