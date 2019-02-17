import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Parking_1 extends JFrame{
	private JButton b[];
	private JButton s;
	private String dateS[],timeS[];
	private JComboBox<String>dateC[];
	private int index1,index2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Parking_1();
	}
	public Parking_1()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new Container());
		setLayout(null);
		Title p1=new Title();
		p1.setSize(500,60);
		p1.setLocation(250,50);
		p1.setBackground(Color.black);
		Calendar p2=new Calendar();
		p2.setSize(370,200);
		p2.setLocation(120,200);
		p2.setBackground(Color.black);
		Date p3=new Date();
		p3.setLocation(600,200);
		add(p1);add(p2);add(p3);
		setSize(1000,700);setVisible(true);
	}
	private class Title extends Panel
	{
		Title()
		{	
			setLayout(new FlowLayout());
			JLabel title=new JLabel("PARKING SYSTEM");
			title.setFont(new Font("Arial",Font.PLAIN,30));
			title.setBackground(Color.pink);
			title.setOpaque(true);
			add(title);
		}
	}
	private class Calendar extends Panel
	{
		Calendar()
		{
			GridLayout gl=new GridLayout(6,7);
			setLayout(gl);
			for(int i=0;i<3;i++)add(new JLabel(""));
			add(new JLabel("1��"));
			for(int i=0;i<5;i++)add(new JLabel(""));
			b=new JButton[31];
			for(int i=0;i<31;i++)
			{
				b[i]=new JButton((i+1)+"");
				b[i].setBackground(Color.white);
				b[i].addActionListener(new event());
				add(b[i]);
			}
			for(int i=0;i<2;i++)add(new JLabel(""));
		}
	} 
	private class event implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			s=(JButton)e.getSource();
			for(int i=0;i<31;i++)b[i].setBackground(Color.white);
			s.setBackground(Color.green);
		}
	}
	private class Date extends Panel
	{
		Date()
		{
			setLayout(null);
			dateC=new JComboBox[2];
			dateS= new String[12];
			for(int i=0;i<dateS.length;i++)dateS[i]=new String((i+9)+":00");
			timeS=new String[6];
			for(int i=0;i<timeS.length;i++)timeS[i]=new String((i+1)+"hours");
			dateC[0]=new JComboBox<String>(dateS);
			dateC[1]=new JComboBox<String>(timeS);
			dateC[0].setLocation(10,10);
			dateC[1].setLocation(10,100);
			for(int i=0;i<2;i++)
			{
				dateC[i].setSize(200,30);
				dateC[i].setOpaque(true);
				
				add(dateC[i]);
			}
			JButton select=new JButton("SELECT");
			select.setSize(100,50);
			select.setLocation(60,200);
			select.setOpaque(true);
			select.addActionListener(new event_1());
			add(select);
			setSize(300,400);
		}
	}
	private class event_1 implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			// TODO Auto-generated method stub
			if(s.getText().isEmpty());
			else 
			{	
				dateC[0].addActionListener(new event_2());
				dateC[1].addActionListener(new event_2());
				int x=Integer.parseInt(s.getText().toString());
				new Parking_2(x,index1,index2);
				System.out.println(x+""+index1+""+index2);
			}
		}
	}
	private class event_2 implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			// TODO Auto-generated method stub
			JComboBox<String> combo=(JComboBox<String>)e.getSource();
			index1=combo.getSelectedIndex();		
		}
	}
	private class event_3 implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			// TODO Auto-generated method stub
			JComboBox<String> combo=(JComboBox<String>)e.getSource();
			index2=combo.getSelectedIndex();		
		}
	}
}
