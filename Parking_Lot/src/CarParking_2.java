import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CarParking_2 extends JFrame{
	public CarParking_2()
	{
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
			p3.setLocation(800,100);
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
			JButton section[][]=new JButton[3][5];
		
			for(int i=0;i<section.length;i++)
			{
				for(int j=0;j<section[i].length;j++)
				{
					int x=i*5+j+1;
					section[i][j]=new JButton("S"+x);
					section[i][j].setLocation(50+j*120,50+i*140);
					section[i][j].setSize(70,50);
					section[i][j].setOpaque(true);
					
					add(section[i][j]);
				}
			}
			setSize(700,500);
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
			setSize(180,500);
		}
		p3(String[] a1)
		{
			
		}
	}
}
