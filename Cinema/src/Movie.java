import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class Movie {
	private Seat Seat;
	private Vector<Integer> add;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Seat seat =new Seat();
		new Movie(seat);
	}
	Movie(Seat a1)
	{
		Seat=a1;
		add=new Vector<Integer>();
		JFrame f=new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTabbedPane p=getTabbed();
		f.add(p);
		f.setSize(1000,700);
		f.setVisible(true);
	}
	private JTabbedPane getTabbed()
	{
		JTabbedPane pane=new JTabbedPane();
		pane.addTab("add", new Add());
		pane.addTab("view", new View());
		pane.addTab("remove", new Remove());
		
		return pane;
	}
	private class Add extends Panel
	{
		Add()
		{
			setLayout(null);
			JButton seat[]=new JButton[50];
			for(int i=0;i<50;i++)
			{
				seat[i]=new JButton();
				seat[i].setBounds(50+(i%5)*100,60+(i/5)*40,20,20);
				seat[i].setBackground(Color.white);
				if(!Seat.getSeat()[i])
				{
					seat[i].setBackground(Color.red);
					seat[i].setEnabled(false);
				}
				seat[i].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						for(int i=0;i<50;i++)
						{
							if(Seat.getSeat()[i])
							{
							if((JButton)e.getSource()==seat[i])
							{
								seat[i].setBackground(Color.green);
								if(add.size()!=0)
								{
									for(int j=0;j<add.size();j++)
									{
										if(add.get(j)==(i))
										{
											seat[i].setBackground(Color.white);
											add.remove(j);
											break;
										}
										if(j==add.size()-1)
										{
											add.add(i);
											break;
										}
									}
								}
								else 
								{
									add.add(i);
									break;
								}
							}
							}
						}
					}
				});
				add(seat[i]);
				JButton all=new JButton("all");
				all.setBounds(600,400,70,50);
				all.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(add.size()==50)
						{
							add.clear();
							for(int i=0;i<50;i++)
							{
								seat[i].setBackground(Color.white);
							}
						}
						else
						{
							for(int i=0;i<50;i++)
							{
								add.add(i);
								seat[i].setBackground(Color.green);
							}
						}
					}
				});
				add(all);
				JButton submit =new JButton("submit");
				submit.setBounds(700,400,70,50);
				submit.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Seat.add(add);
					}
				});
				add(submit);
			}
		}
	}
	private class View extends Panel
	{
		View()
		{
			setLayout(null);
			JButton seat[]=new JButton[50];
			for(int i=0;i<50;i++)
			{
				seat[i]=new JButton();
				seat[i].setBounds(50+(i%5)*100,60+(i/5)*40,20,20);
				seat[i].setBackground(Color.white);
				if(!Seat.getSeat()[i])seat[i].setBackground(Color.red);
			}
		}
	}
	private class Remove extends Panel
	{
		Remove()
		{
			
		}
	}
}
