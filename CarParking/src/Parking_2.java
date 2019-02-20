import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics; 
import java.awt.Image; 
import java.awt.Toolkit; 
public class Parking_2 extends JFrame
{
	private JButton s;
	private JButton slot[];
	private int calendar,startT,endT,getslot;
	private ParkingLot instance;
	private boolean parking[][][];
	
	//add
	public Parking_2(int a1,int a2,int a3,ParkingLot a4) 
	{
		calendar=a1;
		startT=a2;
		endT=a3;
		instance =a4;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("PARKINGLOT");
		add(new Page2());
		setSize(800,600);setVisible(true);
	}
	//cancel
	Parking_2(int a1,int a2,int a3,ParkingLot a4,String []a5) 
	{
		calendar=a1;
		startT=a2;
		endT=a3;
		instance =a4;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("PARKINGLOT");
		add(new Page2(a5));
		setSize(800,600);setVisible(true);
	}
	
	private class Page2 extends Panel
	{
		//add
		Page2()
		{
			setLayout(null);
			
			Parking p1=new Parking();
			p1.setLocation(40,30);
			
			JButton b=new JButton("add");
			b.setFont(new Font("Arial",Font.PLAIN,18));
			b.setBounds(695,470,70,40);
			b.addActionListener(new goPage3());
			
			add(p1);add(b);
			setSize(800,600);
		}
		//cancel
		Page2(String []a1)
		{
			setLayout(null);
			
			Parking p1=new Parking(a1);
			p1.setLocation(40,30);
			
			JButton c=new JButton("OK");
			c.setFont(new Font("Arial",Font.PLAIN,18));
			c.setBounds(695,470,70,40);
			c.addActionListener(new goPage1(a1));
			
			add(p1);add(c);
			setSize(800,600);
		}
	}
	private class Parking extends JPanel
	{
		public void paintComponent(Graphics g) 
		{ 
		    Toolkit tk = Toolkit.getDefaultToolkit(); 
		    Image img = tk.getImage("img/parking.png"); 
		    g.drawImage(img, 0, 0,650,480, this); 
		}
		//add
		Parking()
		{
			parking=instance.getSlot();
			setLayout(null);
			slot=new JButton[15];
		
			for(int i=0;i<slot.length;i++)
			{
				slot[i]=new JButton("S"+(i+1));
				slot[i].setOpaque(true);
				
				slot[i].addActionListener(new event_1());
				add(slot[i]);
			}
			for(int i=0;i<9;i++)slot[i].setBounds(12+i*71,40,60,110);
			
			for(int i=9;i<12;i++)slot[i].setBounds(500,260+(i-9)*71,110,60);

			for(int i=12;i<15;i++)slot[i].setBounds(35,400-(i-12)*71,110,60);	
			
			for(int j=0;j<parking[0].length;j++)
				{
					for(int k=startT;k<startT+endT+1;k++)
					{
						if(parking[calendar-1][j][k])slot[j].setBackground(Color.white);	
						else 
						{
							slot[j].setBackground(Color.red);
							slot[j].setEnabled(false);
							break;
						}
					}
				}
			setOpaque(false);
			setSize(680,500);
		}
		//cancel
		Parking(String a1[])
		{
			setLayout(null);
			slot=new JButton[15];
		
			for(int i=0;i<slot.length;i++)
			{
				slot[i]=new JButton("S"+(i+1));
				slot[i].setOpaque(true);
				slot[i].setEnabled(false);
				slot[i].setBackground(Color.white);
				add(slot[i]);
			}
			for(int i=0;i<9;i++)slot[i].setBounds(12+i*71,40,60,110);
			
			for(int i=9;i<12;i++)slot[i].setBounds(500,260+(i-9)*71,110,60);

			for(int i=12;i<15;i++)slot[i].setBounds(35,400-(i-12)*71,110,60);	
			
			getslot=instance.getCancel(calendar, startT, endT, a1);
			slot[getslot].setBackground(Color.blue);
			setOpaque(false);
			setSize(680,500);
		}
	}
	//slot-button event
	private class event_1 implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			parking=instance.getSlot();
			s=(JButton)e.getSource();
			for(int j=0;j<parking[0].length;j++)
			{
				for(int k=startT;k<startT+endT+1;k++)
				{
					if(parking[calendar-1][j][k])slot[j].setBackground(Color.white);
					else 
					{
						slot[j].setBackground(Color.red);
						slot[j].setEnabled(false);
						break;
					}
				}
			}
			for(int j=0;j<slot.length;j++)
			{
				for(int k=startT;k<startT+endT+1;k++)	
				{
					if(s.getText().equals("S"+(j+1))&&parking[calendar-1][j][k])s.setBackground(Color.green);	
				}
			}
		}	
	}
	//ADD button >parking3
	private class goPage3 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			for(int j=0;j<slot.length;j++)
			{	
				if(s.getText().equals("S"+(j+1)))
				{
					new Parking_3(calendar,startT,endT,j,instance);
					System.out.println((j+1)+"");
				}		
			
			}
		}
	}
	//CANCEL button >parking1
	private class goPage1 implements ActionListener
	{
		private String id[];
		goPage1(String a1[])
		{
			id=new String[a1.length];
			for(int i=0;i<a1.length;i++)id[i]=a1[i];
		}
		public void actionPerformed(ActionEvent e) 
		{
			instance.setCancelSlot(calendar,startT,endT,getslot,id);
			new Parking_1(instance);
			System.out.println((getslot+1)+"");
		}
	}
}