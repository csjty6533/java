import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Parking_2 extends JFrame
{
	private JButton s;
	private JButton slot[][];
	private int calendar,time,hour;
	public Parking_2(int a1,int a2,int a3) 
	{
		calendar=a1;
		time=a2;
		hour=a3;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new Page2(),BorderLayout.CENTER);
		getMenu();
		setSize(1000,700);setVisible(true);
	}
	private void getMenu()
	{
		JMenuBar bar=new JMenuBar();
		JMenu menu=new JMenu("µÚ·Î");
		menu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
	
			}
		});
		bar.add(menu);
		setJMenuBar(bar);
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
	private class Parking extends Panel
	{
		Parking()
		{
			setLayout(null);
			setBackground(Color.gray);
			slot=new JButton[3][5];
		
			for(int i=0;i<slot.length;i++)
			{
				for(int j=0;j<slot[i].length;j++)
				{
					int x=i*5+j+1;
					slot[i][j]=new JButton("S"+x);
					slot[i][j].setLocation(50+j*120,50+i*140);
					slot[i][j].setSize(90,30);
					slot[i][j].setOpaque(true);
					slot[i][j].setBackground(Color.white);
					slot[i][j].addActionListener(new event_1());
					add(slot[i][j]);
				}
			}	
			setSize(680,500);
		}
	}
	private class event_1 implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			s=(JButton)e.getSource();
			for(int i=0;i<3;i++)
			{
				for(int j=0;j<5;j++)
				{
					slot[i][j].setBackground(Color.white);
					int x=i*5+j+1;
					if(s.getText().equals("S"+x))
					{
						s.setBackground(Color.green);
					}		
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
			for(int i=0;i<3;i++)
			{	for(int j=0;j<5;j++)
				{
					int x=i*5+j+1;
					if(s.getText().equals("S"+x))
					{
						new Parking_3(calendar,time,hour,x);
						System.out.println(x);
					}		
				}
			}	
		}
	}	
}
