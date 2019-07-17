package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.OrderDto;


public class OrderDao {

	private DB_Connection DBconn=new DB_Connection();
	private Connection conn;
	private ArrayList<OrderDto> orderList;
	private int cost;
	public int insert(OrderDto a1)
	{
		int count=0;
		Connection c=null;
		PreparedStatement p=null;
		String sql="";
		
		try {
			c=DBconn.getConnection();
		
			sql=" INSERT INTO orders (seat_code, product_code, order_code, order_time,cost)";
			sql+="	VALUES (?, ?, ?, sysdate, ?)" ;
			
			p=c.prepareStatement(sql);
			p.setInt(1, a1.getSeat_code());
			p.setString(2, a1.getProduct_code());
			p.setString(3, a1.getOrder_code());
			p.setInt(4, 2000);
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
	public List<OrderDto> select()
	{
		Connection c=null;
		PreparedStatement p=null;
		ResultSet r=null;
		String sql="";
		
		orderList=new ArrayList<>();
		try {
			c=c=DBconn.getConnection();
			sql="select * from orders";
			p=c.prepareStatement(sql);
			
			r=p.executeQuery();
			while(r.next())
			{
				OrderDto orderDto =new OrderDto();
				orderDto.setSeat_code(r.getInt("seat_code"));
				orderDto.setOrder_code(r.getString("order_code"));
				orderDto.setProduct_code(r.getString("product_code"));
				orderDto.setCost(r.getInt("cost"));
				orderDto.setOrder_time(r.getString("order_time"));
				orderDto.setUser_code(r.getString("user_code"));
				orderDto.setCount(r.getInt("count"));
				
				orderList.add(orderDto);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			DBconn.close(c,p,null);
		}
		return orderList;
	}
	public int selectCost(int seat_code)
	{
		
		Connection c=null;
		PreparedStatement p=null;
		ResultSet r=null;
		String sql="";
		cost=0;
		try {
			c=c=DBconn.getConnection();
			sql="select sum(cost) from orders where seat_code= ?";
		
			p=c.prepareStatement(sql);
			p.setInt(1, seat_code);
			r=p.executeQuery();
			while(r.next())cost=r.getInt("sum(cost)");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			DBconn.close(c,p,null);
		}
		return cost;
	}
	public List<OrderDto> selectByCode(int seat_code)
	{
		
		Connection c=null;
		PreparedStatement p=null;
		ResultSet r=null;
		String sql="";
		orderList=new ArrayList<>();
		try {
			c=c=DBconn.getConnection();
			sql="select * from orders where seat_code= ?";
		
			p=c.prepareStatement(sql);
			p.setInt(1, seat_code);
			r=p.executeQuery();
			while(r.next())
			{
				OrderDto orderDto =new OrderDto();
				orderDto.setSeat_code(r.getInt("seat_code"));
				orderDto.setOrder_code(r.getString("order_code"));
				orderDto.setProduct_code(r.getString("product_code"));
				orderDto.setCost(r.getInt("cost"));
				orderDto.setOrder_time(r.getString("order_time"));
				orderDto.setUser_code(r.getString("user_code"));
				orderDto.setCount(r.getInt("count"));
				
				orderList.add(orderDto);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			DBconn.close(c,p,null);
		}
		return orderList;
	}
}
