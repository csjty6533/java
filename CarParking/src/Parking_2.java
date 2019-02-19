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
	private int calendar,startT,endT;
	private ParkingLot instance;
	private boolean parking[][][];
	Parking_2(int a1,int a2,int a3,ParkingLot a4,int a5) 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new Page2(),BorderLayout.CENTER);
		setSize(1000,700);setVisible(true);
	}
	public Parking_2(int a1,int a2,int a3,ParkingLot a4) 
	{
		calendar=a1;
		startT=a2;
		endT=a3;
		instance =a4;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new Page2(),BorderLayout.CENTER);
		setSize(1000,700);setVisible(true);
	}
	private class Page2 extends Panel
	{
		Page2()
		{
			setLayout(null);
			
			Parking p1=new Parking();
			p1.setLocation(50,50);
			
			Schedule p2=new Schedule();
			p2.setLocation(760,50);
			p2.setSize(180,500);
			
			add(p1);add(p2);
			setSize(1000,700);
		}
	}
	private class Parking extends JPanel
	{
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
		public void paintComponent(Graphics g) 
		{ 
		    Toolkit tk = Toolkit.getDefaultToolkit(); 
		    Image img = tk.getImage("img/parking.png"); 
		    g.drawImage(img, 0, 0,650,480, this); 
		 } 
	}
	private class event_1 implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			s=(JButton)e.getSource();
			for(int j=0;j<parking[0].length;j++)
			{
				for(int k=startT;k<startT+endT+1;k++)
				{
					if(parking[calendar-1][j][k])slot[j].setBackground(Color.white);
					else break;
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
	private class Schedule extends Panel
	{
		Schedule()
		{
			GridLayout gl=new GridLayout(22,1);
			setLayout(gl);
			setBackground(Color.gray);
			JLabel title=new JLabel("time schedule");
			title.setFont(new Font("Arial",Font.PLAIN,20));
			title.setForeground(Color.white);
			add(title);
			JLabel time[]=new JLabel[20];
			for(int i=0;i<time.length;i++)
			{
				time[i]=new JLabel("");
				time[i].setFont(new Font("Arial",Font.PLAIN,20));
				add(time[i]);
			}
			JButton b=new JButton("click");
			b.setFont(new Font("Arial",Font.PLAIN,20));
			
			b.addActionListener(new event_2());
			add(b);
		}
	}
	private class event_2 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			for(int j=0;j<slot.length;j++)
			{	
				if(s.getText().equals("S"+(j+1)))
					{
					new Parking_3(calendar,startT,endT,j,instance);
						System.out.println(j);
					}		
				
			}
		}
	}	
}