package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.OrderDao;
import dto.OrderDto;

public class Order extends JPanel implements ActionListener{
	private static DefaultTableModel tm;
	private Table table;
	private OrderDao orderDao=new OrderDao();
	private int code;
	private JLabel label;
	Order(int code)
	{
		setLayout(null);
        this.code=code;
        orderDao=new OrderDao();
        table=new Table();
        table.setOpaque(false);
        table.setBounds(100, 100, 700, 500);
        
        add(table,BorderLayout.CENTER);
        
	}
	public class Table extends JPanel
	{
		Table()
		{
			setLayout(null);
			label=new JLabel("Orders");
			label.setFont(new Font("FixedSys",Font.BOLD,25));
			label.setForeground(Color.black);
			label.setBounds(0, 0, 600, 50);
			add(label);
			String colNames[]= {"주문번호","상품명","가격","개수","시간"};
	        tm=new MyTableModel(colNames,0);
	  
	        JTable tb=new JTable(tm);
	        JScrollPane sp=new JScrollPane(tb);
	        sp.setBounds(0,50,600,400);
	        //System.out.println(tb.getColumnCount());
	        add(sp);
	       
	        Iterator it=orderDao.selectByCode(code).iterator();
		     
			while(it.hasNext())
			{
				
				OrderDto orderDto=(OrderDto)(it.next());
				Object data[]= {orderDto.getOrder_code(),orderDto.getProduct_code(),orderDto.getCost(),orderDto.getCount(),orderDto.getOrder_time()};
		        tm.addRow(data);
			}
	        
	        setBackground(new Color(051,051,051));
	        tb.getColumnModel().getColumn(0).setPreferredWidth(130);
	        tb.getColumnModel().getColumn(1).setPreferredWidth(250);
	        tb.getColumnModel().getColumn(2).setPreferredWidth(90);
	        tb.getColumnModel().getColumn(3).setPreferredWidth(30);
	        tb.getColumnModel().getColumn(4).setPreferredWidth(100);
		}
	}
	public class MyTableModel extends DefaultTableModel
	{
		public MyTableModel()
		{
			super();
		}
		public MyTableModel(int row,int column)
		{
			super(row,column);
		}
		public MyTableModel(String[] colNames, int i) 
		{
			super(colNames,i);
		}

		@Override
		public boolean isCellEditable(int row,int column)
		{
			return false;
		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public DefaultTableModel getTable()
	{
		return tm;
	}
	public void orderSetting() {
		
		tm.setNumRows(0);
		
		Iterator it=orderDao.selectByCode(code).iterator();
		while(it.hasNext())
		{
			OrderDto orderDto=(OrderDto)it.next();
			Object data[]= {orderDto.getOrder_code(),orderDto.getProduct_code(),orderDto.getCost(),orderDto.getCount(),orderDto.getOrder_time()};
	        tm.addRow(data);
		}
	}
}