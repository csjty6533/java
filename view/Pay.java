package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import pay.Pay01;
import pay.Pay02;
import pay.Pay03;
import pay.Pay04;
import pay.Pay05;

public class Pay extends JPanel implements ActionListener{
	
	private JButton b1,b2,b3,b4,b5,submit;
	private JPanel panel;
	private CardLayout card=new CardLayout();
	private Pay01 pay01=new Pay01();
	private Pay02 pay02=new Pay02();
	private Pay03 pay03=new Pay03();
	private Pay04 pay04=new Pay04();
	private Pay05 pay05=new Pay05();
	private JLabel result;
	private static DefaultTableModel tm;
	private Table table;
	
	
	public Pay()
	{
        setLayout(null);
        
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(600, 1000));
        
        
        JScrollPane sp=new JScrollPane(panel);
        sp.setBounds(150,50,650,450);
        add(sp);
        
        table=new Table();
        table.setBounds(50, 510, 500, 140);
        //table.setOpaque(false);
     
        panel.setLayout(card);
        panel.add("01",pay01);
        panel.add("02",pay02);
        panel.add("03",pay03);
        panel.add("04",pay04);
        panel.add("05",pay05);
        
        card.show(panel, "01");
        
        b1 = new JButton("01");
        b1.setBounds(12, 50, 120, 70);
        add(b1);
        b1.setBackground(new Color(36,205,198));
        
        b2 = new JButton("02");
        b2.setBounds(12, 140, 120, 70);
        add(b2);
        b2.setBackground(new Color(36,205,198));
        
        b3 = new JButton("03");
        b3.setBounds(12, 230, 120, 70);
        add(b3);
        b3.setBackground(new Color(36,205,198));
        
        b4 = new JButton("04");
        b4.setBounds(12, 320, 120, 70);
        add(b4);
        b4.setBackground(new Color(36,205,198));
        
        b5 = new JButton("05");
        b5.setBounds(12, 410, 120, 70);
        add(b5);
        b5.setBackground(new Color(36,205,198));
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        
        result=new JLabel("0원",Label.LEFT);
        result.setBounds(570,510,220,35);
        result.setForeground(Color.white);
        result.setBackground(new Color(100,100,100));
        result.setHorizontalAlignment(SwingConstants.RIGHT);
        result.setOpaque(true);
        add(result);
        
        submit=new JButton("상품 주문하기");
        submit.setBounds(570,550,220,100);
        submit.setBackground(new Color(251,253,35));
        submit.setForeground(new Color(100,100,100));
        add(submit);
        
        add(table);
        
        
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 Object ob = e.getSource();
	        if(ob == b1) {
	            card.show(panel, "01");
	        }
	        else if(ob == b2) {
	            card.show(panel, "02");
	        }else if(ob == b3) {
	           card.show(panel, "03");
	        }else if(ob == b4) {
		           card.show(panel, "04");
		    }else if(ob == b5) {
		           card.show(panel, "05");
		    }
	}
	public class Table extends JPanel
	{
		Table()
		{
			setLayout(null);
			String colNames[]= {"상품코드","상품명","가격","개수"};
	        tm=new MyTableModel(colNames,0);
	  
	        JTable tb=new JTable(tm);
	        JScrollPane sp=new JScrollPane(tb);
	        sp.setBounds(0,0,500,150);
	        //System.out.println(tb.getColumnCount());
	        add(sp);
	        Object data[]= {"111","222",333,"444"};
	        tm.addRow(data);
	        setOpaque(true);
	        setBackground(new Color(051,051,051));
	        tb.getColumnModel().getColumn(0).setPreferredWidth(130);
	        tb.getColumnModel().getColumn(1).setPreferredWidth(250);
	        tb.getColumnModel().getColumn(2).setPreferredWidth(90);
	        tb.getColumnModel().getColumn(3).setPreferredWidth(30);
	        
		}
	}
	public DefaultTableModel getTable()
	{
		return tm;
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
}