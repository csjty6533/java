import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CarParking_2 extends JFrame{
	private JButton section[][];
	private JButton chooseB;
	private Month month;
	public CarParking_2(Month a1)
	{
		month=a1;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new SchedulePanel());
		setSize(1000,700);setVisible(true);
	}
	private class SchedulePanel extends Panel
	{
		SchedulePanel()
		{
			setLayout(null);
			p2 p2=new p2();
			p2.setLocation(30,100);
			add(p2);
			p3 p3=new p3();
			p3.setLocation(760,100);
			add(p3);
			setBackground(Color.pink);
		}
	}
	private class p2 extends Panel
	{
		p2()
		{
			setLayout(null);
			setBackground(Color.gray);
			section=new JButton[3][5];
		
			for(int i=0;i<section.length;i++)
			{
				for(int j=0;j<section[i].length;j++)
				{
					int x=i*5+j+1;
					section[i][j]=new JButton("S"+x);
					section[i][j].setLocation(50+j*120,50+i*140);
					section[i][j].setSize(90,30);
					section[i][j].setOpaque(true);
					section[i][j].setBackground(Color.white);
					section[i][j].addActionListener(new event());
					add(section[i][j]);
				}
			}
			
			setSize(680,500);
		}
		p2(String[] a1)
		{
			
		}
	}
	private class p3 extends Panel
	{
		p3()
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
			setSize(180,480);
		}
		p3(String[] a1)
		{
			
		}
	}
	private class event implements ActionListener//주차 자리 선택 2번 페이지
	{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			chooseB=(JButton)e.getSource();
			for(int i=0;i<3;i++)
			{
				for(int j=0;j<5;j++)
				{
					section[i][j].setBackground(Color.white);
					int x=i*5+j+1;
					if(chooseB.getText().equals("S"+x))
					{
						chooseB.setBackground(Color.green);
					}		
				}
			}
		}
		
	}
	private class event_2 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			for(int i=0;i<section.length;i++)
			{
				for(int j=0;j<section[i].length;j++)
				{
					int x=i*5+j+1;
					if(chooseB.getText().equals("S"+x))
					{
						new Scheduler(section[i][j],month);
					}
				}
			}
		}
		
	}
}
