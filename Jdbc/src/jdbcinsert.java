import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class jdbcinsert {

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
		int id=3;//Integer.parseInt("1");
		String name="¼ÛÇý±³";
		
		try {
			Class.forName(driverName);
			c=DriverManager.getConnection(url, user, password);
			sql=" INSERT INTO member (id, name, reg_date)";
			sql+="	VALUES (?, ?, CURRENT_TIMESTAMP)" ;
			p=c.prepareStatement(sql);
			p.setInt(1, id);
			p.setString(2, name);
			
			int count=p.executeUpdate();
			System.out.println(count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
