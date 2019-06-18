package pc;

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
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Pay extends JFrame implements ActionListener{
	private static Pay frame;
	private JPanel contentPane;
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
	
	public Pay getInstance()
	{
		return frame;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try
				{
					frame=new Pay();
					frame.setVisible(true);
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}

		});
	}
	public Pay()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 20, 1000, 800);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(600, 1000));//150, 100, 650, 450
        panel.setBackground(new Color(051,051,051));
        
        JScrollPane sp=new JScrollPane(panel);
        sp.setBounds(150,100,650,450);
        contentPane.add(sp);
        
        table=new Table();
        table.setBounds(150, 570, 450, 450);
        
        panel.setLayout(card);
        panel.add("01",pay01);
        panel.add("02",pay02);
        panel.add("03",pay03);
        panel.add("04",pay04);
        panel.add("05",pay05);
        
        card.show(panel, "01");
        
        b1 = new JButton("01");
        b1.setBounds(12, 110, 120, 70);
        contentPane.add(b1);
        b1.setBackground(new Color(051,102,255));
        
        b2 = new JButton("02");
        b2.setBounds(12, 210, 120, 70);
        contentPane.add(b2);
        b2.setBackground(new Color(051,102,255));
        
        b3 = new JButton("03");
        b3.setBounds(12, 310, 120, 70);
        contentPane.add(b3);
        b3.setBackground(new Color(051,102,255));
        
        b4 = new JButton("04");
        b4.setBounds(12, 410, 120, 70);
        contentPane.add(b4);
        b4.setBackground(new Color(051,102,255));
        
        b5 = new JButton("05");
        b5.setBounds(12, 510, 120, 70);
        contentPane.add(b5);
        b5.setBackground(new Color(051,102,255));
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        
        result=new JLabel("0원",Label.LEFT);
        result.setBounds(570,570,220,40);
        result.setForeground(Color.white);
        result.setBackground(Color.black);
        result.setOpaque(true);
        contentPane.add(result);
        
        submit=new JButton("상품 주문하기");
        submit.setBounds(570,620,220,100);
        submit.setBackground(new Color(204,000,051));
        contentPane.add(submit);
        
        contentPane.add(table);
        
        contentPane.setBackground(new Color(051,051,051));
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
	        tm=new DefaultTableModel(colNames,0);
	        JTable tb=new JTable(tm);
	        JScrollPane sp=new JScrollPane(tb);
	        sp.setBounds(0,0,400,150);
	        //System.out.println(tb.getColumnCount());
	        add(sp);
	        Object data[]= {"111","222",333,"444"};
	        tm.addRow(data);
	        setOpaque(false);
		}
	}
	public DefaultTableModel getTable()
	{
		return tm;
	}
}
