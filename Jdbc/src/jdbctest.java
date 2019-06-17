import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class jdbctest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection c=null;
		PreparedStatement p=null;
		ResultSet r=null;
		//oracledriver name: "oracle.jdbc.OracleDriver"
		//String url="jdbc:h2:tcp://localhost/~/test";
		//String user="sa";
		//String password="";
		
		//h2db driver
		String driverName="org.h2.Driver";
		String url="jdbc:h2:tcp://localhost/~/test";
		String user="sa";
		String password="";
		
		String sql="";
		
		try {
			Class.forName(driverName);
			c=DriverManager.getConnection(url, user, password);
			sql="CREATE TABLE IF NOT EXISTS  member ("
					+ " id   INTEGER    PRIMARY KEY,"
				    + " name   VARCHAR(30),"
				    + " reg_date  TIMESTAMP"
				    + ")";
			p=c.prepareStatement(sql);//sql실행
			p.executeUpdate();//변경
			//변경ex)create,insert,update,delete->sql문이 db서버로 전송->실행
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("con");
	}

}
