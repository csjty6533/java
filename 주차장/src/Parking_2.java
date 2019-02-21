import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics; 
import java.awt.Image; 
import java.awt.Toolkit; 
public class Parking_2 extends JFrame
{
	private JFrame f;
	private ParkingLot person;
	private int index1,index2,index3,cancelindex;
	
	private JButton index4;
	private boolean parking[][][];
	//add
	Parking_2(int a1,int a2,int a3,ParkingLot a4) 
	{
		index1=a1;
		index2=a2;
		index3=a3;
		person=a4;
		f=new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("PARKINGLOT");
		f.add(new Page2());
		f.setSize(800,600);
		f.setVisible(true);
	}
	//cancel
	Parking_2(int a1,int a2,int a3,ParkingLot a4,String []a5) 
	{
		index1=a1;
		index2=a2;
		index3=a3;
		person=a4;
		f=new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("PARKINGLOT");
		f.add(new Page2(a5));
		f.setSize(800,600);
		f.setVisible(true);
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
			
			JLabel time=new JLabel("2019-1-"+index1+" "+(index2+9)+":00 ~ "+"2019/1/"+index1+" "+(index2+9+index3+1)+":00");
			time.setBounds(500,10,200,20);
			time.setForeground(Color.white);
			time.setBackground(Color.gray);
			time.setOpaque(true);
			
			add(p1);add(b);add(time);
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
			
			JLabel time=new JLabel("2019-1-"+index1+" "+(index2+9)+":00 ~ "+"2019/1/"+index1+" "+(index2+9+index3+1)+":00");
			time.setBounds(500,10,200,20);
			time.setForeground(Color.white);
			time.setBackground(Color.gray);
			time.setOpaque(true);
			
			add(p1);add(c);add(time);
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
			setLayout(null);
			parking=person.getSlot();
			JButton slot[]=new JButton[15];
		
			for(int i=0;i<slot.length;i++)
			{
				slot[i]=new JButton("S"+(i+1));
				slot[i].setOpaque(true);
				add(slot[i]);
			}
			for(int i=0;i<9;i++)slot[i].setBounds(12+i*71,40,60,110);
			
			for(int i=9;i<12;i++)slot[i].setBounds(500,260+(i-9)*71,110,60);

			for(int i=12;i<15;i++)slot[i].setBounds(35,400-(i-12)*71,110,60);	
			
			for(int j=0;j<parking[0].length;j++)
			{
				for(int k=index2;k<index2+index3+1;k++)
				{
					if(parking[index1-1][j][k])slot[j].setBackground(Color.white);	
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
				slot[j].addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent e) 
					{
						index4=(JButton)e.getSource();
						for(int j=0;j<slot.length;j++)
						{
							for(int k=index2;k<index2+index3+1;k++)	
							{
								if(!(parking[index1-1][j][k]))break;
								else{
										slot[j].setBackground(Color.white);
										if(index4.getText().equals("S"+(j+1)))index4.setBackground(Color.green);
									}	
							}
						}
					}
				});
			}
	
			setOpaque(false);
			setSize(680,500);
		}
		//cancel
		Parking(String a1[])
		{
			setLayout(null);
			JButton slot[]=new JButton[15];
		
			for(int i=0;i<slot.length;i++)
			{
				slot[i]=new JButton("S"+(i+1));
				slot[i].setOpaque(true);
				slot[i].setEnabled(false);
				slot[i].setBackground(Color.white);
				add(slot[i]);
			}
			for(int i=0;i<9;i++)slot[i].setBounds(12+i*71,40,60,110);
			
			for(int i=9;i<12;i++)slot[i].setBounds(500,260+(i-9)*71,110,57);

			for(int i=12;i<15;i++)slot[i].setBounds(35,400-(i-12)*71,110,57);	
			
			cancelindex=person.getCancel(index1, index2, index3, a1);
			slot[cancelindex].setBackground(Color.blue);
			
			setOpaque(false);
			setSize(680,500);
		}
	}
	//ADD button >parking3
		private class goPage3 implements ActionListener
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				for(int j=0;j<15;j++)
				{	
					if(index4.getText().equals("S"+(j+1)))
					{
						new Parking_3(index1,index2,index3,j,person);
						f.dispose();
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
				person.setCancelSlot(index1,index2,index3,cancelindex,id);
				new Parking_1(person);
				f.dispose();
			}
		}
	
	
}