import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Movie {
	private Ticket ticket;
	private JFrame f;
	private Page1 p1;
	private Page2 p2;
	private Page3 p3;
	private Page4 p4;
	private Page5 p5;
	private Page6 p6;
	private JTextField log[];
	private String customer[];
	private int index1,index2;
	private int tslot[];
	private JButton slot;
	private boolean key,key2,key3=false,key4=false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ticket object=new Ticket();
		new Movie(object);
	}
	Movie(Ticket a1)
	{
		ticket=a1;
		f=new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(null);
		getMenu();
		p1=new Page1();
		p1.setBounds(50,50,800,500);
		f.add(p1);
		p2=new Page2();
		p2.setBounds(50,50,800,500);
		f.add(p2);
		f.setSize(1000,700);
		f.setVisible(true);
	}
	private void getMenu()
	{
		JMenuBar mb=new JMenuBar();
		JMenu m=new JMenu("return");
		JMenuItem m1=new JMenuItem("p1");
		JMenuItem m2=new JMenuItem("p2");
		m1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				p2.setVisible(false);
				p1.setVisible(true);
			}
		});
		m2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				p1.setVisible(false);
				p2.setVisible(true);
			}
		});
		m.add(m1);m.add(m2);
		mb.add(m);
		f.setJMenuBar(mb);
	}
	private class Page1 extends Panel
	{
		Page1()
		{
			setLayout(null);
			setBackground(Color.red);
			JLabel login =new JLabel("Log-in");
			login.setBounds(100,100,100,50);
			
			add(login);
			log=new JTextField[4];
			String arr[]= {"ID","PW","NAME","TEL"};
			JLabel log2[]=new JLabel [4];
			for(int i=0;i<4;i++)
			{
				log[i]=new JTextField();
				log2[i]=new JLabel(arr[i]);
				log[i].setBounds(250+(i%2)*100,200+(i/2)*40,30,30);
				log2[i].setBounds(200+(i%2)*100,200+(i/2)*40,30,30);
				add(log2[i]);
				add(log[i]);
			}
			JButton b=new JButton("login");
			b.setBounds(300,300,100,50);
			b.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					customer=new String[4];
					for(int i=0;i<customer.length;i++)customer[i]=log[i].getText();
				
					p1.setVisible(false);
					p2.setVisible(true);
				}
			});
			add(b);
			setSize(800,500);
		}
	}
	private class Page2 extends Panel
	{
		Page2()
		{
			setBackground(Color.blue);
			setLayout(null);
			
			p3=new Page3();
			p3.setBounds(10,10,500,500);
			add(p3);
			p4=new Page4();
			p5=new Page5();
			p6=new Page6();
			
			JComboBox<String> option =new JComboBox<String>();
			String a1[]= {"choose","jojo"};
			option=new JComboBox<String>(a1);
			option.setBounds(600,100,80,20);
			add(option);
			JButton b[]=new JButton[3];
			b[0]=new JButton("add");
			b[1]=new JButton("view");
			b[2]=new JButton("cancel");
			for(int i=0;i<3;i++)
			{
				b[i].setBounds(500+i*100,300,80,20);
				add(b[i]);
			}
			b[0].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(key2)
					{	
						if(index1==0)
						{
							p3.setVisible(false);
							p5.setVisible(false);
							p6.setVisible(false);
							p4.setBounds(10,10,500,500);
							p4.setVisible(true);
							p2.add(p4);
						}
						else if(index1==1)
						{
							p3.setVisible(false);
							p5.setVisible(false);
							p6.setVisible(false);
							p4.setBounds(10,10,500,500);
							p4.setVisible(true);
							p2.add(p4);
						}
					}
					if(key)
						{
							ticket.setSlotAdd(index1, index2,customer);
							p3.setVisible(true);
							p4.setVisible(false);
							key=false;
						}
				}
			});
			b[1].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(key4)
					{
						p3.setVisible(true);
						p5.setVisible(false);
						key4=false;
					}
					else
					{
						key4=true;
					if(index1==0)
					{
						p3.setVisible(false);
						p4.setVisible(false);
						p6.setVisible(false);
						p5.setBounds(10,10,500,500);
						p5.setVisible(true);
						p2.add(p5);
					}
					else if(index1==1)
					{
						p3.setVisible(false);
						p4.setVisible(false);
						p6.setVisible(false);
						p5.setBounds(10,10,500,500);
						p5.setVisible(true);
						p2.add(p5);
					}
					
				}
				}
			});
			b[2].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					if(index1==0)
					{
						p3.setVisible(false);
						p4.setVisible(false);
						p5.setVisible(false);
						p6.setBounds(10,10,500,500);
						p6.setVisible(true);
						p2.add(p6);
					}
					else if(index1==1)
					{
						p3.setVisible(false);
						p4.setVisible(false);
						p5.setVisible(false);
						p6.setVisible(false);
						p6.setBounds(10,10,500,500);
						p6.setVisible(true);
						p2.add(p6);
					}
					if(key3)
						{
							ticket.setSlotCancel(tslot[0], tslot[1]);
							p6.setVisible(false);
							p3.setVisible(true);
						}
					else key3=true;					
				}
			});
			setSize(800,500);
		}
	}
	private class Page3 extends JPanel
	{
		public void paintComponent(Graphics g) 
		{ 
		    Toolkit tk = Toolkit.getDefaultToolkit(); 
		    Image img = tk.getImage("img/star.jpg"); 
		    g.drawImage(img, 20, 30,200,380, this); 
		    Image img2 = tk.getImage("img/king.jpg"); 
		    g.drawImage(img2, 240, 30,200,380, this); 
		}
		Page3()
		{
			setLayout(null);
			
			JButton b[]=new JButton[2];
			b[0]=new JButton("starwars");
			b[1]=new JButton("the king");
			for(int i=0;i<2;i++)
			{
				b[i].setBounds(20+i*220,420,200,30);
				b[i].setBackground(Color.white);
				b[i].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						JButton b1=(JButton)e.getSource();
						for(int i=0;i<2;i++)b[i].setBackground(Color.white);
						b1.setBackground(Color.pink);
						if(b1.getText().equals(b[0].getText()))index1=0;	
						else index1=1;
						key2=true;
					}
				});
				add(b[i]);
			}
		}
	}
	private class Page4 extends Panel
	{
		Page4()
		{
			setLayout(null);
			boolean tslot[]=ticket.getSlot(index1);
			setBackground(Color.white);
			JButton slot[]=new JButton[50];
			for(int i=0;i<50;i++)
			{
				slot[i]=new JButton(i+"");
				if(tslot[i])slot[i].setBackground(Color.white);
				else
				{
					 slot[i].setBackground(Color.red);
					 slot[i].setEnabled(false);
				}
				slot[i].setBounds(20+(i%5)*100,20+(i/5)*40,60,40);
				add(slot[i]);
				slot[i].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						JButton b=(JButton)e.getSource();
						for(int i=0;i<50;i++)
							{
								if(!tslot[i])break;
								else 
									{
										slot[i].setBackground(Color.white);
										if(b.getText().equals(slot[i].getText()))
										{
											slot[i].setBackground(Color.pink);
											index2=i;
											key=true;
										}
									}
							}
					}
				});
			}
		}
		
	}
	private class Page5 extends Panel
	{
		Page5()
		{
			setLayout(null);
			boolean tslot[]=ticket.getSlot(index1);
			JButton slot[]=new JButton[50];
			for(int i=0;i<50;i++)
			{
				slot[i]=new JButton(i+"");
				slot[i].setEnabled(false);
				if(tslot[i])slot[i].setBackground(Color.white);
				else slot[i].setBackground(Color.red);
				slot[i].setBounds(20+(i%5)*100,20+(i/5)*40,60,40);
				add(slot[i]);
			}
		}
	}
	private class Page6 extends Panel
	{
		Page6()
		{
			setLayout(null);
			tslot=ticket.getSlotCancel(customer);
			setBackground(Color.white);
			JButton slot[]=new JButton[50];
			for(int i=0;i<50;i++)
			{
				slot[i]=new JButton(i+"");
				slot[i].setEnabled(false);
				slot[i].setBackground(Color.white);
				slot[i].setBounds(20+(i%5)*100,20+(i/5)*40,60,40);
				add(slot[i]);
			}
			slot[tslot[1]].setBackground(Color.blue);
		}
	}
}
