package table;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;



public class Ex02 extends JFrame implements ActionListener{
	private JPanel contentPane;
	//private JTable tb;
	private JButton b1,b2;
	private DefaultTableModel tm;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try
				{
					Ex02 frame=new Ex02();
					frame.setVisible(true);
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}

		});
	}
	public Ex02()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 20, 1000, 695);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
      
        String colNames[]= {"상품코드","상품명","가격","개수"};
        tm=new DefaultTableModel(colNames,0);
        JTable tb=new JTable(tm);
        JScrollPane sp=new JScrollPane(tb);
        sp.setBounds(200,100,400,300);
        //System.out.println(tb.getColumnCount());
        contentPane.add(sp);
        
        Object data[]= {"111","222",333,"444"};
        tm.addRow(data);
        
        b1 = new JButton("01");
        b1.setBounds(12, 10, 97, 35);
        contentPane.add(b1);
        
        b2 = new JButton("02");
        b2.setBounds(12, 110, 97, 35);
        contentPane.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob=e.getSource();
		if(ob==b1)
		{
			Object data[]= {"111","222",333,"444"};
	        tm.addRow(data);
		}else if(ob==b2)
		{
			Object data[]= {"가가가","나나나",333,"다다다"};
	        tm.addRow(data);
		}
	}
}
