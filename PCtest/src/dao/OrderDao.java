package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dto.OrderDto;


public class OrderDao {

	private DB_Connection DBconn=new DB_Connection();
	private Connection conn;
	
   
	public int insert(OrderDto a1)
	{
		int count=0;
		Connection c=null;
		PreparedStatement p=null;
		String sql="";
		
		try {
			c=DBconn.getConnection();
		
			sql=" INSERT INTO orders (seat_code, product_code, order_code)";
			sql+="	VALUES (?, ?, ?)" ;
			
			p=c.prepareStatement(sql);
			p.setInt(1, a1.getSeat_code());
			p.setString(2, a1.getProduct_code());
			p.setString(3, a1.getOrder_code());
			count=p.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			DBconn.close(c,p,null);
		}
		return count;
	}
}
